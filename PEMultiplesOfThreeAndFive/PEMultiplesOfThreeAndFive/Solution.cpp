#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <numeric>

long sumMultiplesOf(long divisor, long cieling)
{
	long n = cieling / divisor;

	return divisor * n * (n + 1) / 2;
}

int main()
{
	int numCases;
	std::cin >> numCases;

	for (int i = 0; i < numCases; ++i)
	{
		int N;
		std::cin >> N;

		// std::cout << SumDivisbleBy(3, N - 1) << " " << SumDivisbleBy(5, N - 1) << " " << SumDivisbleBy(15, N - 1) << "\n";

		long sum = sumMultiplesOf(3, N - 1) + sumMultiplesOf(5, N - 1) - sumMultiplesOf(15, N - 1);

		std::cout << sum << "\n";
	}

	return 0;
}