package org.Item;
/**
 * calculate tax for imported type of item
 * @author pramodyadav
 *
 */
public class ImportedItem extends ItemDetails {
	@Override
	/**
	 * calculate tax based on given rule
	 * rule- 10% import duty on item cost + a surcharge (surcharge is: Rs. 5 
	 * if the final cost after applying tax & import duty is up to Rs. 100, Rs. 10 
	 * if the cost exceeds 100 and up to 200 and 5% of the final cost if it exceeds 200
	 * @return item details object after setting setTax and setToatalCost 
	 */
	public ItemDetails calculateTax(ItemDetails inputObject) {

		Double taxCost;
		try {
			taxCost =(inputObject.getItemPrice() *10 )/100; //10% import duty of cost
			Double finalCost= inputObject.getItemPrice() + taxCost;
			if(finalCost<=100)
				taxCost = taxCost +5;
			else if(finalCost <=200)
				taxCost = taxCost +10;
			else
				taxCost = taxCost +((inputObject.getItemPrice() + taxCost) * 5)/100;
			inputObject.setTax(taxCost);
			inputObject.setTotalCost(inputObject.getItemPrice()+inputObject.getTax());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return inputObject;
	}


}
