package com.leet.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;


/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class StockMaxProfit {
    public static void main(String []args) {
        int []stockPrices = {7,1,5,3,6,4};
        System.out.println("Stock Transaction Details = " +StockMaxProfit.calculateMaxProfit(stockPrices));

    }

    public static Map<String, Integer> calculateMaxProfit(int []stockPrices){

        Map<String, Integer> stockTransactionDetails = new HashMap<>();
        if(stockPrices == null || stockPrices.length==0){
            return stockTransactionDetails;
        } else {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            stockTransactionDetails.put("maxProfit", maxProfit);
            for(int stockPrice : stockPrices) {
                if(stockPrice < minPrice) {
                    minPrice = stockPrice;
                } else if((stockPrice - minPrice) > maxProfit ){
                    maxProfit = stockPrice -minPrice;

                    stockTransactionDetails.put("stockSellPrice", stockPrice);
                    stockTransactionDetails.put("stockPurchasePrice", minPrice);
                    stockTransactionDetails.put("maxProfit", maxProfit);
                }
            }
            return stockTransactionDetails;
        }
    }
}
