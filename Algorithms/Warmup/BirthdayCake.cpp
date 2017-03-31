#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

int main()
{
    int n;
    std::cin >> n;
    
    std::vector<int> candles(n);
    for (int i = 0; i < n; ++i)
    {
        std::cin >> candles[i];    
    }
    
    std::sort(candles.rbegin(), candles.rend());
    
    int start = candles[0];
    int count = 1;
    for (int i = 1; i < n && candles[i] == start; ++i)
    {
        ++count;
    }
    
    std::cout << count;
    
    return 0;
}
