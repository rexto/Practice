/*Input a sequence of characters and if cycles exist, identify all of them. 
 ie. 14321432 contains 1 cycle: {1432} 
 	12121212 contains 2 cycles: {1212, 12}
 	First cyle of the list will always be the biggest
 	If the list is empty, no cycles have been found*/

package projectEuler;

import java.util.LinkedList;
import java.util.List;

public class CycleFinder {

	public static void main(String[] args) {

		System.out.println(BiggestCycle("3333333333"));
	
	}

	public static List<String> BiggestCycle(String content) {
		int LengthCycle = 0;
		List<String> cycles = new LinkedList<String>();

		if (content.length() % 2 == 0) {
			for (int r = 2; r <= content.length(); r = r * 2) {

				int finalPositionOfFirstCycle = (content.length() / r) - 1;
				if(AllCyclesAreEqual(content, finalPositionOfFirstCycle)) {
					cycles.add(content.substring(0,finalPositionOfFirstCycle+1));
				}
			}
		} else {
			if (isPrime(content.length()) && AllCyclesAreEqual(content, 0)) {
				cycles.add(content);
			} else {
				for (int r = 3; r <= content.length() + 1; r = r * 3) {
					int finalPositionOfFirstCycle = (content.length() / r) - 1;
					if(AllCyclesAreEqual(content, finalPositionOfFirstCycle)) {
						cycles.add(content.substring(0,finalPositionOfFirstCycle+1));
					}

				}

			}

		}
		return cycles;

	}

	private static boolean isPrime(int length) {
		for (int divisor = 2; divisor < Math.sqrt(length) + 1; divisor++) {
			// length%2==0 checked above
			if (length % 3 == 0) {
				return false;
			} else {
				if (length % divisor == 0) {
					return false;
				}
			}
		}
		return true;
	}



	private static boolean AllCyclesAreEqual(String content, int finalPositionOfFirstCycle) {
		String possibleCycle = content.substring(0, finalPositionOfFirstCycle + 1);
		for (int i = possibleCycle.length(); i < content.length(); i = i + possibleCycle.length()) {
			if (!possibleCycle.contentEquals(content.substring(i, i + possibleCycle.length()))) {
				return false;
			}
		}
		return true;
	}

}
