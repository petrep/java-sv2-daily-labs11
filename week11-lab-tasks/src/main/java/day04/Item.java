package day04;

import java.time.LocalDate;

public abstract class Item {

	protected String name;
	protected int price;
	protected LocalDate expiryDate;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public abstract void setExpiryDate(LocalDate sellDate);
}
