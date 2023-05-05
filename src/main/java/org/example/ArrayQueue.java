package org.example;

import java.util.Arrays;

public class ArrayQueue {
    private int[] arrayQueue;
    private int index;
    private int frontPointer;
    private int count; //using this for circular array

    public ArrayQueue(int size) {
        arrayQueue = new int[size];
    }

    //TODO enqueue
    public void enqueue(int value) {
        if (count == arrayQueue.length) throw new IllegalStateException();

        arrayQueue[index++] = value;
        index = (index) % arrayQueue.length;
        count++;
    }

    //TODO dequeue
    //I will implement circular array using leftPointer % Length of the array, the relation is division by the length of the array.
    //e.g. for length 5 and leftPointer 0 = 0 index, for length 5 and leftPointer 1 = 1 index,... until the count == length of the array
    //(leftPointer) % length
    public int deQueue() {
        var item = arrayQueue[frontPointer];
        arrayQueue[frontPointer++] = 0;
        frontPointer = (frontPointer) % arrayQueue.length;
        count--;
        return item;
    }

    //TODO peek
    public int peek() {
        return arrayQueue[frontPointer];
    }

    //TODO isEmpty
    public boolean isEmpty() {
        return count == 0;
    }

    //TODO isFull
    public boolean isFull() {
        return count == arrayQueue.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayQueue);
    }


}
