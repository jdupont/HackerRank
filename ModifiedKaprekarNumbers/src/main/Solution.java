package main;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int lowerBound = keyboard.nextInt();
			int upperBound = keyboard.nextInt();

			boolean found = false;

			for (int i = lowerBound; i <= upperBound; ++i)
			{
				if (isKaprekar(i))
				{
					found = true;
					System.out.print(i + " ");
				}
			}

			if (!found)
			{
				System.out.println("INVALID RANGE");
			}
		}
	}

	public static boolean isKaprekar(final int number)
	{
		BigInteger notorious = BigInteger.valueOf(number);
		BigInteger squared = notorious.pow(2);

		BigInteger rightDigits = squared;
		BigInteger leftDigits = squared;

		int counter = number;
		int numIterations = 0;
		while (counter > 0)
		{
			leftDigits = leftDigits.divide(BigInteger.TEN);
			counter = counter / 10;
			++numIterations;
		}

		rightDigits = squared.subtract(leftDigits.multiply(BigInteger.TEN.pow(numIterations)));

		// System.out.println("Number: " + number + " squared: " +
		// squared.toString() + " left: " +
		// leftDigits.toString() + " right: " + rightDigits.toString());

		return rightDigits.add(leftDigits).equals(notorious);
	}
}