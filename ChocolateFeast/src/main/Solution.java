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
				int startingDollars = keyboard.nextInt();
				int priceOfChocolates = keyboard.nextInt();
				int M = keyboard.nextInt();

				int total = startingDollars / priceOfChocolates;
				// System.out.println("Starting chocolates: " + total);
				int wrappers = total;

				// System.out.println(subsequent + " " + M);

				while (wrappers / M > 0)
				{
					int chocolatesFromWrapper = wrappers / M;
					// System.out.println(Integer.toString(subsequent) + " more
					// chocolates");
					total = total + chocolatesFromWrapper;
					wrappers = wrappers % M + chocolatesFromWrapper;
				}

				System.out.println(total);
			}
		}
	}
}