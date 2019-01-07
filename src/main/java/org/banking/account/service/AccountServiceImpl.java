/**
 * 
 */
package org.banking.account.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.banking.account.entity.Account;
import org.banking.account.entity.AccountHistory;
import org.banking.account.exception.AccountNotFoundException;
import org.banking.account.exception.InSufficientFundsException;
import org.banking.account.model.AccountCreateDTO;
import org.banking.account.model.AccountDTO;
import org.banking.account.model.AccountDepositDTO;
import org.banking.account.model.AccountWithdrawalDTO;
import org.banking.account.repository.AccountHistRepository;
import org.banking.account.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountHistRepository accountHistRepository;

	@Override
	public AccountDTO createAccount(AccountCreateDTO accountCreateDTO) {
		Account account = new Account();

		account.setAccountBalance(accountCreateDTO.getInitialDepositAmount());
		account.setAccountType(accountCreateDTO.getAccountType());

		account = accountRepository.save(account);

		ModelMapper mapper = new ModelMapper();
		return mapper.map(account, AccountDTO.class);
	}

	@Override
	public AccountDTO getAccountDetails(Long accountNumber) {
		Optional<Account> optAcc = accountRepository.findById(accountNumber);
		Account account = optAcc
			.orElseThrow(() -> new AccountNotFoundException("Account Not found. account number - " + accountNumber));
		ModelMapper mapper = new ModelMapper();
		return mapper.map(account, AccountDTO.class);
	}

	private AccountDTO updateAccount(AccountDTO accountDto) {
		ModelMapper mapper = new ModelMapper();
		Account account = accountRepository.save(mapper.map(accountDto, Account.class));
		return mapper.map(account, AccountDTO.class);
	}

	private AccountDTO updateAccountHist(AccountDTO accountDto) {
		ModelMapper mapper = new ModelMapper();
		AccountHistory accountHist = accountHistRepository.save(mapper.map(accountDto, AccountHistory.class));
		accountHistRepository.findAll().stream().forEach(
				e -> System.out.println(e.getDate() + ", Description:" + e.getDescription()));
		;

		return mapper.map(accountHist, AccountDTO.class);
	}

	@Override
	public AccountDTO accountWithdrawal(AccountWithdrawalDTO withdrawalDto) {

		AccountDTO accountDto = getAccountDetails(withdrawalDto.getAccountNumber());

		BigDecimal balance = accountDto.getAccountBalance();
		BigDecimal remainingBalance = balance.subtract(withdrawalDto.getWithdrawalAmount());

		if (remainingBalance.compareTo(BigDecimal.ZERO) <= 0) {
			throw new InSufficientFundsException(
					"Balance is insufficient for a withdrawal. Account Id : " + accountDto.getAccountNumber());
		}

		accountDto.setAccountBalance(remainingBalance);
		accountDto.setWithdrawal(withdrawalDto.getWithdrawalAmount());
		accountDto.setDescription(withdrawalDto.getDescription());
		accountDto.setDate(LocalDateTime.now());
		updateAccount(accountDto);
		return updateAccountHist(accountDto);
	}

	@Override
	public AccountDTO accountDeposit(AccountDepositDTO depositDto) {
		AccountDTO accountDto = getAccountDetails(depositDto.getAccountNumber());

		BigDecimal balance = accountDto.getAccountBalance();

		accountDto.setAccountBalance(balance.add(depositDto.getDepositAmount()));
		accountDto.setDeposit(depositDto.getDepositAmount());
		accountDto.setDescription(depositDto.getDescription());
		accountDto.setDate(LocalDateTime.now());

		updateAccount(accountDto);
		return updateAccountHist(accountDto);
	}

	@Override
	public void closeAccount(Long accountNumber) {
		accountRepository.deleteById(accountNumber);
	}

	@Override
	public BigDecimal getAccountBalance(Long accountNumber) {
		return getAccountDetails(accountNumber).getAccountBalance();
	}

}
