package day04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
	User user = new User("John", 120_000);

	@Test
	void testCreateUser() {
		assertEquals("John", user.getUserName());
		assertEquals(120000, user.getMoney());
		assertTrue(user.getItems().isEmpty());
	}

	@Test
	void testAddProductWithExtendedGuarantee() {
		user.addItem(new Product("headset", 15000));
		assertEquals(103500, user.getMoney());
		assertEquals(LocalDate.now().plusYears(3), user.getItems().get(0).getExpiryDate());
		assertEquals("headset", user.getItems().get(0).getName());
	}

	@Test
	void testAddProductWithoutExtendedGuarantee() {
		user.addItem(new Product("furniture", 75000));
		assertEquals(45000, user.getMoney());
		assertEquals(LocalDate.now().plusMonths(3), user.getItems().get(0).getExpiryDate());
		assertEquals("furniture", user.getItems().get(0).getName());
	}

	@Test
	void testAddItemNotEnoughMoney() {
		Product product = new Product("product", 120_001);
		IllegalArgumentException errProduct = assertThrows(IllegalArgumentException.class,
				  () -> user.addItem(product));
		assertEquals("Not enough money.", errProduct.getMessage());
		Service service = new Service("service", 120_001);
		IllegalArgumentException errService = assertThrows(IllegalArgumentException.class,
				  () -> user.addItem(service));
		assertEquals("Not enough money.", errService.getMessage());
		assertTrue(user.getItems().isEmpty());
	}

	@Test
	void testAddService() {
		user.addItem(new Service("car washing", 8400));
		assertEquals(111600, user.getMoney());
		assertEquals(LocalDate.now().plusYears(1), user.getItems().get(0).getExpiryDate());
		assertEquals("car washing", user.getItems().get(0).getName());
	}
}