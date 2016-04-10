package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			List<MutableInteger> sticks = readIntArray(keyboard);
			Collections.sort(sticks);

			while (!sticks.isEmpty())
			{
				int cutSize = sticks.get(0).value;
				// System.out.println("Cut size: " + cutSize);
				// System.out.println("Starting size: " + sticks.size());
				int numCuts = 0;

				for (int i = 0; i < sticks.size(); ++i)
				{
					MutableInteger stick = sticks.get(i);
					// System.out.print("Before: " + stick.value);
					stick.value = stick.value - cutSize;
					// System.out.println(" After: " + sticks.get(i).value);
					++numCuts;
				}

				System.out.println(numCuts);
				// System.out.println("Ending size: " + sticks.size());
				// System.out.println();

				sticks.removeAll(Collections.singleton(new MutableInteger(0)));
			}

		}
	}

	public static List<MutableInteger> readIntArray(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the
		// input
		int n = keyboard.nextInt();
		List<MutableInteger> lines = new ArrayList<MutableInteger>();
		for (int i = 0; i < n; ++i)
		{
			lines.add(new MutableInteger(keyboard.nextInt()));
		}

		return lines;
	}

	static class MutableInteger implements Comparable<MutableInteger>
	{
		public int value;

		public MutableInteger(int value)
		{
			this.value = value;
		}

		@Override
		public int compareTo(final MutableInteger arg0)
		{
			if (this.value > arg0.value)
			{
				return 1;
			}
			else if (this.value < arg0.value)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}

		@Override
		public boolean equals(final Object o)
		{
			if (!(o instanceof MutableInteger))
			{
				throw new IllegalArgumentException("Cannot compare mutable int to some other object");
			}
			else
			{
				return this.value == ((MutableInteger) o).value;
			}
		}

		@Override
		public int hashCode()
		{
			return this.value;
		}
	}

}