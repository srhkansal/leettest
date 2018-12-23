package com.sorting;

import java.util.Arrays;

public class MinHeap {

    private int size = 0;
    private int capacity = 10;
    private int items[] =new int[capacity]; // {3, 5, 7, 8 , 55, 22, 88, 2 ,1, 100};

    public static void main(String []args){
        MinHeap myheap = new MinHeap();
        myheap.add(3);
        myheap.add(5);
        myheap.add(7);
        myheap.add(8);
        myheap.add(55);
        myheap.add(22);
        myheap.add(88);
        myheap.add(2);
        myheap.add(1);
        myheap.add(100);
        myheap.add(99);
        myheap.add(98);

        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());
        System.out.println(myheap.poll());

    }

    private void heapifyDown(){
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
                smallerIndex = getRightChildIndex(index);
            }

            if(items[index] < items[smallerIndex]){
                break;
            } else {
                swap(index, smallerIndex);
            }
            index = smallerIndex;
        }
    }

    private void heapifyUp(){
        int index = size-1;
        while(hasParent(index) & (getParent(index) > items[index])){
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void add(int element){
        ensureCapacity();
        items[size] = element;
        size++;
        heapifyUp();
    }

    private int poll(){
        if(size ==0)
            throw new IllegalStateException();

        int element = items[0];
        items[0] = items[size-1];
        items[size-1] = 0;
        size--;
        heapifyDown();
        ensureCapacity();
        return element;
    }

    private int peek(){
        if(size ==0)
            throw new IllegalStateException();
        return items[0];
    }

    private void ensureCapacity(){
        if(size == capacity) {
            capacity = capacity*2;
            items = Arrays.copyOf(items, capacity);
        } else if (capacity>10 && (size < capacity/2)){
            capacity = capacity/2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    private void swap(int indexSwapFrom, int indexSwapTo){
        int tempElement = items[indexSwapFrom];
        items[indexSwapFrom] = items[indexSwapTo];
        items[indexSwapTo] = tempElement;
    }

    private int getLeftChildIndex(int index){
        return (2 * index)+1;
    }

    private int getRightChildIndex(int index){
        return (2 * index)+2;
    }

    private int getParentIndex(int index){
        return (index - 1)/2;
    }

    private int getLeftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    private int getRightChild(int index){
        return items[getRightChildIndex(index)];
    }

    private int getParent(int index){
        return items[getParentIndex(index)];
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }
}
