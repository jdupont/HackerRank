#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <numeric>

long largestProduct(const std::vector<int>& digits, int sizeSection)
{
	long max = 0;

	for (int i = 0; i < digits.size() - sizeSection; ++i)
	{
		long current = std::accumulate(digits.begin() + i, digits.begin() + i + sizeSection, 1, std::multiplies<int>());

		if (current > max)
		{
			max = current;
		}
	}

	return max;
}

int main()
{
	int numCases;
	std::cin >> numCases;

	for (int i = 0; i < numCases; ++i)
	{
		int numDigits;
		int sizeSection;

		std::cin >> numDigits;
		std::cin >> sizeSection;
		
		std::vector<int> digits(numDigits);
		char current;

		for (int j = 0; j < numDigits; ++j)
		{
			std::cin >> current;
			digits[j] = current - '0';
		}

		long product = largestProduct(digits, sizeSection);
		std::cout << product << std::endl;
	}

	return 0;
}
