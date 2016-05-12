#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <iterator>

std::vector<int> readVectorWithNumElementsGiven()
{
	int numElements;
	std::cin >> numElements;
	std::vector<int> elements(numElements);

	for (int j = 0; j < numElements; ++j)
	{
		std::cin >> elements[j];
	}

	return std::move(elements);
}

int calculateNumberOfBribes(std::vector<int>& elements)
{
	const int MAX_BRIBES_PER_PERSON = 2;
	std::vector<int> bribesPerPerson(elements.size());
	int numBribes = 0;
	bool change = true;

	for (unsigned int i = 0; i < elements.size() && change; ++i)
	{
		change = false;

		for (unsigned int j = 0; j < elements.size() - 1; ++j)
		{
			// Pair from (j, j + 1)
			if (elements[j] > elements[j + 1])
			{
				++numBribes;
				int bribePayer = elements[j] - 1;
				bribesPerPerson[bribePayer] = bribesPerPerson[bribePayer] + 1;
				std::iter_swap(elements.begin() + j, elements.begin() + j + 1);
				change = true;

				if (bribesPerPerson[bribePayer] > MAX_BRIBES_PER_PERSON)
				{
					return -1;
				}
			}
		}
	}

	return numBribes;
}

int main()
{
	int numTestCases;
	std::cin >> numTestCases;

	for (int i = 0; i < numTestCases; ++i)
	{
		std::vector<int> elements = readVectorWithNumElementsGiven();
		
		int numBribes = calculateNumberOfBribes(elements);
		std::cout << ((numBribes == -1) ? "Too chaotic" : std::to_string(numBribes)) << std::endl;
	}

	return 0;
}
