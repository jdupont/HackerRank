package main;

import java.text.ParseException;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numCases = keyboard.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				int numBlack = keyboard.nextInt();
				int numWhite = keyboard.nextInt();

				long costBlack = keyboard.nextInt();
				long costWhite = keyboard.nextInt();
				long costConvert = keyboard.nextInt();

				if (costBlack > (costWhite + costConvert))
				{
					costBlack = costWhite + costConvert;
				}
				else if (costWhite > (costBlack + costConvert))
				{
					costWhite = costBlack + costConvert;
				}

				long total = numWhite * costWhite + numBlack * costBlack;

				System.out.println(total);
			}
		}
	}
}