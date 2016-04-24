package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			String raw = keyboard.next();
			String regex = "(\\w)\\1";

			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(raw);
			while (m.find())
			{
				raw = raw.replaceAll(regex, "");
				m = p.matcher(raw);
			}

			if (raw.isEmpty())
			{
				System.out.println("Empty String");
			}
			else
			{
				System.out.println(raw);
			}
		}
	}
}
