/**
 * 
 */
package org.banking.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)

public class AccountNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6610900343319260548L;


	public AccountNotFoundException(String message) {
		super(message);
	}

}
