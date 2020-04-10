package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.ICategory;
import pl.edu.agh.dronka.shop.model.Item;

public class ItemFilter {

	private Item itemSpec = new Item();
	ICategory categorySpec;

	public void setICategory(ICategory c){
		this.categorySpec = c;
	}
	public ICategory getICategory(){
		return this.categorySpec;
	}

	public Item getItemSpec() {
		return itemSpec;
	}

	public ItemFilter(){
	}

	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}
		if (categorySpec != null
				&& !categorySpec.equals(item.getCategoryFiled())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		return true;
	}

}