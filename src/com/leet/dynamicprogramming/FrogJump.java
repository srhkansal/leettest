package com.leet.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement : a frog can jump either 1 step or 2 steps at a time and needs to cross a pool that is 11 ft long
 * In how many ways, frog can cross the pool
 */
public class FrogJump {
    public static void main(String args[]){
        int []steps_to_jump = {1, 2};
        int money = 11;
        int index = 0;
        long ways = FrogJump.jump(steps_to_jump, money, index, new HashMap<>());
        System.out.println("Ways " +ways);
    }

   // {2,2,2,2,2,1}  {2,2,2,2,1,1,1} {2,2,2,1,1,1,1,1} {2,2,1,1,1,1,1,1,1}
    //{2,1,1,1,1,1,1,1,1,1} {2,1,1,1,1,1,1,1,1,1} {1,1,1,1,1,1,1,1,1,1,1}

    public static long jump(int []steps_to_jump, int totalSteps, int index, Map<String, Long> memoMap){
        long ways = 0;
        if(totalSteps == 0)
            return 1;
        if (totalSteps < 0 )
            return 0;
        if(index >= steps_to_jump.length)
            return 0;

        String key = totalSteps + "-" + index;
        if(memoMap.containsKey(key)) {
            return memoMap.get(key);
        }
        int stepsJumped = 0;
        while (stepsJumped <= totalSteps) {
            int remaining = totalSteps - stepsJumped;
            stepsJumped += steps_to_jump[index];
            ways += jump(steps_to_jump, remaining, index+1, memoMap);
        }
        memoMap.put(key, ways);
        return ways;
    }
}
