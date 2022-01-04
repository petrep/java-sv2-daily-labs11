package day02;

import java.util.ArrayList;
import java.util.List;

public class Hiking {

	//10, 20, 15, 18
	public int getPlusElevation(List<Integer> elevations) {
		int fullElevation = 0;

		for (int i = 1; i < elevations.size(); i++) {
			int difference = elevations.get(i)-elevations.get(i-1);
			if (difference > 0) {
				fullElevation += difference;
			}
		}

		return fullElevation;
	}
}
