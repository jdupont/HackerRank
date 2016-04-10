package main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input
{
	public static String[] fixedLengthInputLines(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the input
		int n = keyboard.nextInt();
		String[] lines = new String[n];
		keyboard.nextLine();
		for (int i = 0; i < n; ++i)
		{
			lines[i] = keyboard.nextLine();
		}

		return lines;
	}

	public static String[] stringArray(final Scanner keyboard, final int length)
	{
		String[] lines = new String[length];
		keyboard.nextLine();
		for (int i = 0; i < length; ++i)
		{
			lines[i] = keyboard.next();
		}

		return lines;
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

	public static int[][] readTwoDimensionalArray(final Scanner keyboard, int numRows, int numCols)
	{
		int[][] twoD = new int[numRows][numCols];

		String[] rawRows = new String[numRows];

		for (int i = 0; i < numRows; ++i)
		{
			rawRows[i] = keyboard.nextLine();
		}

		for (int i = 0; i < numRows; ++i)
		{
			String[] split = rawRows[i].split(" ");

			if (split.length != numCols)
			{
				throw new IllegalArgumentException("Incorrect Dimensions");
			}

			for (int j = 0; j < numCols; ++j)
			{
				twoD[i][j] = Integer.parseInt(split[j]);
			}
		}

		return twoD;
	}

	public static int[] readIntArray(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the input
		int n = keyboard.nextInt();
		int[] lines = new int[n];
		for (int i = 0; i < n; ++i)
		{
			lines[i] = keyboard.nextInt();
		}

		return lines;
	}

	public static List<MutableInteger> readMutableIntList(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the input
		int n = keyboard.nextInt();
		List<MutableInteger> lines = new ArrayList<MutableInteger>();
		for (int i = 0; i < n; ++i)
		{
			lines.add(new MutableInteger(keyboard.nextInt()));
		}

		return lines;
	}

	public static Integer[] readIntegerArray(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the input
		int n = keyboard.nextInt();
		Integer[] lines = new Integer[n];
		for (int i = 0; i < n; ++i)
		{
			lines[i] = keyboard.nextInt();
		}

		return lines;
	}

	public static BigInteger[] readBigIntegerArray(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the input
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

	public static Graph<Integer> readGraph(final Scanner keyboard, final int edgeWeight)
	{
		// Assuming N M on first line, where N is number of nodes and M is number of edges
		int numNodes = keyboard.nextInt();
		int numEdges = keyboard.nextInt();

		Graph<Integer> graph = Graph.integerGraph(numNodes, false);

		for (int i = 0; i < numEdges; ++i)
		{
			int start = keyboard.nextInt();
			int end = keyboard.nextInt();
			graph.addEdge(graph.getByIndex(start - 1), graph.getByIndex(end - 1), edgeWeight);
		}

		return graph;
	}
}
