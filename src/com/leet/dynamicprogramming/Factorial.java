package com.leet.dynamicprogramming;

/**
 * Problem statement : calculate the factorial value for a given  umber
 */
public class Factorial {
    public static void main(String []args) {

        int number = 10;
        int memo[] = new int[number+1];
        int factorial = Factorial.fact(number, memo);
        System.out.println("factorial.. "+factorial);
    }

    public static int fact(int n, int []memo){
        if(n<=1 )
            return 1;
        else if(memo[n]!=0)
            return memo[n];
        else {
            int factorial =  n*fact(n-1, memo);
            memo[n] =factorial;
            return factorial;
        }

    }
}
