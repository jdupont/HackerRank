package main;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		try (Scanner keyboard = new Scanner(System.in))
		{
			BigInteger[] array = Solution.readBigIntegerArray(keyboard);
			BigInteger sum = BigInteger.ZERO;

			for (BigInteger number : array)
			{
				sum = sum.add(number);
			}

			System.out.println(sum.toString());
		}
	}

	public static BigInteger[] readBigIntegerArray(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the
		// input
		int n = keyboard.nextInt();
		BigInteger[] lines = new BigInteger[n];
		for (int i = 0; i < n; ++i)
		{
			lines[i] = new BigInteger(keyboard.next());
		}

		return lines;
	}
}