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
public class AccountCreateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6348810711973767087L;

	 
	
	@NotNull
	private String accountType;
	
	@NotNull	
	private BigDecimal initialDepositAmount;
	

	@JsonIgnore
	private LocalDateTime date = LocalDateTime.now();
	
	@NotNull
	private Long customerId;
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
	 * @return the initialDepositAmount
	 */
	public BigDecimal getInitialDepositAmount() {
		return initialDepositAmount;
	}

	/**
	 * @param initialDepositAmount the initialDepositAmount to set
	 */
	public void setInitialDepositAmount(BigDecimal initialDepositAmount) {
		this.initialDepositAmount = initialDepositAmount;
	}
	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
