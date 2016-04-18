package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/******************************************************************************
 * Compilation: javac Matrix.java Execution: java Matrix
 *
 * A bare-bones immutable data type for M-by-N matrices.
 *
 ******************************************************************************/

public class IntegerMatrix
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

	// create matrix based on 2d array
	public IntegerMatrix(int[][] data)
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

	public Loop getLoopContainingRow(int rowNumber)
	{
		int topRow = rowNumber;
		int bottomRow = this.numRows - rowNumber - 1;
		int leftCol = rowNumber;
		int rightCol = this.numCols - rowNumber - 1;

		Loop loop = new Loop(topRow, bottomRow, leftCol, rightCol);

		// System.out.println("Row number: " + rowNumber);

		// Start in the upper left and go down the left column
		for (int row = topRow; row <= bottomRow; ++row)
		{
			loop.add(this.data[row][leftCol]);
		}

		// Then turn right and do the bottom row
		for (int col = leftCol + 1; col <= rightCol; ++col)
		{
			loop.add(this.data[bottomRow][col]);
		}

		// Then turn up and do the right column
		for (int row = bottomRow - 1; row >= topRow; --row)
		{
			loop.add(this.data[row][rightCol]);
		}

		// And finally turn left and finish the top row
		for (int col = rightCol - 1; col > leftCol; --col)
		{
			loop.add(this.data[topRow][col]);
		}

		return loop;
	}

	public IntegerMatrix rotateCounterClockwise(int numRotations)
	{
		IntegerMatrix matrix = new IntegerMatrix(this.numRows, this.numCols);
		int loop = 0;

		while (loop < this.data.length / 2 && loop < this.numCols)
		{
			// Get the loop
			Loop currentLoop = this.getLoopContainingRow(loop);

			if (currentLoop.leftCol <= currentLoop.rightCol)
			{
				// Rotate the loop
				currentLoop.rotate(numRotations);

				// System.out.println("TopRow: " + currentLoop.topRow + " BottomRow: " + currentLoop.bottomRow
				// + " LeftCol: " + currentLoop.leftCol + " RightCol: " + currentLoop.rightCol);

				// System.out.println("==================");
				// System.out.println(currentLoop.toString());
				// System.out.println("==================");

				// Add the loop to our current return matrix
				matrix = matrix.plus(new IntegerMatrix(currentLoop.reconstitute()));
			}
			// Increment the counter
			++loop;
		}

		return matrix;
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

	class Loop
	{
		private final List<Integer> loop;

		private final int topRow;

		private final int bottomRow;

		private final int leftCol;

		private final int rightCol;

		public Loop(final int topRow, final int bottomRow, final int leftCol, final int rightCol)
		{
			this.topRow = topRow;
			this.bottomRow = bottomRow;
			this.leftCol = leftCol;
			this.rightCol = rightCol;
			this.loop = new ArrayList<Integer>();
		}

		public void add(final int value)
		{
			this.loop.add(value);
		}

		public void rotate(final int numRotations)
		{
			// System.out.println("PreRotate: " + Arrays.toString(this.loop.toArray()));

			Collections.rotate(this.loop, numRotations);

			// System.out.println("PostRotate: " + Arrays.toString(this.loop.toArray()));
		}

		public int[][] reconstitute()
		{
			int[][] matrix = new int[IntegerMatrix.this.numRows][IntegerMatrix.this.numCols];

			int counter = 0;

			// Start in the upper left and go down the left column
			for (int row = topRow; row <= bottomRow; ++row)
			{
				matrix[row][leftCol] = loop.get(counter);
				++counter;
			}

			// Then turn right and do the bottom row
			for (int col = leftCol + 1; col <= rightCol; ++col)
			{
				matrix[bottomRow][col] = loop.get(counter);
				++counter;
			}

			// Then turn up and do the right column
			for (int row = bottomRow - 1; row >= topRow; --row)
			{
				matrix[row][rightCol] = loop.get(counter);
				++counter;
			}

			// And finally turn left and finish the top row
			for (int col = rightCol - 1; col > leftCol; --col)
			{
				matrix[topRow][col] = loop.get(counter);
				++counter;
			}

			return matrix;
		}

		@Override
		public String toString()
		{
			int[][] reconst = this.reconstitute();

			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < reconst.length; i++)
			{
				for (int j = 0; j < reconst[i].length; j++)
				{
					builder.append(Integer.toString(reconst[i][j]) + " ");
				}
				builder.append(System.lineSeparator());
			}

			return builder.toString();
		}
	}
}