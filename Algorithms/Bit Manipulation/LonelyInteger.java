import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{
   static int lonelyinteger(int[] a)
   {
      Set<Integer> once = new HashSet<Integer>();
      
      for (int integer : a)
      {
          if (!once.contains(integer))
              {
              once.add(integer);
          }
          else
              {
              once.remove(integer);
          }
      }
       
       if (once.size() != 1)
           {
           throw new IllegalArgumentException("WTF?");
       }
       else
           {
           return once.iterator().next();
       }
   }
   
   public static void main(String[] args)
   {
        try (Scanner in = new Scanner(System.in))
        {
            int res;
        
            int _a_size = Integer.parseInt(in.nextLine());
            int[] _a = new int[_a_size];
            int _a_item;
            String next = in.nextLine();
            String[] next_split = next.split(" ");
        
            for(int _a_i = 0; _a_i < _a_size; _a_i++) {
                _a_item = Integer.parseInt(next_split[_a_i]);
                _a[_a_i] = _a_item;
            }
        
            res = lonelyinteger(_a);
            System.out.println(res);
        }
    }
}
