package net.rnd;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main (String[] args)
    {
        int [] a = {-2, -3, -4, -1, -2, -1, -5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        System.out.println(max_so_far);
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    /*public int solution(int N) {
        // write your code in Java SE 8
        int[] lastTwo={0,1};
        if(N>1){
            IntStream.range(1,N).forEach(index-> {
                int nextElement= nextElement(lastTwo[0],lastTwo[1]);
                lastTwo[0]=lastTwo[1];
                lastTwo[1]= nextElement;
            });
            return lastTwo[1];
        } else {
            return N==0?0:1;
        }
    }

    private int nextElement(int first, int second){
        return sumOfDigits(first)+sumOfDigits(second);
    }

    private int sumOfDigits(int number){
        int sum =0;
        while(number>0){
            sum+= number%10;
            number /= 10;
        }
        return sum;
    }*/
}
