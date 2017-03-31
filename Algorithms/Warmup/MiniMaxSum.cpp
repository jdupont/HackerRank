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
    std::vector<long> values(5);
    
    for (int i = 0; i < 5; ++i)
    {
        std::cin >> values[i];
    }
    
    long total = std::accumulate(values.begin(), values.end(), 0L);
    
    std::vector<long> sums(5);
    
    for (int i = 0; i < 5; ++i)
    {
        sums[i] = total - values[i];
    }
    
    std::cout << *std::min_element(sums.begin(), sums.end()) << " " << *std::max_element(sums.begin(), sums.end());
    
    return 0;
}
