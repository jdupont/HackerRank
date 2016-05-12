package main;

import java.util.Scanner;

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

				boolean neededChange = false;

				for (int j = 0; j < current.length() / 2; ++j)
				{
					if (current.charAt(j) != current.charAt(current.length() - j - 1))
					{
						if (j - 1 >= 0 && j + 1 < current.length() && current.length() - j - 2 >= 0)
						{
							System.out.println("Choice between: " + j + "(" + current.charAt(j) + ") and "
									+ (current.length() - j - 1) + "(" + current.charAt((current.length() - j - 1))
									+ ")");

							if (current.charAt(j - 1) == current.charAt(current.length() - j - 1)
									&& current.charAt(j + 1) == current.charAt(current.length() - j - 2))
							{
								System.out.println(current.length() - j - 1);
							}
							else
							{
								System.out.println(j);
							}
						}
						else
						{
							if (current.charAt(j) == current.charAt(current.length() - j - 2))
							{
								System.out.println(current.length() - j - 1);
							}
							else
							{
								System.out.println(j);
							}
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
