package main;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution
{
	public static void main(final String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numCases = keyboard.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				String current = keyboard.next();

				if (current.length() % 2 != 0)
				{
					System.out.println(-1);
				}
				else
				{
					String s1 = current.substring(0, current.length() / 2);
					String s2 = current.substring(current.length() / 2);

					List<Character> inS1 = s1.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
					List<Character> inS2 = s2.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

					int differences = 0;

					for (int j = 0; j < inS1.size(); ++j)
					{
						Character s1Character = inS1.get(j);

						if (inS2.contains(s1Character))
						{
							inS2.remove(s1Character);
						}
						else
						{
							++differences;
						}
					}

					System.out.println(differences);
				}
			}
		}
	}
}
