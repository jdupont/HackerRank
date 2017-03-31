import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Solution
{
    public static void main(String[] args)
    {
        try (Scanner keyboard = new Scanner(System.in))
        {
            int[] array = Solution.readIntArray(keyboard);
            
            int total = array.length;
            double pos = 0;
            double zero = 0;
            double neg = 0;
            
            for (int number : array)
            {
                if (number > 0)
                {
                    ++pos;    
                }
                else if (number == 0)
                {
                    ++zero;    
                }
                else if (number < 0)
                {
                    ++neg;    
                }
                else
                {
                    throw new IllegalArgumentException("WTF?");    
                }
            }
            
            DecimalFormat df = new DecimalFormat("0.00000");
            
            System.out.println(df.format(pos / total));
            System.out.println(df.format(neg / total));
            System.out.println(df.format(zero / total));
        }
    }
    
    public static int[] readIntArray(final Scanner keyboard)
	{
		// Assuming the input starts with an integer denoting the length of the input
		int n = keyboard.nextInt();
		int[] lines = new int[n];
		for (int i = 0; i < n; ++i)
		{
			lines[i] = keyboard.nextInt();
		}

		return lines;
	}
}