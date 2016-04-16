package main;

import java.util.Scanner;

public class Solution
{
	public static void main(final String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numTestCases = keyboard.nextInt();

			for (int i = 0; i < numTestCases; ++i)
			{
				int numElements = keyboard.nextInt();
				int[] elements = new int[numElements];

				for (int j = 0; j < numElements; ++j)
				{
					elements[j] = keyboard.nextInt();
				}

				for (int outer = 0; outer < numElements; ++outer)
				{
					for (int j = 0; j < numElements - 2; ++j)
					{
						rotateSmallestElementToLeft(elements, j);
					}
				}

				if (isSorted(elements))
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}
	}

	public static boolean isSorted(final int[] full)
	{
		for (int i = 0; i < full.length - 1; i++)
		{
			if (full[i] > full[i + 1])
			{
				return false; // It is proven that the array is not sorted.
			}
		}

		return true;
	}

	public static void rotateSmallestElementToLeft(final int[] full, final int start)
	{
		while (full[start] > full[start + 1] || full[start] > full[start + 2])
		{
			rotate(full, start);
		}
	}

	public static void rotate(final int[] full, final int start)
	{
		int temp = full[start];
		full[start] = full[start + 1];
		full[start + 1] = full[start + 2];
		full[start + 2] = temp;
	}
}
