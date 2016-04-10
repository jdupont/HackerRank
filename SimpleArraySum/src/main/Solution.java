package main;

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
			int[] array = Solution.readIntArray(keyboard);
			int sum = 0;

			for (int number : array)
			{
				sum = sum + number;
			}

			System.out.println(sum);
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