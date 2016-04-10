package main;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			IntegerMatrix matrix = Input.readIntegerMatrixNumRowsSpecified(keyboard);
			int primary = IntStream.of(matrix.PrimaryDiagonal()).sum();
			int secondary = IntStream.of(matrix.SecondaryDiagonal()).sum();

			System.out.println(Math.abs(primary - secondary));
		}
	}
}

class Input
{
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

	public static BigInteger[] readBigIntegerArray(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the
		// input
		int n = keyboard.nextInt();
		BigInteger[] lines = new BigInteger[n];
		for (int i = 0; i < n; ++i)
		{
			lines[i] = new BigInteger(keyboard.next());
		}

		return lines;
	}

	public static IntegerMatrix readIntegerMatrixNumRowsSpecified(final Scanner keyboard)
	{
		String[] rows = Input.fixedLengthInputLines(keyboard);

		return new IntegerMatrix(rows);
	}

	public static String currentInputLine(final Scanner keyboard)
	{
		return keyboard.nextLine();
	}

	public static boolean hasNext(final Scanner keyboard)
	{
		return keyboard.hasNext();
	}
}

class IntegerMatrix
{
	private final int numRows; // number of rows
	private final int numCols; // number of columns
	private final int[][] data; // M-by-N array

	// create M-by-N matrix of 0's
	public IntegerMatrix(int numRows, int numCols)
	{
		this.numRows = numRows;
		this.numCols = numCols;
		this.data = new int[numRows][numCols];

		for (int i = 0; i < this.numRows; i++)
		{
			for (int j = 0; j < this.numCols; j++)
			{
				this.data[i][j] = 0;
			}
		}
	}

	public IntegerMatrix(final String[] rows)
	{
		this.numRows = rows.length;

		String[] splits = rows[0].split(" ");
		this.numCols = splits.length;

		this.data = new int[this.numRows][this.numCols];

		for (int i = 0; i < this.numRows; ++i)
		{
			String[] cols = rows[i].split(" ");

			if (cols.length != this.numCols)
			{
				throw new IllegalArgumentException("Irregular number of columns");
			}

			for (int j = 0; j < this.numCols; ++j)
			{
				this.data[i][j] = Integer.parseInt(cols[j]);
			}
		}
	}

	// create matrix based on 2d array
	public IntegerMatrix(Integer[][] data)
	{
		this.numRows = data.length;
		this.numCols = data[0].length;
		this.data = new int[this.numRows][this.numCols];
		for (int i = 0; i < this.numRows; i++)
		{
			for (int j = 0; j < this.numCols; j++)
			{
				this.data[i][j] = data[i][j];
			}
		}
	}

	// create and return the N-by-N identity matrix
	public static IntegerMatrix identity(int N)
	{
		IntegerMatrix I = new IntegerMatrix(N, N);
		for (int i = 0; i < N; i++)
		{
			I.data[i][i] = 1;
		}
		return I;
	}

	// create and return the transpose of the invoking matrix
	public IntegerMatrix transpose()
	{
		IntegerMatrix A = new IntegerMatrix(this.numCols, this.numRows);
		for (int i = 0; i < this.numRows; i++)
		{
			for (int j = 0; j < this.numCols; j++)
			{
				A.data[j][i] = this.data[i][j];
			}
		}
		return A;
	}

	public boolean CanAdd(final IntegerMatrix other)
	{
		return IntegerMatrix.CanAdd(this, other);
	}

	public static boolean CanAdd(IntegerMatrix A, IntegerMatrix B)
	{
		return (B.numRows == A.numRows && B.numCols == A.numCols);
	}

	public IntegerMatrix plus(IntegerMatrix B)
	{
		if (!this.CanAdd(B))
		{
			throw new RuntimeException("Illegal matrix dimensions for addition.");
		}

		IntegerMatrix C = new IntegerMatrix(this.numRows, this.numCols);
		for (int i = 0; i < this.numRows; i++)
		{
			for (int j = 0; j < numCols; j++)
			{
				C.data[i][j] = this.data[i][j] + B.data[i][j];
			}
		}

		return C;
	}

	// return C = A - B
	public IntegerMatrix minus(IntegerMatrix B)
	{
		if (!this.CanAdd(B))
		{
			throw new RuntimeException("Illegal matrix dimensions for addition.");
		}

		IntegerMatrix C = new IntegerMatrix(this.numRows, this.numCols);
		for (int i = 0; i < this.numRows; i++)
		{
			for (int j = 0; j < this.numCols; j++)
			{
				C.data[i][j] = this.data[i][j] - B.data[i][j];
			}
		}
		return C;
	}

	public boolean IsSquare()
	{
		return this.numRows == this.numCols;
	}

	public int[] PrimaryDiagonal()
	{
		if (!this.IsSquare())
		{
			throw new IllegalArgumentException("Not a square matrix.");
		}

		int[] diagonal = new int[this.numRows];

		for (int i = 0; i < this.numRows; ++i)
		{
			diagonal[i] = this.data[i][i];
		}

		return diagonal;
	}

	public int[] SecondaryDiagonal()
	{
		if (!this.IsSquare())
		{
			throw new IllegalArgumentException("Not a square matrix.");
		}

		int[] diagonal = new int[this.numRows];

		for (int i = 0; i < this.numRows; ++i)
		{
			diagonal[i] = this.data[i][this.numRows - i - 1];
		}

		return diagonal;
	}

	// does A = B exactly?
	public boolean eq(IntegerMatrix B)
	{
		if (B.numRows != this.numRows || B.numCols != this.numCols)
		{
			return false;
		}

		for (int i = 0; i < this.numRows; i++)
		{
			for (int j = 0; j < this.numCols; j++)
			{
				if (this.data[i][j] != B.data[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}

	public boolean CanMultiply(final IntegerMatrix other)
	{
		return IntegerMatrix.CanMultiply(this, other);
	}

	public static boolean CanMultiply(IntegerMatrix A, IntegerMatrix B)
	{
		return (A.numCols == B.numRows);
	}

	// return C = A * B
	public IntegerMatrix multiply(IntegerMatrix B)
	{
		if (this.CanMultiply(B))
		{
			throw new RuntimeException("Illegal matrix dimensions.");
		}

		IntegerMatrix C = new IntegerMatrix(this.numRows, B.numCols);
		for (int i = 0; i < C.numRows; i++)
		{
			for (int j = 0; j < C.numCols; j++)
			{
				for (int k = 0; k < this.numCols; k++)
				{
					C.data[i][j] += (this.data[i][k] * B.data[k][j]);
				}
			}
		}
		return C;
	}

	// print matrix to standard output
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numCols; j++)
			{
				builder.append(Integer.toString(data[i][j]) + " ");
			}
			builder.append(System.lineSeparator());
		}

		return builder.toString();
	}
}