package org.example;

import java.util.Arrays;

public class PriorityQueue {
    private int[] arrayPriorityQueue;
    private int size;
    private int index;

    public PriorityQueue(int size) {
        arrayPriorityQueue = new int[size];
        this.size = size;
    }

    public void add(int value) {
        //if(index == arrayPriorityQueue.length) throw new IllegalStateException();
        if (isFull()) {
            var newArray = new int[arrayPriorityQueue.length + 1]; //create array twice the size
            //copy all values to the new array
            for (int i = 0; i < arrayPriorityQueue.length; i++) {
                newArray[i] = arrayPriorityQueue[i];
            }
            arrayPriorityQueue = newArray; //copies the temp array to arrayPriorityQueue
        }
//        shifting items from end to start and comparing the given value to each value iteration
        int i;
        for (i = index - 1; i >= 0; i--) {
            if (value < arrayPriorityQueue[i]) arrayPriorityQueue[i + 1] = arrayPriorityQueue[i];
            else
                break;
        }
        arrayPriorityQueue[i + 1] = value;
        index++;
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException();
        return arrayPriorityQueue[--index];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == arrayPriorityQueue.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayPriorityQueue);
    }

    public void printArray() {
        var itemsArray = Arrays.copyOfRange(arrayPriorityQueue, 0, index);
        System.out.println(Arrays.toString(itemsArray));
    }

}
