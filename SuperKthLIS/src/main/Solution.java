package main;

import java.util.Scanner;

public class Solution
{
	public static void main(final String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numberOfElements = keyboard.nextInt();
			int k = keyboard.nextInt();

			int[] elements = new int[numberOfElements];

			for (int i = 0; i < numberOfElements; ++i)
			{
				elements[i] = keyboard.nextInt();
			}

		}
	}
}
