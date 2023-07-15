package org.example;

public class Tree {
    private Node root;

    private class Node {
        private int value;
        private Node lefChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node= " + value;
        }
    }

    // TODO: 31/5/2023 insert(value:int)
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        var current = root;

        if (find(value)) {
            System.out.println("Value: " + value + " cannot be inserted. It is already exists..");
            return;
        }

        while (true) {
            if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = new Node(value);
                    break;
                }
                current = current.rightChild;
            } else {
                if (value < current.value) {
                    if (current.lefChild == null) {
                        current.lefChild = new Node(value);
                        break;
                    }
                    current = current.lefChild;
                }
            }
        }
    }

    // TODO: 31/5/2023 find(value): boolean
    public Boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value > current.value)
                current = current.rightChild;
            else if (value < current.value)
                current = current.lefChild;
            else
                return true;
        }
        return false;
    }

    // TODO: 11/7/2023 DFS-preOrder traverse (visiting sequence: root -> leftChild -> rightChild) using recursion
    public void traversePreOrder() { //Method overloading for outside access
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) { //encapsulation of the root access
        if (root == null) //Base condition of ending the recursion avoiding InfiniteLoop
            return;

        System.out.println(root); //printing using toString Overload otherwise you can use root.value
        traversePreOrder(root.lefChild);
        traversePreOrder(root.rightChild);
    }

    // TODO: 11/7/2023 DFS-InOrder traverse   (visiting sequence: leftChild -> root -> rightChild) using recursion
    public void traverseInOrder() { //Method overloading for outside access
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) { //encapsulation of the root access
        if (root == null) //Base condition of ending the recursion avoiding InfiniteLoop
            return;
        traverseInOrder(root.lefChild);
        System.out.println(root); //printing using toString Overload otherwise you can use root.value
        traverseInOrder(root.rightChild);
    }

    // TODO: 11/7/2023 DFS-postOrder traverse (visiting sequence: leftChild -> rightChild -> root) using recursion
    public void traversePostOrder() { //Method overloading for outside access
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) { //encapsulation of the root access
        if (root == null) //Base condition of ending the recursion avoiding InfiniteLoop
            return;
        traversePostOrder(root.lefChild);
        traversePostOrder(root.rightChild);
        System.out.println(root); //printing using toString Overload otherwise you can use root.value
    }

    // TODO: 11/7/2023 recurring algorithm: finding the height of a tree using the height of the longest child (1+max(height(L), max(height(R))
    //  which L is for left child or (subtree) and R is for right child or(subtree)). (Graph Theory)
    public int height() {
        return height(root);
    }

    private int height(Node root) {
        //condition about empty tree
        if (root == null) {
            System.out.println("The tree is empty");
            return -1;
        }

        //base condition stop at the last leafs of the tree
        if (root.lefChild == null && root.rightChild == null)
            return 0;

        return 1 + Math.max(height(root.lefChild), height(root.rightChild)); //recurring algo
    }

    // TODO: 11/7/2023 minimum value in a Tree
    //Search Binary tree (O(logn) Time complexity)
    private int minAtSearchBinaryTree(Node root) {
        //null pointer exception
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.lefChild;
        }
        return last.value;
    }

    //Simple Binary Tree (O(n) Time complexity because of traversing all the nodes of tree)
    public int min(){
        return min(root);
    }
    private int min(Node root) {
        //base condition
        if (root.lefChild == null && root.rightChild == null)
            return root.value;

        var leftSub = min(root.lefChild);
        var rightSub = min(root.rightChild);

        return Math.min(Math.min(leftSub, rightSub), root.value);
    }

    // TODO: 11/7/2023 equal method (checking if two trees are equal using recursion)
    public Boolean equal(Tree tree){

        if((this.root.lefChild == null && this.root.rightChild == null) || (tree.root.lefChild == null && tree.root.rightChild == null)){
            return false;
        }



        return false;
    }
}
