package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebSiteTest {
	WebSite webSite = new WebSite();
	User john = new User("John", 55000);
	User jane = new User("Jane", 7500);

	@BeforeEach
	void init() {
		webSite.addItems(
				  new Product("headset", 15000),
				  new Product("keyboard", 3000),
				  new Product("laptop", 150000),
				  new Service("delivery", 1200),
				  new Service("installation", 8000)
		);
		webSite.addUsers(john, jane);
	}

	@Test
	void testCreateWebSite() {
		assertEquals(5, webSite.getItems().size());
		assertEquals(2, webSite.getUsers().size());
	}

	@Test
	void testBuy() {
		webSite.buyItem("John", "keyboard");
		webSite.buyItem("John", "delivery");
		webSite.buyItem("John", "installation");
		webSite.buyItem("John", "headset");
		assertEquals(4, john.getItems().size());
		assertEquals(27500, john.getMoney());

		webSite.buyItem("Jane", "keyboard");
		webSite.buyItem("Jane", "delivery");
		assertEquals(2, jane.getItems().size());
		assertEquals(3300, jane.getMoney());
	}

	@Test
	void testBuyErrors() {
		IllegalArgumentException cost = assertThrows(IllegalArgumentException.class,
				  () -> webSite.buyItem("John", "laptop"));
		assertEquals("Not enough money.", cost.getMessage());

		IllegalArgumentException me = assertThrows(IllegalArgumentException.class,
				  () -> webSite.buyItem("Me", "laptop"));
		assertEquals("User not found!", me.getMessage());

		IllegalArgumentException pc = assertThrows(IllegalArgumentException.class,
				  () -> webSite.buyItem("John", "PC"));
		assertEquals("Item not found!", pc.getMessage());
	}
}