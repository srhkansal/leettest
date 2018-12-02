package com.leet.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement : Given total money (e.g' 79 in this example),
 * We need to find out, in how many ways we can give a change to a given amount
 */
public class CoinChange {
    public static void main(String args[]){
        int []coins = {1, 2, 5, 10, 25, 50}; //{1, 2};
        int money = 79; //4;
        int index = 0;
        long ways = CoinChange.coinChange(coins, money, index, new HashMap<>());
        System.out.println("Ways " +ways);
    }


    public static long coinChange(int []coins, int money, int index, Map<String, Long> memoMap){
        long ways = 0;
        if(money == 0)
            return 1;
        if (money < 0 )
            return 0;
        if(index >= coins.length)
            return 0;

        String key = money + "-" + index;
        if(memoMap.containsKey(key)) {
            return memoMap.get(key);
        }
        int amountWithCoin = 0;
        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            amountWithCoin += coins[index];
            ways += coinChange(coins, remaining, index+1, memoMap);
        }
        memoMap.put(key, ways);
        return ways;
    }
}
