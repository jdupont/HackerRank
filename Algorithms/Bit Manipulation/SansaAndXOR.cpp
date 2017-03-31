#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

int main()
{
    int numTests;
    std::cin >> numTests;
    
    for (int test = 0; test < numTests; ++test)
    {
        int N;
        std::cin >> N;
        
        std::vector<int> input(N);
        
        for (int i = 0; i < input.size(); i++)
        {
            std::cin >> input[i];
        }
        
        if (N % 2 == 0)
        {
            std::cout << 0 << std::endl;
        }
        else
        {
            int start = input[0];
            
            for (int i = 2; i < input.size(); i = i + 2)
            {
                start = start ^ input[i];
            }
            
            std::cout << start << std::endl;
        }
    }
    
    return 0;
}
