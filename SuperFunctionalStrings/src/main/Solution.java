package main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution
{
	public static final BigInteger modolu = BigInteger.TEN.pow(9).add(BigInteger.valueOf(7));

	public static void main(final String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numCases = keyboard.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				String current = keyboard.next();
				List<Pair> substrings = allSubstrings(current);

				BigInteger sum = BigInteger.ZERO;

				for (Pair sub : substrings)
				{
					sum = sum.add(f(sub.first, sub.second));
				}

				System.out.println(sum.mod(modolu));
			}
		}

	}

	public static BigInteger f(final int length, final int distinct)
	{
		BigInteger exp = BigInteger.valueOf(length).pow(distinct);
		return exp.mod(modolu);
	}

	public static List<Pair> allSubstrings(final String text)
	{
		List<Character> list = text.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		List<Pair> subs = new ArrayList<Pair>();
		Set<Integer> hashes = new HashSet<Integer>();

		for (int i = 0; i < text.length(); i++)
		{
			Set<Character> previous = new HashSet<Character>();
			previous.add(text.charAt(i));

			for (int j = i + 1; j <= text.length(); j++)
			{
				List<Character> substring = list.subList(i, j);
				previous.add(text.charAt(j - 1));

				if (!hashes.contains(substring.hashCode()))
				{
					hashes.add(substring.hashCode());
					subs.add(new Pair(substring.size(), previous.size()));
				}
			}
		}

		return subs;
	}

	static class Pair
	{
		public final int first;

		public final int second;

		public Pair(int first, int second)
		{
			this.first = first;
			this.second = second;
		}
	}
}
