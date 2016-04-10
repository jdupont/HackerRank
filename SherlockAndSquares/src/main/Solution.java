package main;

import java.text.ParseException;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numCases = keyboard.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				int start = keyboard.nextInt();
				int end = keyboard.nextInt();

				int num = 0;

				for (int j = start; j <= end; ++j)
				{
					if (isPerfectSquare(j))
					{
						++num;
						int factor = (int) (Math.sqrt(j) + 0.5);

						j = (factor + 1) * (factor + 1) - 1;
					}
				}

				System.out.println(num);
			}
		}
	}

	public final static boolean isPerfectSquare(long n)
	{
		if (n < 0)
		{
			return false;
		}

		long tst = (long) (Math.sqrt(n) + 0.5);
		return tst * tst == n;
	}
}