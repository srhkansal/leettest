package com.leet.dynamicprogramming;

/**
 * Problem statement : find a Fibonacci number
 */
public class Fibonacci {
    public static void main(String []args) {
        int number = 10;
        long memo[] = new long[number+1];
        long fibonacci = Fibonacci.fibo(number, memo);
        System.out.println("fibonacci.. "+fibonacci);
    }

    public static long fibo(int number,long memo[]){
        if(number ==1 || number ==2)
            return 1;
        else {
            long fibo =  fibo(number-1, memo) + fibo(number-2, memo);
            memo[number] =fibo;
            return fibo;
        }
    }
}
//1, 1, 2, 3, 5, 8, 13, 21, 34, 55