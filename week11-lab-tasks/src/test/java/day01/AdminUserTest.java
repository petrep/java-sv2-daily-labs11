package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminUserTest {

	@Test
	void getPasswordTest() {
		User user = new AdminUser("a@b.hu", "1234");

		assertEquals("****", user.getPassword());
	}
}