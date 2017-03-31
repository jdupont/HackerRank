#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <bitset>

void hexToBool(std::vector<bool>& result, const std::string& raw)
{
    const int BASE = 'A';
    long lookup[6];
    lookup['A' - BASE] = 10;
    lookup['B' - BASE] = 11;
    lookup['C' - BASE] = 12;
    lookup['D' - BASE] = 13;
    lookup['E' - BASE] = 14;
    lookup['F' - BASE] = 15;
    
    for (int i = 0; i < raw.size(); ++i)
    {
        int value;
        if (raw[i] >= '0' && raw[i] <= '9')
        {
            value = raw[i] - '0';
        }
        else
        {
            value = lookup[raw[i] - BASE];
        }
        
        std::bitset<4> rawBits(value);
        // std::cout << raw[i] << rawBits << std::endl;
        result[4*i] = rawBits[3];
        result[4*i + 1] = rawBits[2];
        result[4*i + 2] = rawBits[1];
        result[4*i + 3] = rawBits[0];
    }
}

void binaryToHex(const std::vector<bool>& bin, std::string& hex)
{
    char lookup[16];
    lookup[0] = '0';
    lookup[1] = '1';
    lookup[2] = '2';
    lookup[3] = '3';
    lookup[4] = '4';
    lookup[5] = '5';
    lookup[6] = '6';
    lookup[7] = '7';
    lookup[8] = '8';
    lookup[9] = '9';
    lookup[10] = 'A';
    lookup[11] = 'B';
    lookup[12] = 'C';
    lookup[13] = 'D';
    lookup[14] = 'E';
    lookup[15] = 'F';
    
    for (int i = 0; i < bin.size(); i = i + 4)
    {
        int result = 8*(bin[i] ? 1 : 0) + 4 * (bin[i + 1] ? 1 : 0) + 2 * (bin[i + 2] ? 1 : 0) + (bin[i + 3] ? 1 : 0);
        hex[i / 4] = lookup[result];
        // std::cout << bin[i] << bin[i + 1] << bin[i + 2] << bin[i + 3] << lookup[result] << std::endl;
    }
}

int main()
{
    int numTests;
    std::cin >> numTests;
    
    for (int test = 0; test < numTests; ++test)
    {;
        long K;
        std::cin >> K;
        
        std::string rawA;
        std::string rawB;
        std::string rawC;
        std::cin >> rawA >> rawB >> rawC;
        
        int size = 4 * rawA.size();
        std::vector<bool> A(size);
        std::vector<bool> B(size);
        std::vector<bool> C(size);
        
        hexToBool(A, rawA);
        hexToBool(B, rawB);
        hexToBool(C, rawC);
        
        long changesMade = 0;
     
        for (int i = 0; i < A.size() && changesMade <= K; ++i)
        {
            if (!C[i])
            {
                if (A[i])
                {
                    A[i] = false;
                    ++changesMade;
                }
                
                if (B[i])
                {
                    B[i] = false;
                    ++changesMade;
                }
            }
            else
            {
                if (!A[i] && !B[i])
                {
                    // Must change one of the two, so let's set B[i] to true
                    B[i] = true;
                    ++changesMade;
                }
            }
        }
     
     
        if (changesMade < K)
        {
            // std::cout << "first:" << changesMade << std::endl;
            
            int aIndex = 0;
            while (changesMade < K && aIndex < A.size())
            {
                if (C[aIndex] && A[aIndex])
                {
                    if (B[aIndex])
                    {
                        A[aIndex] = false;
                        ++changesMade;
                    }
                    else if (changesMade + 2 <= K)
                    {
                        B[aIndex] = true;
                        A[aIndex] = false;
                        changesMade = changesMade + 2;
                    }
                }
                
                ++aIndex;
            }
                        
            // std::cout << changesMade << std::endl;
            
            std::string tempA(rawA);
            binaryToHex(A, tempA);
            tempA.erase(0, tempA.find_first_not_of('0'));
            
            std::cout << (tempA.empty() ? "0" : tempA) << std::endl;
            
            std::string tempB(rawB);
            binaryToHex(B, tempB);
            tempB.erase(0, tempB.find_first_not_of('0'));
            std::cout << tempB << std::endl;
        }    
        else if (changesMade == K)
        {
            //std::cout << changesMade << std::endl;
            
            std::string tempA(rawA);
            binaryToHex(A, tempA);
            tempA.erase(0, tempA.find_first_not_of('0'));
            
            std::cout << (tempA.empty() ? "0" : tempA)  << std::endl;
            
            std::string tempB(rawB);
            binaryToHex(B, tempB);
            tempB.erase(0, tempB.find_first_not_of('0'));
            std::cout << tempB << std::endl;
        }
        else
        {
            std::cout << -1 << std::endl;
        }
        
        if (rawA.size() != rawB.size() || rawB.size() != rawC.size())
        {
            throw std::exception();
        }
        

    }
    
    return 0;
}