#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

std::vector<long long>* generateFibonacci(long maximum)
{
	// Instantiate a vector to hold the sequence
	std::vector<long long>* sequence = new std::vector<long long>;

	// Populate the initial values
	sequence->push_back(1);
	sequence->push_back(2);
	int current = 2;

	// Loop until we've populated up to the maximum necessary number
	do
	{
		sequence->push_back(sequence->at(current - 1) + sequence->at(current - 2));
		++current;
	} while (sequence->at(current - 1) <= maximum);

	return sequence;
}

long long sumOfEvenUpTo(std::vector<long long>* sequence, long maximum)
{
	// ?? The competetive programming article you sent me recommended avoiding 
	// hand-built for loops -- so what is an alternative way of doing this?

	long long sum = 0;

	for (long long element : *sequence)
	{
		if (element > maximum)
		{
			break;
		}
		else if (element % 2 == 0)
		{
			sum = sum + element;
		}
	}

	return sum;
}

int main()
{
	// Get the number of test cases
	// Each test case represents a maximum value; the goal is to find the
	// sum of the even fibonacci numbers less than the maximum
	int numCases;
	std::cin >> numCases;

	// Get each of the maximum values
	std::vector<long> cases;
	for (int i = 0; i < numCases; ++i)
	{
		long N;
		std::cin >> N;

		cases.push_back(N);
	}

	// Populate the fibonacci vector up to the maximum test case
	long maximum = *std::max_element(cases.begin(), cases.end());
	std::vector<long long>* sequence = generateFibonacci(maximum);

	// Find the sum for each test case
	for (long testCase : cases)
	{
		std::cout << sumOfEvenUpTo(sequence, testCase) << "\n";
	}

	// Clean up
	delete(sequence);
	return 0;
}
