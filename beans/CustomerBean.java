
package com.telious.beans;

/**
 *
 * @author Bini
 * @Date 02.23.2023
 * @version 1.0
 * 
 */

public class CustomerBean {
    private int custId;    
    private String custName;
    private String custAddress;
    
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
      
}
