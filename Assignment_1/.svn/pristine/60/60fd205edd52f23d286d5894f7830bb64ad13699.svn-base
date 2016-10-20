package org.Item;
/**
 * this class have the variable that are use for item details
 * @author pramodyadav
 *
 */
public abstract class ItemDetails {
	private String itemName;
	private  String itemType;
	private Double itemPrice;
	private int itemQuantity;
	private double totalCost;
	private double tax;
	/**
	 * getter fn is get tax after storing the tax  
	 * @return tax
	 */
	public double getTax() {
		return tax;
	}
	/**
	 * store tax in tax variable
	 * @param tax
	 */
	public void  setTax(double tax) {
		this.tax = tax;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	/**
	 * this abstract method is used to override the calculate fn in all extended class 
	 * method use for calculate tax
	 * @param ob
	 * @return
	 */
	abstract public ItemDetails calculateTax(ItemDetails ob);

}
