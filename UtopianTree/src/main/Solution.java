package main;

import java.util.Scanner;

public class Solution
{

	private static final int STARTING_HEIGHT = 1;

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int numCases = in.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				int numCycles = in.nextInt();
				int height = Solution.STARTING_HEIGHT;
				boolean firstCycle = true;

				for (int j = 0; j < numCycles; ++j)
				{
					if (firstCycle)
					{
						height = applyFirstCycle(height);
					}
					else
					{
						height = applySecondCycle(height);
					}

					firstCycle = !firstCycle;
				}

				System.out.println(height);
			}
		}
	}

	private static int applyFirstCycle(int currentHeight)
	{
		return 2 * currentHeight;
	}

	private static int applySecondCycle(int currentHeight)
	{
		return currentHeight + 1;
	}
}