package com.sorting;

public class QuickSort {
    public static void main(String []args){
        int []arr = {33, 3,555,13,22,11,77};
        quickSort(arr, 0, arr.length-1);

        System.out.print("Sorted : ");
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] +" , ");
        }
    }

    private static void quickSort(int []arr, int left, int right){

        if(left >= right)
            return;

        int pivot = arr[(left + right)/2];
        int partition = partition(arr, left, right, pivot);

        quickSort(arr, left, partition-1);
        quickSort(arr, partition, right);
    }

    private static int partition(int []arr, int left, int right, int pivot){

        while (left <= right){
            while (arr[left] < pivot){
                left++;
            }

            while (arr[right] > pivot){
                right--;
            }

            if(left <= right){
                int temp =  arr[left];
                arr[left] =  arr[right];
                arr[right] =  temp;

                left++;
                right--;
            }
        }

        return left;
    }
}
