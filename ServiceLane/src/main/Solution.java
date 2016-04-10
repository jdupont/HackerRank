package main;

import java.util.Scanner;

public class Solution
{

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int length = in.nextInt();
			int numCases = in.nextInt();

			int[] width = new int[length];

			for (int i = 0; i < length; ++i)
			{
				width[i] = in.nextInt();
			}

			for (int i = 0; i < numCases; ++i)
			{
				int entry = in.nextInt();
				int exit = in.nextInt();

				int minWidth = 3;

				for (int j = entry; j <= exit && minWidth > 1; ++j)
				{
					if (width[j] < minWidth)
					{
						minWidth = width[j];
					}
				}

				System.out.println(minWidth);
			}
		}
	}
}