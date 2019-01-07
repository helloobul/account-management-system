/**
 * 
 */
package org.banking.account.service;

import java.math.BigDecimal;

import org.banking.account.model.AccountCreateDTO;
import org.banking.account.model.AccountDTO;
import org.banking.account.model.AccountDepositDTO;
import org.banking.account.model.AccountWithdrawalDTO;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
public interface AccountService {

	public AccountDTO createAccount(AccountCreateDTO accountCreateDTO);

	public AccountDTO getAccountDetails(Long accountNumber);

	public void closeAccount(Long accountNumber);

	public BigDecimal getAccountBalance(Long accountNumber);

	public AccountDTO accountWithdrawal(AccountWithdrawalDTO withdrawal);

	public AccountDTO accountDeposit(AccountDepositDTO deposit);

}
