package net.rnd.talkwalker;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxSubarraySum {

    private static int getSubarraySum(int[] series) {
        AtomicInteger maxValue = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger maxTemp = new AtomicInteger(0);
        Arrays.stream(series).forEach(value -> {
            maxTemp.set(maxTemp.get()+value);
            if (maxValue.get()< maxTemp.get()) {
                maxValue.set(maxTemp.get());
            }
            if(maxTemp.get()<0) {
                maxTemp.set(0);
            }
        });
        return maxValue.get();
    }

    private static int getSubarraySum1(int[] series) {
        int[] arrayOfMaxTemp= {Integer.MIN_VALUE,0};
        Arrays.stream(series).forEach(value -> {
            arrayOfMaxTemp[1]+=value;
            if (arrayOfMaxTemp[0]< arrayOfMaxTemp[1]) {
                arrayOfMaxTemp[0]= arrayOfMaxTemp[1];
            }
            if(arrayOfMaxTemp[1]<0) {
                arrayOfMaxTemp[1]=0;
            }
        });
        return arrayOfMaxTemp[0];
    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

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

    public static void main(String[] ar) {
        int[] ints= {-1,2,-3,-6,-5,-7,10};
        long start = System.nanoTime();
        long finish = System.nanoTime();
        System.out.println(getSubarraySum1(ints));
        System.out.println(finish-start);

        start = System.nanoTime();
        finish = System.nanoTime();
        System.out.println(maxSubArraySum(ints));
        System.out.println(finish-start);
    }
}
