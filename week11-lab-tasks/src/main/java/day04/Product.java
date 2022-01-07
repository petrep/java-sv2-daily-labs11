package day04;

import java.time.LocalDate;

public class Product extends Item {

	public Product(String name, int price) {
		super(name, price);
	}

	@Override
	public void setExpiryDate(LocalDate sellDate) {
		expiryDate = sellDate.plusMonths(3);
	}

	public void extendExpiryDate() {
		expiryDate = expiryDate.plusMonths(33);
	}
}
