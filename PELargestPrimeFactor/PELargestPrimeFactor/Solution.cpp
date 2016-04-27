#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <exception>
#include <string>
#include <sstream>
#include <iostream>
#include <fstream>
#include <set>

bool isPrime(const long long number)
{
	static std::set<long long> primes;

	if (primes.find(number) != primes.end())
	{
		return true;
	}

	long long squareRoot = (long long) sqrt(number) + 1;
	
	for (long long i = 2; i <= squareRoot; ++i)
	{
		if (number % i == 0)
		{
			return false;
		}
	}

	primes.emplace(number);
	return true;
}

long long getLargestPrimeFactor(const long long number)
{
	if (isPrime(number))
	{
		return number;
	}

	long long current = number;
	long long maximumPrime = -1;
	long long factor = 2;

	while (factor * factor <= current)
	{
		while (current % factor == 0)
		{
			current = current / factor;

			if (factor != maximumPrime && isPrime(factor))
			{
				maximumPrime = factor;
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

	if (current >= maximumPrime)
	{
		maximumPrime = current;
	}

	return maximumPrime;
}

int main()
{
	int numCases;
	std::cin >> numCases;

	for (int i = 0; i < numCases; ++i)
	{
		long long number;
		std::cin >> number;
		std::cout << getLargestPrimeFactor(number) << std::endl;
	}

	return 0;
}
