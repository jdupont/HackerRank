package main;

import java.util.Scanner;

public class Solution
{

	public static void main(String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int value = keyboard.nextInt();
			int[] array = readIntArray(keyboard);

			for (int i = 0; i < array.length; ++i)
			{
				if (array[i] == value)
				{
					System.out.println(i);
				}
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