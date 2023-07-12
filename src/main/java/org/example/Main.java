package org.example;

import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        /* **** Array Class ****  */
/*
        Array array = new Array(3);
        array.insertArray(10);
        array.insertArray(20);
        array.insertArray(30);
        array.insertArray(40);
        System.out.println("Before removal: ");
        array.printArray();

        array.removeAtIndex(3);
        System.out.println("\nAfter removal: ");
        array.printArray();

        System.out.println("\nReturning Index: ");
        System.out.println(array.indexOfArray(20));
        System.out.println(array.indexOfArray(30));
        System.out.println(array.indexOfArray(40));

        System.out.println("Largest number is: "+array.max());

        System.out.println("\n Array reverse: ");
        array.reverse();
        array.printArray();

        System.out.println("\n Intersect: ");
        System.out.println(array.intersect(new int[] {10,20,3}));

        System.out.println("\n Array againReverse: ");
        array.reverse();
        array.printArray();


        System.out.println("\n insertAt: ");
        array.insertAt(2, 200);
        array.printArray();

        LinkedList list = new LinkedList();

        list.add("asd");
        list.add(1);

        var arrayList = list.toArray();
        System.out.println(Arrays.toString(arrayList));
        */




        /* **** LinkedList Class ****  */
/*
        var list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.print();
        System.out.println("size: " + list.size());
        System.out.println("\nIndexof value 20: " + list.indexOf(20));

        System.out.println("contains value 20: " + list.contains(20));
        System.out.println("\n");

        System.out.println("\nDeletion of the first one");
        list.removeFirst();
        list.print();
        System.out.println("size: " + list.size());


        System.out.println("\nDeletion of the last one");
        list.removeLast();
        list.print();

        System.out.println("\nDeletion of the last one");
        list.removeLast();
        list.print();
        System.out.println("size: " + list.size());

        System.out.println("\nDeletion of the last one");
        list.removeLast();
        list.print();
        System.out.println("size: " + list.size());

        System.out.println("adding");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        System.out.println("size: " + list.size());

        System.out.println(Arrays.toString(list.toArray())); //this is a list

        var array = list.toArray(); //this converts to array
        System.out.println(Arrays.toString(array));
//      list.toArray();

        System.out.println("\nreverse with internal Array but big O notation will be O(n^2)");
        list.reverseWithInternalArrays();
//      list.reverse();

        System.out.println("\nreverse by changing the links beetween lists: ");
        list.reverse();
        var arrayReverse = list.toArray();
        System.out.println(Arrays.toString(arrayReverse));

        list.getKthFromTheEnd(2);

        list.getKthFromTheEndSecondVariationWithForLoop(2);
*/



        /* **** Stack Class ****  */
/*
        String word = "asdf";

        StringReverser stringReverser = new StringReverser();
        System.out.println(stringReverser.reverse(word));

        Expression expression = new Expression();
        String wordExpression = "<()[]{})>";

        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);
        System.out.println(stack.peak());

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peak());
*/
        /* **** Queue Class ****  */
/*
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        reverseQueue(queue);
        System.out.println(queue);

        ArrayQueue arrayQueue = new ArrayQueue(5);
        System.out.println("isEmpty: "+arrayQueue.isEmpty());
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);

        ArrayQueue arrayQueue1 = new ArrayQueue(5);
        arrayQueue1.enqueue(30);
        arrayQueue1.enqueue(40);
        arrayQueue1.enqueue(50);
        System.out.println("Adding 30,40,50: "+arrayQueue1.toString());
        var deq = arrayQueue1.deQueue();
        System.out.println(deq);
        arrayQueue1.deQueue();
        System.out.println("Removing first element: "+arrayQueue1.toString());
        arrayQueue1.enqueue(60);
        arrayQueue1.enqueue(70);
        arrayQueue1.enqueue(80);
        System.out.println(arrayQueue1.toString());


        System.out.println("isEmpty: "+arrayQueue1.isEmpty());
        System.out.println("Peak: "+arrayQueue1.peek());
        arrayQueue1.enqueue(90);
        System.out.println(arrayQueue1.toString());
        System.out.println("is full: "+arrayQueue1.isFull());
*/
        /* **** Queue Class with two stacks****  */
        /*
        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();

        queueWithTwoStacks.enqueue(10);
        queueWithTwoStacks.enqueue(20);
        queueWithTwoStacks.enqueue(30);

        System.out.println(queueWithTwoStacks.dequeue());
        System.out.println(queueWithTwoStacks.dequeue());
        System.out.println(queueWithTwoStacks.dequeue());
        queueWithTwoStacks.printStack();
*/


        /* **** Priority queue Class ****  */
/*
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.add(10);
        priorityQueue.add(30);
        priorityQueue.add(20);
        priorityQueue.add(5);
        priorityQueue.add(35);
        priorityQueue.add(11);
        priorityQueue.add(11);
        System.out.println(priorityQueue.toString());
*/

        /* **** Hash Table ****  */
//        CharFinder charFinder = new CharFinder();
//        System.out.println(charFinder.findFirstNonRepeatedCharacterWithHashMap("a green apple"));
//        System.out.println(charFinder.findFirstRepeatedCharacterWithHashSet("green apple"));
//
//        //Creation of Hash Table using Linklist and collision detection: chaining
//        HashTable hashTable = new HashTable();
//        hashTable.put(6,"A");
//        hashTable.put(8, "B");
//        hashTable.put(6,"A+");
//        hashTable.put(11,"C11");
//        hashTable.put(21,"C21");
//
//        System.out.println("Run debuger");


        /* **** Binary Tree ****  */
        Tree tree = new Tree();
            tree.insert(7);
            tree.insert(4);
            tree.insert(9);
            tree.insert(1);
            tree.insert(6);
            tree.insert(8);
            tree.insert(10);
        System.out.println("Pre order traverse: ");
        tree.traversePreOrder();
        System.out.println("\nIn order traverse: ");
        tree.traverseInOrder();
        System.out.println("\nPost order traverse: ");
        tree.traversePostOrder();
        System.out.print("\nHeight of the tree: "+tree.height());
        System.out.print("\nMinimum value of the tree: "+tree.min());

        Tree tree2 = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
    }


    //queue reverse queue
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }


    }
}