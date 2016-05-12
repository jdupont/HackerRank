#include <vector>
#include <iostream>

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