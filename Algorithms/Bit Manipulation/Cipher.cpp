#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <bitset>

int main()
{
    int N;
    int K;
    std::cin >> N >> K;
    
    std::string rawS;
    std::cin >> rawS;
    
    std::vector<bool> S(N + K - 1);
    for (int i = 0; i < S.size(); ++i)
    {
        S[i] = rawS[i] == '1';
    }
    
    // --------------------------------------------------
    
    std::vector<bool> B(N);
    B[0] = S[0];
    
    for (int i = 1; i <= K - 1; ++i)
    {
        B[i] = S[i] ^ S[i - 1];
    }
    
    /*for (int i = 0; i < B.size(); ++i)
    {
        std::cout << (B[i] ? '1' : '0');
    }
    std::cout << std::endl;*/
    
    for (int i = K; i <= N; ++i)
    {
        B[i] = S[i] ^ S[i - 1] ^ B[i - K];
        
        // std::cout << std::endl;
    }
    
    // ==================================================
    
    for (int i = 0; i < B.size(); ++i)
    {
        std::cout << (B[i] ? '1' : '0');
    }
    
    std::cout << std::endl;
    
    return 0;
}
