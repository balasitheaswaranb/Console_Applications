package com.model;

public class Food {
	private int chosenFoodNo;
	private int quantity;
	private float cost;

	public void setChosenFoodNo(int itemNo) {
		this.chosenFoodNo = itemNo;
	}

	public int getChosenFoodNo() {
		return chosenFoodNo;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getCost() {
		return cost;
	}

	public Food(int chosenFoodNo, int quantity) {
		setChosenFoodNo(chosenFoodNo);
		setQuantity(quantity);
		switch (chosenFoodNo) {
		case 1:
			cost = quantity * 10;
			break;
		case 2:
			cost = quantity * 60;
			break;
		case 3:
			cost = quantity * 20;
			break;
		case 4:
			cost = quantity * 20;
			break;
		}
	}
}