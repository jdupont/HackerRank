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
			BigInteger value = keyboard.nextBigInteger();
			System.out.println(factorial(value));
		}
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