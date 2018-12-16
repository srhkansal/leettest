package com.sorting;

public class MergeSort {
    public static void main(String []args){
        int []arr = {3,5,13,22,11,77};
        mergeSort(arr, new int[arr.length], 0, arr.length-1);

        System.out.print("Sorted : ");
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] +" , ");
        }
    }

    private static void mergeSort(int []arr, int []temp, int left, int right){

        if(left >= right)
            return;

        int mid = (left + right)/2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid +1, right );
        mergeHalves(arr, temp, left, right);
    }

    private static void mergeHalves(int []arr, int []temp, int leftStart, int rightEnd){

        int left = leftStart;
        int leftEnd = (leftStart + rightEnd)/2;

        int right = leftEnd +1;
        int index = leftStart;

        while (left<=leftEnd && right <=rightEnd){
            if(arr[left] <= arr[right]) {
                temp[index] =  arr[left];
                left++;
            } else {
                temp[index] =  arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, (leftEnd -left +1));
        System.arraycopy(arr, right, temp, index, (rightEnd - right +1));
        System.arraycopy(temp, leftStart, arr, leftStart, (rightEnd -leftStart+1));
    }
}
