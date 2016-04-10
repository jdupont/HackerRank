package main;

import java.text.ParseException;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			keyboard.nextInt();

			String plaintext = keyboard.next();
			int k = keyboard.nextInt();

			for (int i = 0; i < plaintext.length(); ++i)
			{
				char current = plaintext.charAt(i);

				if (Character.isAlphabetic(current))
				{
					System.out.print(caeserShift(current, k));
				}
				else
				{
					System.out.print(current);
				}
			}
		}
	}

	public static char caeserShift(char current, final int k)
	{
		if (Character.isUpperCase(current))
		{
			// 26 letters of the alphabet so mod by 26
			current = (char) (current + (k % 26));
			if (current > 'Z')
			{
				current = (char) (current - 26);
			}

			return current;
		}
		else if (Character.isLowerCase(current))
		{

			current = (char) (current + (k % 26));

			if (current > 'z')
			{
				current = (char) (current - 26);
			}

			return current;
		}
		else
		{
			throw new IllegalArgumentException("WTF?");
		}
	}
}