package main;

import java.text.ParseException;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int[] tests = readIntArray(keyboard);

			for (int line : tests)
			{
				int copy = line;
				int sum = 0;
				// Map<Integer, Integer> digits = new HashMap<Integer,
				// Integer>();

				while (copy > 0)
				{
					int digit = copy % 10;
					if (digit != 0 && line % (copy % 10) == 0)
					{
						++sum;
					}

					copy = copy / 10;
				}

				System.out.println(sum);
			}
		}
	}

	public static int[] readIntArray(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the
		// input
		int n = keyboard.nextInt();
		int[] lines = new int[n];
		for (int i = 0; i < n; ++i)
		{
			lines[i] = keyboard.nextInt();
		}

		return lines;
	}
}
