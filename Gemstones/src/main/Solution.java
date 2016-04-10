package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			String[] rocks = fixedLengthInputLines(keyboard);
			List<Set<Character>> boiledDown = new ArrayList<Set<Character>>();

			for (String rock : rocks)
			{
				Set<Character> characters = new HashSet<Character>();

				for (int i = 0; i < rock.length(); ++i)
				{
					characters.add(rock.charAt(i));
				}

				boiledDown.add(characters);
			}

			Set<Character> gems = boiledDown.get(0);

			for (Set<Character> set : boiledDown)
			{
				gems.retainAll(set);
			}

			System.out.println(gems.size());
		}
	}

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
}