import java.io.*;
import java.util.*;

public class Solution
{

    public static void main(String[] args)
    {
        try (Scanner in = new Scanner(System.in))
        {
            int left = in.nextInt();
            int right = in.nextInt();
            
            int currentMax = left ^ right;
            
            for (int i = left; i <= right; ++i)
            {
                for (int j = left; j <= right; ++j)
                {
                    int current = i ^ j;
                    
                    if (current > currentMax)
                    {
                        currentMax = current;
                    }
                }
            }
            
            System.out.println(currentMax);
        }
    }
}