/**
 * 
 */
package org.banking.account.controller;

import java.math.BigDecimal;
import java.net.URI;

import javax.validation.Valid;

import org.banking.account.model.AccountCreateDTO;
import org.banking.account.model.AccountDTO;
import org.banking.account.model.AccountDepositDTO;
import org.banking.account.model.AccountWithdrawalDTO;
import org.banking.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping(path = "/account/{accountNumber}")
	public ResponseEntity<AccountDTO> getAccountDetails(@PathVariable Long accountNumber) {
		return new ResponseEntity<AccountDTO>(accountService.getAccountDetails(accountNumber), HttpStatus.OK);
	}

	@GetMapping(path = "/account/balance/{accountNumber}")
	public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable Long accountNumber) {
		return new ResponseEntity<BigDecimal>(accountService.getAccountBalance(accountNumber), HttpStatus.OK);
	}

	@PostMapping(path = "/account/create")
	public ResponseEntity<AccountDTO> createAccount(@RequestBody @Valid AccountCreateDTO accountCreateDTO) {
		AccountDTO account = accountService.createAccount(accountCreateDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(account.getAccountNumber())
			.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/account/{accountNumber}")
	public ResponseEntity<?> closeAccount(@PathVariable Long accountNumber) {
		accountService.closeAccount(accountNumber);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}

	@PutMapping(path = "/account/withdrawal")
	public ResponseEntity<AccountDTO> accountWithdrawal(@RequestBody AccountWithdrawalDTO withDrawal) {
		return new ResponseEntity<AccountDTO>(accountService.accountWithdrawal(withDrawal), HttpStatus.OK);
	}

	@PutMapping(path = "/account/deposit")
	public ResponseEntity<AccountDTO> accountDeposit(@RequestBody AccountDepositDTO deposit) {
		return new ResponseEntity<AccountDTO>(accountService.accountDeposit(deposit), HttpStatus.OK);
	}

}
