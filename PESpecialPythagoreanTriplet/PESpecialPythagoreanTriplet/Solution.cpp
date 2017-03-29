#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <tuple>
#include <fstream>

bool isPythagoreanTriplet(const std::tuple<int, int, int>& possible)
{
	return std::get<0>(possible) < std::get<1>(possible)
		&& std::get<1>(possible) < std::get<2>(possible)
		&& std::get<0>(possible) * std::get<0>(possible) + std::get<1>(possible) * std::get<1>(possible) == std::get<2>(possible) * std::get<2>(possible);
}

int findMaxTriplet(const int N)
{
	std::vector<std::tuple<int, int, int>> possibles;

	// Generate all a,b,c st. a<b<c && a+ b+ c = N
	for (int a = 1; a <= N; ++a)
	{
		for (int b = a + 1; b <= N; ++b)
		{
			for (int c = b + 1; c <= N; ++c)
			{
				if (a + b + c == N)
				{
					possibles.push_back(std::make_tuple(a, b, c));
				}
			}
		}
	}

	long maxTripletProduct = -1;

	// Check each possible to see if it is a pythagorean triplet
	for (auto const& possible : possibles)
	{
		if (isPythagoreanTriplet(possible))
		{
			long product = std::get<0>(possible) * std::get<1>(possible) * std::get<2>(possible);

			if (product > maxTripletProduct)
			{
				maxTripletProduct = product;
			}
		}
	}

	return maxTripletProduct;
}

int main()
{
	/*
	int numCases;
	std::cin >> numCases;

	for (int i = 0; i < numCases; ++i)
	{
		int N;
		std::cin >> N;

		int maxTriplet = findMaxTriplet(N);
		std::cout << maxTriplet << std::endl;
	}
	*/

	std::ofstream myfile(R"(C:\Users\Jules\Desktop\triplets.txt)");

	for (int i = 1; i <= 3000; ++i)
	{
		long maxTriplet = findMaxTriplet(i);
		myfile << maxTriplet << ",";
	}

	myfile.close();

	return 0;
}
