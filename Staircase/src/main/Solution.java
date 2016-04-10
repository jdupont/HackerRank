package main;

import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int num = keyboard.nextInt();

			for (int i = 1; i <= num; ++i)
			{
				for (int j = 0; j < num - i; ++j)
				{
					System.out.print(" ");
				}

				for (int j = num - i; j < num; ++j)
				{
					System.out.print("#");
				}

				if (i != num)
				{
					System.out.println();
				}
			}
		}
	}
}