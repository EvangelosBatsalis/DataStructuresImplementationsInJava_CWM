package org.example;

public class TreeOldAndUnused {
    private class TreeNode {
        private int value;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node: " + this.value;
        }
    }

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
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
                    current.rightChild = new TreeNode(value);
                    break;
                }
                current = current.rightChild;
            } else {
                if (value < current.value) {
                    if (current.leftChild == null) {
                        current.leftChild = new TreeNode(value);
                        break;
                    }
                    current = current.leftChild;
                }
            }
        }
    }

    public Boolean find(int value) {
        TreeNode current = root;
        while (true) {
            if (root == null || current == null) return false;
            if (value == current.value) return true;
            if (value > current.value) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
    }

    public void recursionPrint() {
        recursionPrint(root);
    }

    private void recursionPrint(TreeNode root) {
        //Base condition
        if (root == null) return;

        recursionPrint(root.leftChild);
        System.out.print(root.value + " , ");
        recursionPrint(root.rightChild);
    }

    public int recursionDepth() {
        return recursionDepth(root);
    }

    private int recursionDepth(TreeNode root) {
        //Base condition
        if (root == null) return -1;
        if (root.leftChild == null && root.rightChild == null) return 0;

        return 1 + Math.max(recursionDepth(root.leftChild), recursionDepth(root.rightChild));
    }


}
