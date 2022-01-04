package day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

	@Test
	void getPlusElevationTest() {
		int result = new Hiking().getPlusElevation(List.of(10,20,25,15,18));

		assertEquals(18, result);
	}

	@Test
	void getPlusElevationIncreasingTest() {
		int result = new Hiking().getPlusElevation(List.of(10,20,25,30,31));

		assertEquals(21, result);
	}

	@Test
	void getPlusElevationDecreasingTest() {
		int result = new Hiking().getPlusElevation(List.of(31,30,25,20,10));

		assertEquals(0, result);
	}

}