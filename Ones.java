package com.questions;

/**
 * Created by matthewgoo on 2/12/17.
 */
public class Ones {
    public static void main(String[] args) {
        Ones o = new Ones();

        System.out.println(o.countOnes(60));
    }

    public int countOnes(int n) {
        int count = 0;
        for(int i =0; i<32; i++) {
            double num = Math.pow(2, i);
            if(num > n) {
                break;
            }
            if((n & (int) num) >= 1) {
                count++;
            }
        }
        return count;
    }
}
