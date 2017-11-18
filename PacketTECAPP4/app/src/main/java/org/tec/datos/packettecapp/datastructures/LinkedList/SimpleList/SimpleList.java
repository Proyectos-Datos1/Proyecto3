package org.tec.datos.packettecapp.datastructures.LinkedList.SimpleList;


/**
 * Clase SimpleList
 * Es una lista enlazada simple de datos genéricos
 * @param <T> : dato de tipo Generics
 */
public class SimpleList<T> {
    /**
     * Atributos
     * Node first: Referencia al primer nodo de la lista
     * Node last: Referencia al último nodo de la lista
     * int size: tamaño de la lista
     */
    private Node<T> first;
    private Node<T> last;
    private int size=0;

    /**
     * Constructor
     * Iniciliza los atributos
     */
    public SimpleList(){
        this.first=null;
        this.last=null;
        this.size=0;
    }

    /**
     * Método length
     * @return tamaño de la lista
     */
    public int length() {
        return this.size;
    }
    /**
     * Metodo booleano
     * @return si la lista esta vacia
     */
    public boolean isEmpty(){
        return this.first==null;
    }
    /**
     * Metodo encargado de agregar al final de la lista un dato
     * @param item dato a insertar de tipo T
     */
    public void addLast(T item){
        this.addLast_aux(item);
    }
    /**
     * Metodo encargado de buscar un nodo por su valor
     * @param value valor a buscar
     */
    public void search(T value)
    {
        this.search(value, this.first);
    }
    /**
     * Metodo encargar de borrar un dato al ingresar el valor
     * @param posicion valor que se desea eliminar
     */
    public void delete(int posicion){
        delete_aux(posicion);
    }
    /**
     * Metodo encargado de actualizar datos
     * @param oldValue valor viejo a cambiar
     * @param newValue nuevo valor
     */
    public void update(T oldValue, T newValue){
        this.update_aux(oldValue,newValue);
    }
    /**
     * Metodo encargado de buscar un nodo segun su posicion
     * @param pos : < this.length
     * @return nodo en la pos
     */
    public Node<T> find(int pos)
    {
        return find_aux(pos);
    }

    /**
     * Metodo encargado de agregar al inicio de la lista
     * @param item valor a insertar
     */
    public void addFirst(T item){
        this.addFirst_aux(item);
    }
    /**
     * Busca un nodo por indice
     * @param pos < this.length
     * @return item del nodo
     */
    public T findItem(int pos)
    {
        return this.findI_aux(pos);
    }


    /**
     * Borra un elemento de la lista por la posiscion en la que se encuentre
     * @param pos: posicion que quiero borrar
     */
    public void deletePos(int pos) {
        this.deletePos_aux(pos);
    }



    //Metodos privados
    private void addLast_aux(T item)
    {
        Node<T> newLast = new Node<>();
        newLast.setItem(item);
        if (this.isEmpty())
        {
            this.last = newLast;
            this.first = newLast;
            ++this.size;
        }
        else
        {
            this.last.setNext(newLast);
            this.last = newLast;
            ++this.size;

        }
    }

    private void delete_aux(int posicion) {

        if(posicion>=0 && posicion<this.size){
            if(posicion == 0){
                this.first = this.first.getNext();
            }

            else{

                Node aux = this.first;
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getNext();
                }
                Node siguiente = aux.getNext();

                aux.setNext(siguiente.getNext());
            }

            this.size--;
        }
    }

    private void update_aux(T item, T newValue)
    {
        Node<T> temp = first;
        if (last.getItem()==item)
        {
            last.setItem(newValue);
        }
        while (temp.getNext()!=null)
        {
            if (temp.getItem()==item)
            {
                temp.setItem(newValue);
            }
            temp=temp.getNext();
        }

    }

    private void search(T value, Node<T> temp)
    {

        if(temp.getItem()==value)
        {

            this.search(temp.getItem()==value);
        }
        else if (temp.getNext()==null)
        {
            this.search(temp.getItem()==value);
        }
        else
        {
            this.search(value, temp.getNext());
        }
    }

    private boolean search(boolean x)
    {
        System.out.println(x);
        return x;
    }

    private Node<T> find_aux(int pos)
    {
        Node<T> temp = this.first;
        if(this.isEmpty())
        {
            return null;
        }
        else {
            if (pos <= this.length())
            {
                for (int i=0; i<pos; i++)
                {
                    temp= temp.getNext();
                }
                return temp;

            }
            return null;
        }
    }

    private T findI_aux(int pos)
    {
        Node<T> temp = this.first;
        if(this.isEmpty())
        {
            return null;
        }
        else {
            if (pos < this.length())
            {
                for (int i=0; i<pos; i++)
                {
                    temp= temp.getNext();
                }
                return temp.getItem();

            }
            return null;
        }
    }

    private void addFirst_aux(T item){
        Node<T> newFirst = new Node<>();
        newFirst.setItem(item);
        //newFirst.setNext(null);

        if(this.isEmpty()){
            this.first=newFirst;
            this.last=newFirst;
            ++this.size;
        }
        else {
            newFirst.setNext(this.first);
            this.first=newFirst;
            ++this.size;
        }

    }

    private void deletePos_aux(int pos) {
        Node<T> temp = this.first;
        if(!this.isEmpty()) {
            if (this.size == 1) {
                this.first = null;
                this.last = this.first;
            } else if (pos == 0) {
                this.last.setNext(temp.getNext());
                this.first = temp.getNext();
                this.size--;
            }
            else if (pos == 0&&this.length()==1) {
                this.last=null;
                this.first=null;
                this.size--;
            }
            else if(pos==this.size-1) {
                temp.setNext(null);
                this.last = temp;
                this.size--;
            }
        }
        else if(!this.isEmpty())
        {
            for (int i = 0; i < pos-1; ++i) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            this.size--;
        }
    }


}