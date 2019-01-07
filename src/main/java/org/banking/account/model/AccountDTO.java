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
public class AccountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6348810711973767087L;

	private Long accountNumber;
	
	@NotNull
	private String accountType;
	
	private BigDecimal accountBalance;
	
	private BigDecimal withdrawal;
	
	private BigDecimal deposit;
	
	private String description;
	
	
	@JsonIgnore
	private LocalDateTime date = LocalDateTime.now();



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}




	/**
	 * @return the accountBalance
	 */
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	/**
	 * @return the accountNumber
	 */
	public Long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the withdrawal
	 */
	public BigDecimal getWithdrawal() {
		return withdrawal;
	}

	/**
	 * @param withdrawal the withdrawal to set
	 */
	public void setWithdrawal(BigDecimal withdrawal) {
		this.withdrawal = withdrawal;
	}

	/**
	 * @return the deposit
	 */
	public BigDecimal getDeposit() {
		return deposit;
	}

	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
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

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
