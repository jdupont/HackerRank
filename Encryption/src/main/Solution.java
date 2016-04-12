package main;

import java.util.Scanner;

public class Solution
{
	public static void main(final String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			String plaintext = keyboard.next();
			int rows = (int) Math.floor(Math.sqrt(plaintext.length()));
			int cols = (int) Math.ceil(Math.sqrt(plaintext.length()));

			if (rows * cols < plaintext.length())
			{
				++rows;
			}

			/*
			 * System.out.println("Rows: " + rows + " Cols: " + cols +
			 * " Text length: " + plaintext.length());
			 */
			TextGrid grid = new TextGrid(rows, cols);
			grid.addText(plaintext);

			for (int i = 0; i < cols; ++i)
			{
				System.out.print(grid.getColAsString(i).trim() + " ");
			}
		}
	}

	static class TextGrid
	{
		private final int rows;
		private final int cols;
		private final char[][] grid;

		public TextGrid(final int rows, final int cols)
		{
			this.rows = rows;
			this.cols = cols;
			this.grid = new char[rows][cols];
		}

		public void addText(final String text)
		{
			if (text.length() > this.rows * this.cols)
			{
				throw new IllegalArgumentException("Text is too large to fit in the grid.");
			}

			int place = 0;

			for (int row = 0; row < this.rows; ++row)
			{
				for (int col = 0; col < this.cols; ++col)
				{
					if (place < text.length())
					{
						this.grid[row][col] = text.charAt(place);
					}
					else
					{
						this.grid[row][col] = ' ';
					}
					++place;
				}
			}
		}

		public char[] getCol(final int i)
		{
			if (i >= this.cols)
			{
				throw new IllegalArgumentException("Index out of range for columns.");
			}

			char[] column = new char[this.rows];

			for (int row = 0; row < this.rows; ++row)
			{
				column[row] = this.grid[row][i];
			}

			return column;
		}

		public String getColAsString(final int i)
		{
			return new String(this.getCol(i));
		}

		@Override
		public String toString()
		{
			StringBuilder builder = new StringBuilder();

			for (int row = 0; row < this.rows; ++row)
			{
				for (int col = 0; col < this.cols; ++col)
				{
					builder.append(this.grid[row][col]);
				}
			}

			return builder.toString();
		}
	}
}
