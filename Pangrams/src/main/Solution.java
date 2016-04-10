package main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution
{

	public static void main(String[] args)
	{
		final String PANGRAM = "pangram";
		final String NOT = "not pangram";

		try (Scanner keyboard = new Scanner(System.in))
		{
			String sentence = keyboard.nextLine();
			sentence = sentence.toLowerCase();
			Set<Character> alphabet = new HashSet<Character>();

			for (int i = 0; i < sentence.length(); ++i)
			{
				char character = sentence.charAt(i);
				if (Character.isLetter(character))
				{
					alphabet.add(character);

					if (alphabet.size() == 26)
					{
						break;
					}
				}
			}

			if (alphabet.size() == 26)
			{
				System.out.println(PANGRAM);
			}
			else
			{
				System.out.println(NOT);
			}
		}
	}
}