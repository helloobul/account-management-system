/**
 * 
 */
package org.banking.account.entity;

import java.io.Serializable;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
public class Branch implements Serializable {

	private static final long serialVersionUID = 5858097305978262768L;
	
	private String ifscCode;
	
	private String branchName;
	
	private String city;

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

}
