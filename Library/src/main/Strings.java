package main;

import java.util.HashSet;
import java.util.Set;

public class Strings
{
	public static Set<String> allSubstrings(final String text)
	{
		Set<String> subs = new HashSet<String>();

		for (int i = 0; i < text.length(); i++)
		{
			for (int j = i + 1; j <= text.length(); j++)
			{
				subs.add(text.substring(i, j));
			}
		}

		return subs;
	}
}
