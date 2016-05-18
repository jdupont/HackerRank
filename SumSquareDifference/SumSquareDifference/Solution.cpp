#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <numeric>

long long findSquareOfSums(const int max)
{
	long long arithmeticSum = (1 + max) * (max) / 2;
	return arithmeticSum * arithmeticSum;
}

std::vector<long long> populateSquares(const int max)
{
	std::vector<long long> squares(max);

	for (unsigned int i = 0; i < max; ++i)
	{
		squares[i] = pow(i + 1, 2);
	}

	return std::move(squares);
}

int main()
{
	int numCases;
	std::cin >> numCases;

	std::vector<int> cases(numCases);
	int max = 0;

	for (int i = 0; i < numCases; ++i)
	{
		int current;
		std::cin >> current;

		cases[i] = current;

		if (current > max)
		{
			max = current;
		}
	}

	std::vector<long long> squares = populateSquares(max);

	for (auto const& item : cases)
	{
		// Calculate sum of squares from squares vector
		long long sumOfSquares = std::accumulate(squares.begin(), squares.begin() + item, (long long) 0);
		long long squareOfSums = findSquareOfSums(item);

		std::cout << squareOfSums - sumOfSquares << std::endl;
	}
	
	return 0;
}
