package main;

import java.util.Scanner;

public class Solution
{

	private static final String CLASS_OPEN = "NO";

	private static final String CLASS_CLOSED = "YES";

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int numCases = in.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				processOneCase(in);
			}
		}
	}

	private static void processOneCase(final Scanner in)
	{
		int numStudents = in.nextInt();
		int minStudents = in.nextInt();

		int numberOnTime = 0;

		for (int i = 0; i < numStudents; ++i)
		{
			int current = in.nextInt();

			if (current <= 0)
			{
				++numberOnTime;
			}
		}

		if (numberOnTime >= minStudents)
		{
			System.out.println(Solution.CLASS_OPEN);
		}
		else
		{
			System.out.println(Solution.CLASS_CLOSED);
		}
	}
}