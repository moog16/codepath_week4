package com.questions;

import com.sun.tools.corba.se.idl.InterfaceGen;

/**
 * Created by matthewgoo on 2/12/17.
 */
public class Division {
    public static void main(String[] args) {
        Division d = new Division();
        int x = d.divide(-2147483648, -10000000);
        System.out.println(x);
    }

    public int divide(int dividend, int divisor) {
        boolean isNegative = false;
        if(dividend < 0 && divisor < 0) {
            if(dividend <= (-Integer.MAX_VALUE - 1) && divisor < 0) {
                dividend = Integer.MAX_VALUE;
            } else {
                dividend = Math.abs(dividend);
            }
            divisor = Math.abs(divisor);
        } else if(dividend < 0 || divisor < 0) {
            isNegative = true;
            if(dividend >= 0) {
                divisor = Math.abs(divisor);
            }
        }
        if (divisor == 1 || divisor == 0) {
            return dividend;
        }

        int mask = 0;
        int remain = divisor << mask;
        long quotient = 0;
        while(true) {
            if((remain << 1) > dividend || (remain << 1) <= 0) {
                break;
            }
            mask++;
            remain <<= 1;
        }
        while(dividend >= divisor) {
            while(remain > dividend) {
                mask -= 1;
                remain >>= 1;
            }
            quotient += (1 << mask);
            dividend -= remain;
        }
        int ans = quotient > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) quotient;
        return isNegative ? -ans : ans;
    }
}
