package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numCases = keyboard.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				int numStones = keyboard.nextInt();
				int a = keyboard.nextInt();
				int b = keyboard.nextInt();

				Set<Integer> possibilities = new HashSet<Integer>();

				for (int j = 0; j < numStones; ++j)
				{
					int current = a * j + b * (numStones - 1 - j);
					possibilities.add(current);
				}

				List<Integer> inOrder = new ArrayList<Integer>(possibilities);
				Collections.sort(inOrder);

				for (int possibility : inOrder)
				{
					System.out.print(Integer.toString(possibility) + " ");
				}

				System.out.println();
			}
		}
	}
}