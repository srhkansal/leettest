package com.Searching;

public class BinarySearch {
    public static void main(String []args){
        int []array = {3, 5, 8, 99, 333, 444, 566};
        int elementToSearch = 8;
        //recursive
        System.out.println("Binary search recursive : " + binarySearchRecursive(array,elementToSearch, 0, array.length-1));
        //iterative
        System.out.println("Binary search iterative : " + binarySearch(array,elementToSearch));
    }

    private static boolean binarySearchRecursive(int []input, int x, int left, int right){
        if(left > right)
            return false;

        int mid = left + (right - left)/2;
        if(x == input[mid])
            return true;
        else if(x < input[mid])
            return binarySearchRecursive(input, x, left, (mid -1));
        else if(x > input[mid])
            return binarySearchRecursive(input, x, (mid + 1), right);
        return false;
    }


    private static boolean binarySearch(int []input, int x){
        int left = 0;
        int right = input.length -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if(x == input[mid])
                return true;
            else if(x < input[mid])
                right = mid - 1;
            else if(x > input[mid])
                left = mid + 1;
        }
        return false;
    }
}
