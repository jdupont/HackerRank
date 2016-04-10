package main;

import java.text.ParseException;
import java.util.HashSet;
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
				String first = keyboard.next();
				String second = keyboard.next();

				Set<Character> letters = new HashSet<Character>();
				boolean found = false;

				for (int j = 0; j < first.length(); ++j)
				{
					letters.add(first.charAt(j));
				}

				for (int j = 0; j < second.length(); ++j)
				{
					if (letters.contains(second.charAt(j)))
					{
						found = true;
						break;
					}
				}

				System.out.println(found ? "YES" : "NO");

			}
		}
	}
}