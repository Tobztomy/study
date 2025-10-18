
package com.telious.beans;


public class ItemBean {
    /// ITEM ///
	/**
	 *
	 * @author Bini
	 * @Date 02.23.2023
	 * @version 1.0
	 * @purpose Item mgt
	 */
	
  
    private int  itemId;
    private String itemName;
    private float itemPrice;
    
    ///....END.....///

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    
    
    /**
     * @return the item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param item name the item name to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the item price
     */
    public float getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemprice the item price to set
     */
    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

   

    
   
    
}
