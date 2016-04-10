package main;

import java.util.Arrays;

public class TwoDArrayHelper
{
	public static int[][] getSubArray(int[][] array, int startRow, int startCol, int numRows, int numCols)
	{
		int[][] result = new int[numRows][numCols];

		for (int i = startRow; i < startRow + numRows; ++i)
		{
			for (int j = startCol; j < startCol + numCols; ++j)
			{
				result[i - startRow][j - startCol] = array[i][j];
			}
		}

		return result;
	}

	public static String toStringTwoD(int[][] array)
	{
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < array.length; ++i)
		{
			for (int j = 0; j < array[i].length; ++j)
			{
				builder.append(Integer.toString(array[i][j]) + " ");
			}

			builder.append(System.lineSeparator());
		}

		return builder.toString();
	}

	public static boolean isSquare(int[][] array)
	{
		int numRows = array.length;

		for (int[] row : array)
		{
			if (row.length != numRows)
			{
				return false;
			}
		}

		return true;
	}

	public static boolean isHourglass(int[][] array)
	{
		if (!isSquare(array))
		{
			throw new IllegalArgumentException("Array must be square");
		}

		if (array.length % 2 != 1)
		{
			throw new IllegalArgumentException("Array dims must be odd");
		}

		return array[array.length / 2][0] == 0 && array[array.length / 2][array.length - 1] == 0;
	}

	public static int sum(int[][] array)
	{
		return Arrays.stream(array).flatMapToInt(x -> Arrays.stream(x)).sum();
	}
}
