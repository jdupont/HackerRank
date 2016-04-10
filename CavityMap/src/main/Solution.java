package main;

import java.text.ParseException;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int size = keyboard.nextInt();

			int[][] map = readTwoDimensionalSingleDigitArray(keyboard, size, size);

			for (int row = 0; row < size; ++row)
			{
				for (int col = 0; col < size; ++col)
				{
					if (isCavity(row, col, map))
					{
						System.out.print('X');
					}
					else
					{
						System.out.print(map[row][col]);
					}
				}
				System.out.println();
			}
		}
	}

	public static boolean isCavity(final int row, final int col, final int[][] map)
	{
		// Edges can't be cavities
		if (row == 0 || col == 0 || row == map.length - 1 || col == map.length - 1)
		{
			return false;
		}
		else
		{
			int current = map[row][col];

			int above = map[row - 1][col];
			int below = map[row + 1][col];
			int left = map[row][col - 1];
			int right = map[row][col + 1];

			return current > above && current > below && current > left && current > right;
		}
	}

	public static int[][] readTwoDimensionalSingleDigitArray(final Scanner keyboard, int numRows, int numCols)
	{
		int[][] twoD = new int[numRows][numCols];

		for (int row = 0; row < numRows; ++row)
		{
			String rawRow = keyboard.next();
			for (int col = 0; col < numCols; ++col)
			{
				twoD[row][col] = Character.getNumericValue(rawRow.charAt(col));

			}
		}

		return twoD;
	}
}