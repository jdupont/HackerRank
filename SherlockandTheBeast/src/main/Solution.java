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
				Breakdown b = numberOfFives(line);

				if (b.possible)
				{
					for (int i = 0; i < b.numFives; ++i)
					{
						System.out.print(5);
					}

					for (int i = 0; i < b.numThrees; ++i)
					{
						System.out.print(3);
					}

					System.out.println();
				}
				else
				{
					System.out.println(-1);
				}
			}
		}
	}

	public static Breakdown numberOfFives(final int total)
	{
		// 3 *a + 5 * b = total
		// a -- fives, b -- threes

		int numFives = total;
		int numThrees = total - numFives;

		while (numFives >= 0)
		{
			if (numFives % 3 == 0 && numThrees % 5 == 0 && numFives + numThrees == total)
			{
				return new Breakdown(true, numFives, numThrees);
			}
			else
			{
				--numFives;
				numThrees = total - numFives;
			}
		}

		return new Breakdown(false, -1, -1);
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

	static class Breakdown
	{
		public final boolean possible;

		public final int numFives;

		public final int numThrees;

		public Breakdown(final boolean possible, final int numFives, final int numThrees)
		{
			this.possible = possible;
			this.numFives = numFives;
			this.numThrees = numThrees;
		}
	}
}
