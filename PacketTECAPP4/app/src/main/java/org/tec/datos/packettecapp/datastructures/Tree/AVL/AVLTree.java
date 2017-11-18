package org.tec.datos.packettecapp.datastructures.Tree.AVL;

public class AVLTree<T extends Comparable> {

    // Java program for insertion in AVL Tree

    private AVLNode<T> root;

    // A utility function to get height of the tree
    public int height(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return N.getHeight();
    }

    public AVLNode<T> getRoot() {
        return this.root;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();

        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);

        // Update heights
        y.setHeight(max(this.height(y.getLeft()), this.height(y.getRight())) + 1);
        x.setHeight(max(this.height(x.getLeft()), this.height(x.getRight())) + 1);

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        //  Update heights
        x.setHeight(max(this.height(x.getLeft()), this.height(x.getRight())) + 1);
        y.setHeight(max(this.height(y.getLeft()), this.height(y.getRight())) + 1);

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    private int getBalance(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return this.height(N.getLeft()) - this.height(N.getRight());
    }

    public AVLNode insert(AVLNode node, T key){
        return insert_aux(node,key);
    }
    private AVLNode insert_aux(AVLNode node, T key) {

        /* 1.  Perform the normal BST rotation */
        if (node == null) {
            return (new AVLNode(key));
        }

        if (key.compareTo(node.getKey())<0) {
            node.setLeft(insert(node.getLeft(), key));
        } else {
            node.setRight(insert(node.getRight(), key));
        }

        /* 2. Update height of this ancestor node */
        node.setHeight(max(this.height(node.getLeft()), this.height(node.getRight())) + 1);
        /* 3. Get the balance factor of this ancestor node to check whether
         this node became unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && key.compareTo(node.getLeft().getKey())<0) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key.compareTo(node.getRight().getKey())>0) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key.compareTo(node.getLeft().getKey())>0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key.compareTo(node.getRight().getKey())<0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // A utility function to print preorder traversal of the tree.
    // The function also prints height of every node
    public void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }


}