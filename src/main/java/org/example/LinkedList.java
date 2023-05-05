package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {

    private Node first;
    private Node last;
    private int size;  //we will add the size increment each time me add value because we dont want to traverse e.g. 1 million items each time we getSize method.


    //TODO addFirst
/*
    1. new node creation
    2. newNode->next = head
    3. head = newNode
*/
    public void addFirst(int value) {
        var node = new Node(value); //1
        if (isEmpty()) {
            first = last = node;
        } else {
            node.setNext(first); //2
            first = node; //3
        }
        size++;
    }

    //TODO addLast
    public void addLast(int item) {
/*
    1. new node creation
    2. tail->next = newNode
    3. tail = newNode
 */
        var node = new Node(item);
        //first checks if its null meaning the list is empty (or a new one) and sets head and tail to this node
        if (isEmpty())
            first = last = node;
        else {
            //add the new node after last node. We are linking the last node to the new node
            last.setNext(node);
            //then we are linking the tail node to point to the new node
            last = node;
        }
        size++;
    }

    //TODO removeFirst
    public void removeFirst() {
        //for empty list NosuchElementException
        if (isEmpty()) throw new NoSuchElementException();

        //if there is a single element in the list
        if (first == last) {
            first = last = null;
            size--;
            return; //I use return because I don't want to execute the next lines of the code below e.g. psounis
        }

        //For at least two item in the list
        //psounis way
        var current = first;
        first = first.getNext();
        current = null;
        size--;

/*      CWM's way
        var current = first.getNext();
        first.setNext(null);
        first = current
*/

    }

    //TODO removeLast
    /*
    1. new node creation for iterating to all nodes and find the previous of the last one
    2. tail->next = newNode
    3. tail = newNode
 */
    public void removeLast() {
        //checks if the list is empty
        if (isEmpty()) throw new NoSuchElementException();

        //checks if the list has single item and if it does then both head and tail will point to null
        if (first == last) {
            first = last = null;
            size--;
            return;  //the return option is for not runs the below code
        }


        //try to find the last node first
        var current = first;
        // traverse through all the nodes to find the pre-last node using current node
        //1.
        while (current != null) {
            if (current.getNext() == last)
                break;  //if first points to the last then break the loop because there is no last one.
            current = current.getNext(); //treverse through the next node until previous node
        }
        //point tail to the pre last node
        last = current;

        //remove the link from the previous pointing the last one for the java's garbage collector
        last.setNext(null);
        size--;
    }

    //TODO contains
    public Boolean contains(int item) {
        var current = first;

        while (current != null) {
            if (current.getValue() == item) return true;
            current = current.getNext();
        }
        return false;
    }

    //TODO printMethod
    public void print() {
        var current = first;
        int indexCount = 0;

        while (current != null) {
            indexCount++;
            System.out.println("NodeIndex: " + indexCount + " , " + "NodeValue: " + current.getValue());
            current = current.getNext();
        }
    }

    //TODO indexOf
    public int indexOf(int item) {
        int index = 0; //allocating counter for index
        var current = first;  //current node for iteration to all nodes

        //while current is not null (end of the list)
        while (current != null) {
            if (current.getValue() == item) return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }

    // TODO: size method
    public int size() {
        return size;
    }


    //TODO isEmpty method checking if its empty or not
    private Boolean isEmpty() {
        return first == null;
    }

    // TODO: toArray()
    public int[] toArray() {
        var array = new int[size];  //creating an array using linkedList size

        //iteratings as i know to all nodes
        var current = first;

        int index = 0; //creating an index for iteration the array
        while (current != null) {
            array[index++] = current.getValue(); //adds all node values to the array and increments the index by 1
            current = current.getNext(); //pointing to the next value
        }

        return array;
    }

    // TODO: 29/4/2023 reverse method
    public void reverseWithInternalArrays() {  //the runtime complexity is O(n) * [O(n)+O(n) = O(n) * O(n) = O(n^2)
        var array = new int[size];
        var reverseArray = new int[size];
        var current = first;

        //O(n)
        int index = 0;
        while (current != null) {
            array[index++] = current.getValue();
            current = current.getNext();
        }
        //O(n)
        index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[index++] = array[i];
        }

        System.out.println(Arrays.toString(reverseArray));
    }

    //reversing the links between nodes
    public void reverse() {
/*
       first            last
        (10  ->  20  ->  30)
             <-       x
          p       c       n
      c.next = p

    p stands for previous, c stands for current, n stands for next

    1. link to a previous node
    2. link to a current node
        before execute the c.next = p you must link the 3rd one because the link to the list will be disappeared
    3. link a next to current node n = c.next
    4. proceed to next three items until current == null

    so:
        1. previous = first;
        2. current = first.getNext();
        3. next = current.getNext();
        4. current.getNext() = previous;  //change the links
*/
        if (isEmpty()) { //checks if the list is empty and informs the user and return nothing because I don't want to run the below code
            System.out.println("The list is empty");
            return;
        }


        var previous = first; //will check the first node
        var current = first.getNext(); //will check the second node, but before we change the link to each other I will need a node with name next
        var next = current.getNext(); //which will hold the 3rd value. Otherwise, garbage allocator will destroy the list

        //looping until current = null
        while (current != null) {
            next = current.getNext(); //after current takes place this will link the next pointer after the current

            current.setNext(previous);  //change the links between precious and current

            //move pointers one step forward
            previous = current;
            current = next;
        }

        //I change the last pointer(tail pointer)
        last = first;
        last.setNext(null); //set the last pointer to null
        //I change the first pointer(head pointer)
        first = previous;
    }

    /*
        the logic is to iterate once with two pointers current and previous with distance k-1 from each other. when the current goes at the end, then I will calculate the
        distance difference and it will bring the Knth from the end.

        Example for k = 3 the difference is 2 so:
         (10  ->  20  ->  30  ->  40  ->  50)
                          3        2       1
                       distance            k
                        previous         current   (distance = k-1)
    */
    public void getKthFromTheEnd(int k) {
//      initialization for both nodes at the head of the linkedList
        var current = first;
        var previous = first;

        int count = 0;       //initialization of node counter to zero
        int distance = k - 1;    //initialization of distance you can remove it and use k instead or increment inside if

//      checks if the list is empty
        if (isEmpty()) {
            System.out.println("\nList is empty");
            return;
        }
//      check's if k is equal or less than zero OR k is greater than list size
        if (k <= 0 || k > size) {
            System.out.println("\ninvalid input");
            return;
        }
        while (current != null) { //while at the end of the list
            if (count >= distance + 1) {  //while distance is correct then move both previous and current nodes until the end of the linkedList
                previous = previous.getNext(); //increment previous by one
            }
            current = current.getNext(); //increment current by one
            count++; //increment counter by one

        }
        System.out.println("The Kth value from the end is: " + previous.getValue());
    }

    public void getKthFromTheEndSecondVariationWithForLoop(int k) {
        if(isEmpty()) throw new IllegalArgumentException();

//      initialization for both nodes at the head of the linkedList
        var current = first;
        var previous = first;

        for (int i = 0; i < k - 1; i++) { //this will increase the node to keep the difference as many times as k-1 is
            current = current.getNext();

            if(current == null) throw new IllegalArgumentException();  //it what it says and its inside for because we dont know the size of the linkedList
        }

        //now we have the different I will move both previous and current nodes until the end of the linkedList until current is not last otherwise if I use != null it will stop one step earlier
        while (current != last) {
            current = current.getNext();
            previous = previous.getNext();
        }
        System.out.println("The Kth value from the end is: " + previous.getValue());
    }

    public void printMiddle(){
            
    }

}
