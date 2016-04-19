package main;

import java.util.Scanner;

public class Solution
{
	public static void main(final String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numCases = keyboard.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				String current = keyboard.next();
				int neededChanges = 0;

				for (int j = 0; j < current.length() / 2; ++j)
				{
					char left = current.charAt(j);
					char right = current.charAt(current.length() - j - 1);

					if (left > right)
					{
						neededChanges = neededChanges + left - right;
					}
					else if (left < right)
					{
						neededChanges = neededChanges + right - left;
					}
				}

				System.out.println(neededChanges);
			}
		}
	}
}
