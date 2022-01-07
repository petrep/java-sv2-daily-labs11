package day04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
	LocalDate refDate = LocalDate.of(2021, 12, 31);

	@Test
	void testProduct() {
		Item product = new Product("product", 10000);
		assertEquals("product", product.getName());
		assertEquals(10000, product.getPrice());
		assertNull(product.getExpiryDate());
		product.setExpiryDate(refDate);
		assertEquals(refDate.plusMonths(3), product.getExpiryDate());
		((Product) product).extendExpiryDate();
		assertEquals(refDate.plusYears(3), product.getExpiryDate());
	}

	@Test
	void testService() {
		Item service = new Service("service", 10000);
		assertEquals("service", service.getName());
		assertEquals(10000, service.getPrice());
		assertNull(service.getExpiryDate());
		service.setExpiryDate(refDate);
		assertEquals(refDate.plusYears(1), service.getExpiryDate());
	}
}