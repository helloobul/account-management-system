/**
 * 
 */
package org.banking.account.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
public class AccountWithdrawalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6348810711973767087L;
	@NotNull
	private Long accountNumber;

	@NotNull
	private String accountType;

	@NotNull
	private BigDecimal withdrawalAmount;

	@JsonIgnore
	private LocalDateTime date = LocalDateTime.now();
	
	@NotNull
	private String description;


	/**
	 * @return the accountNumber
	 */
	public Long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the withdrawalAmount
	 */
	public BigDecimal getWithdrawalAmount() {
		return withdrawalAmount;
	}

	/**
	 * @param withdrawalAmount
	 *            the withdrawalAmount to set
	 */
	public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
