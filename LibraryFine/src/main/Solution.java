package main;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int actualDay = keyboard.nextInt();
			int actualMonth = keyboard.nextInt();
			int actualYear = keyboard.nextInt();

			int expectedDay = keyboard.nextInt();
			int expectedMonth = keyboard.nextInt();
			int expectedYear = keyboard.nextInt();

			LocalDate actual = LocalDate.of(actualYear, actualMonth, actualDay);
			LocalDate expected = LocalDate.of(expectedYear, expectedMonth, expectedDay);

			int fine = 0;

			if (actual.isBefore(expected) || actual.equals(expected))
			{
				fine = 0;
			}
			else if (actualMonth == expectedMonth && actualYear == expectedYear)
			{
				fine = 15 * (actualDay - expectedDay);
			}
			else if (actualYear == expectedYear)
			{
				fine = 500 * (actualMonth - expectedMonth);
			}
			else
			{
				fine = 10_000;
			}

			System.out.println(fine);
		}
	}
}