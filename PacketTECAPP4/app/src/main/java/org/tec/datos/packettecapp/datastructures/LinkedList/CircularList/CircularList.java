package org.tec.datos.packettecapp.datastructures.LinkedList.CircularList;


import org.tec.datos.packettecapp.datastructures.LinkedList.DoubleList.Node;

/**
 * Clase CircularList
 * Es una lista circular Doblemente enlazada de datos genéricos
 * @param <T> : dato de tipo Generics
 */
public class CircularList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    /**
     * Constructor
     * Iniciliza los atributos
     */
    public CircularList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Método length
     *
     * @return tamaño de la lista
     */
    public int length() {
        return this.size;
    }

    /**
     * Metodo booleano
     *
     * @return si la lista esta vacia
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Metodo encargado de agregar al final de la lista un dato
     *
     * @param item dato a insertar de tipo T
     */
    public void addLast(T item) {
        this.addLast_aux(item);
    }

    /**
     * Metodo encargado de buscar un nodo segun su posicion
     *
     * @param pos : < this.length
     * @return nodo en la pos
     */
    public Node<T> find(int pos) {
        return this.find_aux(pos);
    }

    /**
     * Elimina un nodo por su posicion
     *
     * @param pos posicion a eliminar
     */
    public void deletePos(int pos) {
        this.deletePos_aux(pos);
    }


    public void update(T item, T newValue) {
        update_aux(item, newValue);
    }

    //Metodos privados

    private Node<T> find_aux(int pos) {
        Node<T> temp = this.first;
        if (this.isEmpty()) {
            return null;
        } else {
            if (pos <= this.length()) {
                for (int i = 0; i < pos; i++) {
                    temp = temp.getNext();
                }
                return temp;

            }
            return null;
        }
    }

    private void deletePos_aux(int pos) {
        Node<T> temp = this.first;
        if (!this.isEmpty()) {
            if (this.size == 1) {
                this.first = null;
                this.last = this.first;
            } else if (pos == 0) {
                temp.getNext().setPrevious(this.last);
                this.last.setNext(temp.getNext());
                this.first = temp.getNext();
                this.size--;
            } else if (pos == 0 && this.length() == 1) {
                this.last = null;
                this.first = null;
                this.size--;
            }
        } else if (!this.isEmpty()) {
            for (int i = 0; i < pos; ++i) {
                temp = temp.getNext();
            }
            if (pos == this.size - 1) {
                temp.getPrevious().setNext(this.first);
                this.last = temp.getPrevious();
                this.size--;
            } else {
                temp.getPrevious().setNext(temp.getNext());
                temp.getNext().setPrevious(temp.getPrevious());
                this.size--;
            }
        }
    }

    public T findItem(int pos) {
        return findI_aux(pos);
    }

    private T findI_aux(int pos) {
        Node<T> temp = this.first;
        if (this.isEmpty()) {
            return null;
        } else {
            if (pos < this.length()) {
                for (int i = 0; i < pos; i++) {
                    temp = temp.getNext();
                }
                return temp.getItem();

            }
            return null;
        }
    }

    private void addLast_aux(T item) {
        if (this.first == null) {
            this.last = new Node();
            this.last.setItem(item);
            this.last.setNext(this.last);
            this.last.setPrevious(this.last);
            this.first = this.last;
            ++this.size;
        } else {
            Node<T> newLast = new Node();
            newLast.setItem(item);
            newLast.setPrevious(this.last);
            newLast.setNext(this.first);
            this.last.setNext(newLast);
            this.first.setPrevious(newLast);
            this.last = newLast;
            ++this.size;
        }
    }

    private void update_aux(T item, T newValue) {
        Node<T> temp = first;
        if (last.getItem() == item) {
            last.setItem(newValue);
        }
        while (temp.getNext() != null) {
            if (temp.getItem() == item) {
                temp.setItem(newValue);
            }
            temp = temp.getNext();
        }

    }
}
