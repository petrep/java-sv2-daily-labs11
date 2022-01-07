package day05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

	@Test
	void startLotteryTest() {

		Lottery lottery = new Lottery(5,90);
		List<Integer> result = lottery.startLottery();

		assertEquals(5, result.size());

		for (int i = 0; i < result.size(); i++) {
			assertFalse(result.subList(i + 1, result.size()).contains(result.get(i)));

		}
	}

//	@Test
//	void winningNumbersShouldNotRepeat() {
//		Lottery lottery = new Lottery();
//		assertEquals(false, moreThanOnce(lottery.startLottery()));
//	}
//
//	public static boolean moreThanOnce(ArrayList<Integer> list, int searched)
//	{
//		int numCount = 0;
//
//		for (int thisNum : list) {
//			if (thisNum == searched) numCount++;
//		}
//
//		return numCount > 1;
//	}

}