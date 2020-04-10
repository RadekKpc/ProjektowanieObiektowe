package pl.edu.agh.dronka.shop.model;

import java.util.Map;

public class Item {

	private String name;

	private Category category;

	private ICategory categoryFiled;

	private int price;

	private int quantity;

	private boolean secondhand;

	private boolean polish;

	public Item(String name, Category category, int price, int quantity,ICategory categoryFiled) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.categoryFiled = categoryFiled;
	}

	public Item() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setSecondhand(boolean secondhand) {
		this.secondhand = secondhand;
	}

	public boolean isSecondhand() {
		return secondhand;
	}

	public void setPolish(boolean polish) {
		this.polish = polish;
	}

	public boolean isPolish() {
		return polish;
	}

	public ICategory getCategoryFiled(){ return  categoryFiled; }

	@Override
	public String toString() {
		return getName();
	}

	public Map<String, Object> getCategoryPropertiesMap(){
		return this.categoryFiled.getPropertiesMap();
	}
}
