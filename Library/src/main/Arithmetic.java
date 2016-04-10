package main;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Arithmetic
{
	public static int SumArray(int[] array)
	{
		return IntStream.of(array).sum();
	}

	public static int getNthDigit(int number, int base, int n)
	{
		return (int) ((number / Math.pow(base, n)) % base);
	}

	public final static boolean isPerfectSquare(long n)
	{
		if (n < 0)
			return false;

		long tst = (long) (Math.sqrt(n) + 0.5);
		return tst * tst == n;
	}

	public static BigInteger factorial(BigInteger n)
	{
		BigInteger result = BigInteger.ONE;

		while (!n.equals(BigInteger.ZERO))
		{
			result = result.multiply(n);
			n = n.subtract(BigInteger.ONE);
		}

		return result;
	}
}
