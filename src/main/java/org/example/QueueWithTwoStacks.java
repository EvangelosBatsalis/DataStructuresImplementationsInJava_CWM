package org.example;

import java.util.Arrays;
import java.util.Stack;

public class QueueWithTwoStacks {

    private Stack<Integer> enqueueStack = new Stack<>();
    private Stack<Integer> deQueueStack = new Stack<>();

    /*I will Implement Queue with two stacks. one for enqueue and the other for dequeue. When the dequeue is empty then it will be a reverse from enqueue to dequeue to pop out with the correct order */
    public void enqueue(int item){
        enqueueStack.push(item);
    }
    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException();  //checkes if both stacks are empty
        if(deQueueStack.isEmpty()) fronEnqueueTodeQueue();  //checks if its empty and if it is, then it runs the stack reverse method
        return deQueueStack.pop();
    }

    public int peak(){
        if(isEmpty()) throw new IllegalStateException();  //checkes if both stacks are empty
        if(deQueueStack.isEmpty()) fronEnqueueTodeQueue();  //checks if its empty and if it is, then it runs the stack reverse method
        return deQueueStack.peek();
    }

    private void fronEnqueueTodeQueue(){
        while(!enqueueStack.isEmpty()){
            deQueueStack.push(enqueueStack.pop());
        }
    }
     public void printStack(){
         System.out.println(deQueueStack);
     }

     public boolean isEmpty(){
        return enqueueStack.isEmpty() && deQueueStack.isEmpty();
     }






}
