package main;

import java.text.ParseException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numChapters = keyboard.nextInt();
			int problemsPerPage = keyboard.nextInt();
			int[] problemsInChapter = new int[numChapters];

			for (int i = 0; i < numChapters; ++i)
			{
				problemsInChapter[i] = keyboard.nextInt();
			}

			List<Entry<Integer, Integer>> problemsToPage = new ArrayList<Entry<Integer, Integer>>();

			int pageNumber = 1;

			for (int i = 0; i < numChapters; ++i)
			{
				for (int j = 1; j <= problemsInChapter[i]; ++j)
				{
					problemsToPage.add(new AbstractMap.SimpleEntry<Integer, Integer>(j, pageNumber));

					if (j % problemsPerPage == 0)
					{
						++pageNumber;
					}
				}

				if (problemsInChapter[i] % problemsPerPage != 0)
				{
					++pageNumber;
				}
			}

			int special = 0;

			for (Entry<Integer, Integer> entry : problemsToPage)
			{
				if (entry.getKey() == entry.getValue())
				{
					++special;
				}
			}

			System.out.println(special);
		}
	}
}