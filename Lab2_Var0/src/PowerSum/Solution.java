package PowerSum;

import java.util.function.Function;
import java.util.stream.IntStream;

public class Solution {
	private static int powerSumHelper(int x, int N, int start)
	{
		if (x == 0) {
			return 1;
		} else {
			final int root = (int) Math.ceil(Math.pow(x, 1.0 / N));
			final Function<Integer, Integer> subtractPowerOf = i -> x - (int) Math.pow(i, N);
			return IntStream.rangeClosed(start, root)
			.filter(i -> subtractPowerOf.apply(i) >= 0)
			.map(i -> powerSumHelper(subtractPowerOf.apply(i), N, i + 1))
			.sum();
		}
	}

	public static int powerSum(int x, int N) throws Exception {
		if (x < 1) {
			throw new Exception("Number must be 1 or greater");
		} else if (N < 2) {
			throw new Exception("Power must be 2 or greater");
		} else {
			return powerSumHelper(x, N, 1);
		}
	}
}
