package org.example;

import java.util.Arrays;

public class Stack {

    int[] arrayStack = new int[5];
    int index;

//     TODO: 3/5/2023 printStack
    @Override
    public String toString(){
        var contentArray = Arrays.copyOfRange(arrayStack, 0, index);
        return Arrays.toString(contentArray);

    }

//     TODO: 3/5/2023 push
    public void push(int value){
        if(index == arrayStack.length){
            throw new StackOverflowError();
        }
        arrayStack[index++] = value;
    }
//     TODO: 3/5/2023 pop
    public void pop(){
        if(index == 0) throw new IllegalStateException();
        index--;
    }

//     TODO: 3/5/2023 peak
    public int peak(){
        if(index == 0) throw new IllegalStateException();
        return arrayStack[index-1];
    }

//     TODO: 3/5/2023 isEmpty
    public Boolean isEmpty(){
        return index == 0;
    }



}
