package main;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution
{

	public static void main(String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			BigInteger first = BigInteger.valueOf(keyboard.nextInt());
			BigInteger second = BigInteger.valueOf(keyboard.nextInt());
			int desired = keyboard.nextInt();

			BigInteger[] fibs = new BigInteger[desired + 1];
			fibs[0] = first;
			fibs[1] = second;

			// System.out.println(fibs[0]);
			// System.out.println(fibs[1]);

			for (int i = 2; i < desired + 1; ++i)
			{
				BigInteger nth = calculateNth(i, fibs);
				fibs[i] = nth;
				// System.out.println(fibs[i]);
			}

			System.out.println(fibs[desired - 1].toString());
		}
	}

	public static BigInteger calculateNth(int n, BigInteger[] fibs)
	{
		return fibs[n - 1].multiply(fibs[n - 1]).add(fibs[n - 2]);
	}
}