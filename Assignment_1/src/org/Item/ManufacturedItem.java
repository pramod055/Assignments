package org.Item;
/**
 * calculate tax for manufactured type of item
 * @author pramodyadav
 *
 */
public class ManufacturedItem extends ItemDetails {
	@Override
	/**
	 * calculate tax based on given rule
	 * rule- 12.5% of the item cost + 2% of (item cost + 12.5% of item cost
	 * @return item details object after setting setTax and setToatalCost 
	 */
	public ItemDetails calculateTax(ItemDetails inputObject) {
		Double taxCost;
		try {
			taxCost =(inputObject.getItemPrice() *12.5 )/100;
			taxCost = taxCost +((taxCost +inputObject.getItemPrice())* 2)/100;
			inputObject.setTax(taxCost);
			inputObject.setTotalCost(inputObject.getItemPrice()+inputObject.getTax());
		} catch (Exception e) {
			e.printStackTrace();	
		}

		return inputObject;
	}

}
