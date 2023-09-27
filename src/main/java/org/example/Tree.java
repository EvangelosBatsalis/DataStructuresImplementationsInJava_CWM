package org.example;

public class Tree {
    private Node root;

    private class Node {
        private int value;
        private Node leftChild;
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
                    if (current.leftChild == null) {
                        current.leftChild = new Node(value);
                        break;
                    }
                    current = current.leftChild;
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
                current = current.leftChild;
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
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    // TODO: 11/7/2023 DFS-InOrder traverse   (visiting sequence: leftChild -> root -> rightChild) using recursion
    public void traverseInOrder() { //Method overloading for outside access
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) { //encapsulation of the root access
        if (root == null) //Base condition of ending the recursion avoiding InfiniteLoop
            return;
        traverseInOrder(root.leftChild);
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
        traversePostOrder(root.leftChild);
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
        if (root.leftChild == null && root.rightChild == null)
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild)); //recurring algo
    }

    // TODO: 11/7/2023 minimum value in a Tree
    //Search Binary tree (O(nlogn) Time complexity)
    private int minAtSearchBinaryTree(Node root) {
        //null pointer exception
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    //Simple Binary Tree (O(n) Time complexity because of traversing all the nodes of tree)
    public int min() {
        return min(root);
    }

    private int min(Node root) {
        //base condition
        if (root.leftChild == null && root.rightChild == null)
            return root.value;

        var leftSub = min(root.leftChild);
        var rightSub = min(root.rightChild);

        return Math.min(Math.min(leftSub, rightSub), root.value);
    }

    // TODO: 11/7/2023 equal method (checking if two trees are equal using recursion)
    public boolean equals(Tree tree) {
        return equals(root, tree.root);
    }

    private Boolean equals(Node firstTree, Node secondTree) {
        //Base conditions 1: If they are both empty or one of the trees
        if (firstTree == null && secondTree == null) return true;
        if (firstTree == null || secondTree == null) return false;

        if (firstTree != null && secondTree != null)
            return firstTree.value == secondTree.value &&
                    equals(firstTree.leftChild, secondTree.rightChild) &&
                    equals(firstTree.rightChild, secondTree.leftChild);
        return false;
    }

    // TODO: 21/9/23 Validating binary search tree (explanation this algorithm checks if the tree is a search tree using recursion)
    public Boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true;

        if (root.value < min || root.value > max) {
            return false;
        }
        return
                isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                        isBinarySearchTree(root.rightChild, root.value + 1, max);
    }


    // TODO: 21/9/23 K Distance from the root (explanation: it prints all the nodes from given k distance from the root)
    private void kDistanceFromRoot(Node root, int kDistance) {
        if (root == null) {
            System.out.println("The Tree is empty");
            return;
        }
        if (kDistance == 0) {
            System.out.println(root.value);
            return;
        }

        kDistanceFromRoot(root.leftChild, kDistance - 1);
        kDistanceFromRoot(root.rightChild, kDistance - 1);
    }

    int kDistance;

    public void kDistanceFromRoot(int kDistance) {
        kDistanceFromRoot(root, kDistance);
    }

    //Exercises
    // TODO: 27/9/23 size of all nodes to a tree
    public void sizeOfAllNodes() {
        sizeOfAllNodes(root);
    }

    private void sizeOfAllNodes(Node root) {
        var current = root;
        int size = 0;

        if(root != null) size++;
        while (current != null) {
            current = current.leftChild;
            size++;
        }
        current = root;
        while (current != null) {
            current = current.rightChild;
            size++;
        }
        System.out.println("The size is: " + size);


    }

    // TODO: 27/9/23 number of all leaves in a tree
    // TODO: 27/9/23 maximum value using recursion


}
