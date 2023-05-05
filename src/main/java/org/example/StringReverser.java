package org.example;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if(input == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

    /*
//        traditional for loop
//        for(int i = 0; i < input.length(); i++){
//            stack.push(input.charAt(i));
//        }
    */

//      for each loop to store the array to the stack
        for (char chIteration : input.toCharArray()){
            stack.push(chIteration);
        }
    /*
//        this can work, but we are using many concatenations if, for example, are 1 million records it could take a lot of memory and String class is immutable
        String reverseString = "";
        while(!stack.empty()){
            reverseString += stack.pop();
        }
    */

        //I am using stringBuffer because of the many string manipulations
        StringBuffer reverseString = new StringBuffer();
        while (!stack.empty()){
            reverseString.append(stack.pop());
        }
        return reverseString.toString();

    }


}
