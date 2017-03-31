#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main()
{
    int numberCases;
    cin >> numberCases;
    
    for (int i = 0; i < numberCases; ++i)
    {
        unsigned int current;
        cin >> current;
        
        current = ~current;
        printf("%u\n", current);
    }
    
    return 0;
}
