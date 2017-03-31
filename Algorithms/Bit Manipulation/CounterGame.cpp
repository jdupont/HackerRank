#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>

unsigned long long int hob (unsigned long long int num)
{
    if (!num)
    {
    	return 0;
    }
    
    unsigned long long int ret = 1;

    while (num >>= 1)
    {
    	ret <<= 1;
    }
    
    return ret;
}

int main()
{
    int numTests;
    std::cin >> numTests;
    
    for (int test = 0; test < numTests; ++test)
    {
        unsigned long long int N;
        std::cin >> N;

        if (N == 1)
        {
            std::cout << "Richard" << std::endl;
        }
        else
        {
            bool richardWins = true;
            while (N > 1)
            {
                //std::cout << N << " " << N - 1 << " " << (N & (N - 1)) << " " << ((N & (N - 1) == 0) ? "true" : "false") << std::endl;
                if ((N & (N - 1)) == 0)
                {
                    //std::cout << "PO2: " << N << std::endl;
                    N = N / 2;
                }
                else
                {
                    //std::cout << "NPO2: " << N;
                    unsigned long long int biggestPowerOf2 = hob(N);
                    //std::cout << " largest po2: " << biggestPowerOf2 << std::endl;
                    N = N - biggestPowerOf2;
                }

                richardWins = !richardWins;
                //std::cout << (richardWins ? "Now Richard" : "Now Louise") << std::endl;
            }

            if (richardWins)
            {
                std::cout << "Richard" << std::endl;
            }
            else
            {
                std::cout << "Louise" << std::endl;    
            }
        }
    }
    
    
    return 0;
}
