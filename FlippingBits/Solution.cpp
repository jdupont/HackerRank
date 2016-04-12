#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

int main()
{
    int numberCases;
    std::cin >> numberCases;

    for (int i = 0; i < numberCases; ++i)
    {
        unsigned int current;
        std::cin >> current;

        current = ~current;
        std::printf("%u\n", current);
    }

    return 0;
}
