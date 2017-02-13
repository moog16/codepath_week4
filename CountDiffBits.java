package com.questions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by matthewgoo on 2/12/17.
 */
public class CountDiffBits {
    public static void main(String[] args) {
        CountDiffBits c = new CountDiffBits();
        ArrayList<Integer> y = new ArrayList<>(Arrays.asList(1, 8, 10, 4));

        System.out.println(c.cntBits(y));
    }

    public int cntBits(ArrayList<Integer> A) {
        int sum = 0;
        for(int a : A) {
            for(int b : A) {
                sum = sum + getDiff(a, b);
            }
        }
        return sum;
    }

    public int getDiff(int a, int b) {
        int bitMask = 1;
        int index = 0;
        int diff = 0;
        if(a == b) {
            return 0;
        }
        while(bitMask <= Math.max(a, b)) {
            if((a & bitMask) != (b & bitMask)) {
                diff++;
            }
            index++;
            bitMask = 1 << index;
        }
        return diff;
    }
}
