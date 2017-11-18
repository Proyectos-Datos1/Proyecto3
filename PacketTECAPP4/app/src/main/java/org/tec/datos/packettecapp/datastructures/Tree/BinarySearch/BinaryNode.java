package org.tec.datos.packettecapp.datastructures.Tree.BinarySearch;

public class BinaryNode<T extends Comparable>
{
    // Local variables
    private T element;			// The data in the node
    private BinaryNode<T> left;	// Pointer to the left child
    private BinaryNode<T> right;	// Pointer to the right child


    public BinaryNode(T elem)
    {
        this.element = elem;
        this.left = null;
        this.right = null;
    }


    public BinaryNode(T elem, BinaryNode lt, BinaryNode rt)
    {
        this.element = elem;
        this.left = lt;
        this.right = rt;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryNode<T> getLeft() {
        return this.left;
    }

    public BinaryNode<T> getRight() {
        return this.right;
    }

    public T getElement() {
        return this.element;
    }
}
