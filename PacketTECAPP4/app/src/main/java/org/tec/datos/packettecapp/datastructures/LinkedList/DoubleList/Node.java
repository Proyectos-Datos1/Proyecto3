package org.tec.datos.packettecapp.datastructures.LinkedList.DoubleList;

/**
 * Clase Node
 * Unidad básica de las listas Doblemente enlazadas
 * @param <T>
 */
public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T item;

    /**
     * Constructor
     * Se inicializa los atributos en null
     */
    public Node(){
        this.previous=null;
        this.next=null;
        this.item=null;
    }

    /**
     * Setter
     * Cambia el valor del item
     * @param item
     */
    public void setItem(T item) {
        this.item = item;
    }

    /**
     * Setter
     * Asigna el valor del la referencia al nodo anterior
     * @param previous
     */
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    /**
     * Setter
     * Asigna el valor del la referencia al siguiente nodo
     * @param next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Getter
     * Devuelve el valor del item
     * @return item
     */
    public T getItem() {
        return this.item;
    }

    /**
     * Getter
     * Devuelve el valord e la referencia al anterior nodo
     * @return nodo anterior
     */
    public Node<T> getPrevious() {
        return this.previous;
    }

    /**
     * Getter
     * Devuelve el valorde la referencia al siguiente nodo
     * @return next
     */
    public Node<T> getNext() {
        return this.next;
    }
}