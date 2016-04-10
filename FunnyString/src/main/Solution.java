package main;

import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		final String FUNNY = "Funny";
		final String NOT = "Not Funny";

		try (Scanner keyboard = new Scanner(System.in))
		{
			String[] cases = Solution.fixedLengthInputLines(keyboard);

			for (String test : cases)
			{
				String reverse = new StringBuilder(test).reverse().toString();
				boolean funny = true;

				for (int i = 1; i < test.length() && funny; ++i)
				{
					if (!isFunnyAt(test, reverse, i))
					{
						funny = false;
					}
				}

				System.out.println(funny ? FUNNY : NOT);
			}
		}
	}

	public static boolean isFunnyAt(final String test, final String reverse, final int place)
	{
		return Math.abs(test.charAt(place) - test.charAt(place - 1)) == Math
				.abs(reverse.charAt(place) - reverse.charAt(place - 1));
	}

	public static String[] fixedLengthInputLines(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the
		// input
		int n = keyboard.nextInt();
		String[] lines = new String[n];
		keyboard.nextLine();
		for (int i = 0; i < n; ++i)
		{
			lines[i] = keyboard.nextLine();
		}

		return lines;
	}
}