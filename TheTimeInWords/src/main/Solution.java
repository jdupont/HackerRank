package main;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution
{
	public static Map<Integer, String> numberToFriendlyString = new HashMap<Integer, String>();

	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int hours = keyboard.nextInt();
			int minutes = keyboard.nextInt();

			initializeMap();

			if (minutes == 0)
			{
				System.out.println(numberToFriendlyString.get(hours) + " o' clock");
			}
			else if (minutes == 1)
			{
				System.out.println(
						numberToFriendlyString.get(minutes) + " minute past " + numberToFriendlyString.get(hours));
			}
			else if (minutes < 15)
			{
				System.out.println(
						numberToFriendlyString.get(minutes) + " minutes past " + numberToFriendlyString.get(hours));
			}
			else if (minutes == 15)
			{
				System.out.println("quarter past " + numberToFriendlyString.get(hours));
			}
			else if (minutes < 30)
			{
				System.out.println(
						numberToFriendlyString.get(minutes) + " minutes past " + numberToFriendlyString.get(hours));
			}
			else if (minutes == 30)
			{
				System.out.println("half past " + numberToFriendlyString.get(hours));
			}
			else if (minutes < 45)
			{
				System.out.println(numberToFriendlyString.get(60 - minutes) + " minutes to "
						+ numberToFriendlyString.get(hours + 1));
			}
			else if (minutes == 45)
			{
				System.out.println("quarter to " + numberToFriendlyString.get(hours + 1));
			}
			else if (minutes < 59)
			{
				System.out.println(numberToFriendlyString.get(60 - minutes) + " minutes to "
						+ numberToFriendlyString.get(hours + 1));
			}
			else if (minutes == 59)
			{
				System.out.println("one minute to " + numberToFriendlyString.get(hours + 1));
			}
			else
			{
				throw new IllegalArgumentException("WTF?");
			}
		}
	}

	public static void initializeMap()
	{
		numberToFriendlyString.put(1, "one");
		numberToFriendlyString.put(2, "two");
		numberToFriendlyString.put(3, "three");
		numberToFriendlyString.put(4, "four");
		numberToFriendlyString.put(5, "five");
		numberToFriendlyString.put(6, "six");
		numberToFriendlyString.put(7, "seven");
		numberToFriendlyString.put(8, "eight");
		numberToFriendlyString.put(9, "nine");
		numberToFriendlyString.put(10, "ten");
		numberToFriendlyString.put(11, "eleven");
		numberToFriendlyString.put(12, "twelve");
		numberToFriendlyString.put(13, "thirteen");
		numberToFriendlyString.put(14, "fourteen");
		numberToFriendlyString.put(15, "fifteen");
		numberToFriendlyString.put(16, "sixteen");
		numberToFriendlyString.put(17, "seventeen");
		numberToFriendlyString.put(18, "eighteen");
		numberToFriendlyString.put(19, "nineteen");
		numberToFriendlyString.put(20, "twenty");
		numberToFriendlyString.put(21, "twenty one");
		numberToFriendlyString.put(22, "twenty two");
		numberToFriendlyString.put(23, "twenty three");
		numberToFriendlyString.put(24, "twenty four");
		numberToFriendlyString.put(25, "twenty five");
		numberToFriendlyString.put(26, "twenty six");
		numberToFriendlyString.put(27, "twenty seven");
		numberToFriendlyString.put(28, "twenty eight");
		numberToFriendlyString.put(29, "twenty nine");
	}
}