package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(','[','<','{');
    private final List<Character> rightBrackets = Arrays.asList(')',']','>','}');


    //my solution without factoring
    public Boolean isBalancedMySolution(String expression) {
        Stack<Character> stack = new Stack<>();

        //storing left brackets
        for (char iteration : expression.toCharArray()) {
            if (iteration == '(' || iteration == '[' || iteration == '<' || iteration == '{') {
                stack.push(iteration);
            }

            //peeks when a right bracket appears if it does, then it pops from the list if it doesn't then returns false because there is no left bracket with its opposite
            //also checks when a right bracket appears if the list is empty because if it tries to pop then, it will be a runtime exception.
            if (iteration == ')') {
                if (stack.empty()) return false;
                if (stack.peek() == '(') stack.pop();
                else return false;
            }
            if (iteration == ']') {
                if (stack.empty()) return false;
                if (stack.peek() == '[') stack.pop();
                else return false;
            }
            if (iteration == '<') {
                if (stack.empty()) return false;
                if (stack.peek() == '<') stack.pop();
                else return false;
            }
            if (iteration == '{') {
                if (stack.empty()) return false;
                if (stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        return stack.empty();  //Returns if the list is empty. If it does, then all lefts have a right bracket otherwise it should return false.
    }

    //refactoring for cleaner and readable code
    public boolean isBalancedRefactoring(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char charachterIteration : expression.toCharArray()) {
            if (isLeftBracket(charachterIteration)) {
                stack.push(charachterIteration);
            }

            if (isRightBracket(charachterIteration)) {
                if (stack.isEmpty()) return false;

                var top = stack.pop();
                if (isBracketMatch(top, charachterIteration)) return false;
            }
        }
        return stack.empty();
    }

    private boolean isLeftBracket(char charachter) {
//        return charachter == '(' || charachter == '[' || charachter == '<' || charachter == '{'; //remove long expression by using arrayList
//        var leftBrackets = Arrays.asList('(','[','<','{');  //I should move the var as private to create the list only once because each time this method runs its allocate a new list to our memory so refactor -> extract -> variable -> field declaration
        return leftBrackets.contains(charachter);

    }

    private boolean isRightBracket(char charachter) {
//        return charachter == ')' || charachter == ']' || charachter == '>' || charachter == '}';//remove long expression by using arrayList
//        var rightsBrackets = Arrays.asList(')',']','>','}');
        return rightBrackets.contains(charachter);
    }

    private boolean isBracketMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);

        //        return (right == ')' && left != '(') ||
//                (right == '>' && left != '<') ||
//                (right == ']' && left != '[') ||
//                (right == '}' && left != '{');
//    }
    }
}
