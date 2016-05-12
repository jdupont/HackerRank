#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
#include <set>

bool isPrime(const long long number)
{
	if (number == 2)
	{
		return true;
	}
	else if (number % 2 == 0)
	{
		return false;
	}

	long long squareRoot = (long long)sqrt(number) + 1;

	for (long long i = 2; i <= squareRoot; ++i)
	{
		if (number % i == 0)
		{
			return false;
		}
	}

	return true;
}

std::map<int, int> getPrimeFactorsOf(const int number)
{
	std::map<int, int> primes;

	if (isPrime(number))
	{
		primes[number] = 1;
		return std::move(primes);
	}

	int current = number;
	int factor = 2;

	while (factor * factor <= current)
	{
		while (current % factor == 0)
		{
			current = current / factor;

			if (isPrime(factor))
			{
				primes[factor] = primes[factor] + 1;
			}
		}

		if (factor == 2)
		{
			factor = 3;
		}
		else
		{
			factor = factor + 2;
		}
	}

	if (current >= 0 && isPrime(current))
	{
		primes[current] = primes[current] + 1;
	}

	return std::move(primes);
}

int main()
{
	int numTestCases;
	std::cin >> numTestCases;

	for (int i = 0; i < numTestCases; ++i)
	{
		int N;
		std::cin >> N;

		std::map<int, int> overallPrimes;

		for (int j = 2; j <= N; ++j)
		{
			std::map<int, int> primesOFJ = getPrimeFactorsOf(j);

			for (const auto &p : primesOFJ)
			{
				if (overallPrimes[p.first] < p.second)
				{
					overallPrimes[p.first] = p.second;
				}
			}
		}

		long long result = 1;

		for (const auto &p : overallPrimes)
		{
			result = result * (long long ) pow(p.first, p.second);
		}

		std::cout << result << std::endl;
	}

	return 0;
}
