package main;

import java.util.Scanner;

public class Solution
{
	public static void main(final String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			String test = "hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh";
			for (int i = 0; i < test.length(); ++i)
			{
				if (i != 44)
				{
					System.out.print(test.charAt(i));
				}
			}

			int numCases = keyboard.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				String current = keyboard.next();

				boolean neededChange = false;

				for (int j = 0; j < current.length() / 2; ++j)
				{
					if (current.charAt(j) != current.charAt(current.length() - j - 1))
					{
						if (current.charAt(j) == current.charAt(current.length() - j - 2))
						{
							System.out.println(current.length() - j - 1);
						}
						else
						{
							System.out.println(j);
						}

						neededChange = true;
						break;
					}
				}

				if (!neededChange)
				{
					System.out.println(-1);
				}
			}
		}
	}
}
