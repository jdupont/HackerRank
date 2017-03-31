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

int main()
{
    long n;
    std::cin >> n;
    
    long count = 0;
    
    while (n > 0)
    {
        if (0 == (n & 0x1))
        {
            count++;
        }
        
        n >>= 1;
    }
    
    printf("%ld\n", (1L << count));
    
    //std::cout << pow(2, count);
    
    return 0;
}
