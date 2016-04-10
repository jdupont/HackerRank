package main;

import java.text.ParseException;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			String[] lines = fixedLengthInputLines(keyboard);

			for (String line : lines)
			{
				int numDeletions = 0;

				for (int i = 0; i < line.length(); ++i)
				{
					char current = line.charAt(i);

					while (i + 1 < line.length() && current == line.charAt(i + 1))
					{
						++numDeletions;
						++i;
					}
				}

				System.out.println(numDeletions);
			}
		}
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