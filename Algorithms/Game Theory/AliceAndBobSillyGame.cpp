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

bool isPrime(const int& number)
{
 if ( ( (!(number & 1)) && number != 2 ) || (number < 2) || (number % 3 == 0 && number != 3) )
  return (false);

 for( int k = 1; 36*k*k-12*k < number;++k)
  if ( (number % (6*k+1) == 0) || (number % (6*k-1) == 0) )
   return (false);
  return true;
 }

int main()
{
    int g;
    std::cin >> g;
    
    std::vector<int> games(g);
        
    for (int i = 0; i < g; ++i)
    {
        std::cin >> games[i];
    }
    
    int max = *std::max_element(games.begin(), games.end());
    
    std::vector<int> primes;
    
    for (int i = 0; i <= max; ++i)
    {
        if (isPrime(i))
        {
            primes.push_back(i);
        }
    }
    
    primes.push_back(INT_MAX);
    
    for (auto const& prime : primes)
    {
        //std::cout << prime << std::endl;
    }
    
    for (int i = 0; i < games.size(); ++i)
    {
        bool aliceWins = false;
        int current = 0;
        
        while (primes[current] <= games[i])
        {
            //std::cout << primes[current] << std::endl;
            aliceWins = !aliceWins;
            ++current;
        }
        
        std::cout << (aliceWins ? "Alice" : "Bob") << std::endl;
    }
       
    return 0;
}
