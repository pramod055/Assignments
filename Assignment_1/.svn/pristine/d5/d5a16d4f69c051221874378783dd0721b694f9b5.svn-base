package org.Item;
/**
 * calculate tax for raw type of item
 * @author pramodyadav
 *
 */
public class RawItem extends ItemDetails {
	@Override
	/**
	 * calculate tax based on given rule
	 * rule-12.5% of the item cost
	 * @return item details object after setting setTax and setToatalCost 
	 */
	public ItemDetails calculateTax(ItemDetails inputObject) {
		Double taxCost;
		try {
			taxCost =(inputObject.getItemPrice() *12.5 )/100;
			inputObject.setTax(taxCost);
			inputObject.setTotalCost(inputObject.getItemPrice()+inputObject.getTax());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return inputObject;
	}

}
