package org.tec.datos.datastructures.Tree.AVL;


public class AVLNode<T extends Comparable> {
    private T key;
    private int height;
    private AVLNode left;
    private AVLNode right;

    public AVLNode(T key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
    public AVLNode() {
        this.key = null;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public void setKey(T key) {

        this.key = key;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setLeft(AVLNode left) {

        this.left = left;
    }

    public void setRight(AVLNode right) {

        this.right = right;
    }

    public AVLNode getLeft() {

        return this.left;
    }

    public AVLNode getRight() {

        return this.right;
    }

    public T getKey() {

        return this.key;
    }

    public int getHeight() {

        return this.height;
    }
}