package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numTestCases = keyboard.nextInt();

			for (int i = 0; i < numTestCases; ++i)
			{
				int numRows = keyboard.nextInt();
				int numCols = keyboard.nextInt();

				int[][] grid = readTwoDimensionalSingleDigitArray(keyboard, numRows, numCols);

				int numRowsInSearch = keyboard.nextInt();
				int numColsInSearch = keyboard.nextInt();

				int[][] search = readTwoDimensionalSingleDigitArray(keyboard, numRowsInSearch, numColsInSearch);

				List<Match> firstRowMatches = matchFirstRow(search[0], grid);

				if (firstRowMatches.isEmpty())
				{
					System.out.println("NO");
				}
				else
				{
					boolean found = false;

					for (Match firstRowMatch : firstRowMatches)
					{
						if (matchRemainder(firstRowMatch, grid, search))
						{
							// System.out.println("Row: " + firstRowMatch.row +
							// " col: " + firstRowMatch.col);
							found = true;
							break;
						}
					}

					if (found)
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
	}

	public static boolean matchRemainder(final Match match, final int[][] grid, final int[][] pattern)
	{
		for (int row = match.row; row < pattern.length + match.row; ++row)
		{
			for (int col = match.col; col < pattern[0].length + match.col; ++col)
			{
				// System.out.println("grid " + grid[row][col] + " pattern: " +
				// pattern[row - match.row][col - match.col]);
				if (grid[row][col] != pattern[row - match.row][col - match.col])
				{
					return false;
				}
			}
		}

		return true;
	}

	public static List<Match> matchFirstRow(int[] firstRow, int[][] grid)
	{
		List<Match> matches = new ArrayList<Match>();

		for (int row = 0; row < grid.length; ++row)
		{
			int[] currentRow = grid[row];

			List<Integer> rowMatches = rowContains(currentRow, firstRow);

			if (!rowMatches.isEmpty())
			{
				for (Integer match : rowMatches)
				{
					matches.add(new Match(row, match));
				}
			}
		}

		return matches;
	}

	public static List<Integer> rowContains(int[] row, int[] pattern)
	{
		List<Integer> matches = new ArrayList<Integer>();

		for (int i = 0; i < row.length; ++i)
		{
			int[] sub = Arrays.copyOfRange(row, i, pattern.length + i);
			if (Arrays.equals(sub, pattern))
			{
				matches.add(i);
			}
		}

		return matches;
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

	static class Match
	{
		public final int row;

		public final int col;

		private Match(final int row, final int col)
		{
			this.row = row;
			this.col = col;
		}
	}
}