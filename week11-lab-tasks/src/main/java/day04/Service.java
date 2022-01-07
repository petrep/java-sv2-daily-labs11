package day04;

import java.time.LocalDate;

public class Service extends Item {

	public Service(String name, int price) {
		super(name, price);
	}

	@Override
	public void setExpiryDate(LocalDate sellDate) {
		expiryDate = sellDate.plusYears(1);
	}
}
