package org.tec.datos.packettecapp.datastructures.Tree.Splay;
/**
 * Splay Tree
 * Árbol
 * @author Gerald Valverde Mc kenzie
 * @version 2.0
 * @param <Key> : llave de tipo Generics
 * @param <Value> : Dato tipo Generics
 */

public class SplayBST<Key extends Comparable<Key>, Value>  {

    private NodeST<Key,Value> root;   // root of the BST

    // BST helper node data type


    public NodeST<Key,Value> getRoot() {
        return this.root;
    }

    public boolean contains(Key key) {
        return find(key) != null;
    }

    // return value associated with the given key

    // if no such value, return null
    /**
     * Método find
     * Busca un valor por su llave
     * @param key
     * @return valor asociado a la llave
     */
    public Value find(Key key) {
        this.root = splay(this.root, key);
        int cmp = key.compareTo((Key) this.root.getKey());
        if (cmp == 0) return (Value) this.root.getValue();
        else          return null;
    }

    /***************************************************************************
     *  Splay tree insertion.
     ***************************************************************************/
    public void put(Key key, Value value){
        put_aux(key, value);
    }
    private void put_aux(Key key, Value value) {
        // splay key to root
        if (this.root == null) {
            this.root = new NodeST(key, value);
            return;
        }

        this.root = splay(this.root, key);

        int cmp = key.compareTo((Key) this.root.getKey());

        // Insert new node at root
        if (cmp < 0) {
            NodeST n = new NodeST(key, value);
            n.setLeft(this.root.getLeft());
            n.setRight(this.root);
            root.setLeft(null);
            root = n;
        }

        // Insert new node at root
        else if (cmp > 0) {
            NodeST n = new NodeST(key, value);
            n.setRight(root.getRight());
            n.setLeft(root);
            root.setRight(null);
            root = n;
        }

        // It was a duplicate key. Simply replace the value
        else {
            root.setValue(value);
        }

    }

    /***************************************************************************
     *  Splay tree deletion.
     ***************************************************************************/
    /* This splays the key, then does a slightly modified Hibbard deletion on
     * the root (if it is the node to be deleted; if it is not, the key was 
     * not in the tree). The modification is that rather than swapping the
     * root (call it node A) with its successor, it's successor (call it Node B)
     * is moved to the root position by splaying for the deletion key in A's 
     * right subtree. Finally, A's right child is made the new root's right 
     * child.
     */
    public void remove(Key key){
        remove_aux(key);
    }
    private void remove_aux(Key key) {
        if (this.root == null) return; // empty tree

        this.root = splay(this.root, key);

        int cmp = key.compareTo((Key) this.root.getKey());

        if (cmp == 0) {
            if (this.root.getLeft() == null) {
                this.root = this.root.getRight();
            }
            else {
                NodeST x = this.root.getRight();
                this.root = this.root.getLeft();
                splay(this.root, key);
                this.root.setRight(x);
            }
        }

        // else: it wasn't in the tree to remove
    }


    /***************************************************************************
     * Splay tree function.
     * **********************************************************************/
    // splay key in the tree rooted at Node h. If a node with that key exists,
    //   it is splayed to the root of the tree. If it does not, the last node
    //   along the search path for the key is splayed to the root.
    private NodeST splay(NodeST h, Key key) {
        if (h == null) return null;

        int cmp1 = key.compareTo((Key) h.getKey());

        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.getLeft() == null) {
                return h;
            }
            int cmp2 = key.compareTo((Key) h.getLeft().getKey());
            if (cmp2 < 0) {
                h.getLeft().setLeft(splay(h.getLeft().getLeft(), key));
                h = zag(h);
            }
            else if (cmp2 > 0) {
                h.getLeft().setRight(splay(h.getLeft().getRight(), key));
                if (h.getLeft().getRight() != null)
                    h.setLeft(zig(h.getLeft()));
            }

            if (h.getLeft() == null) return h;
            else                return zag(h);
        }

        else if (cmp1 > 0) {
            // key not in tree, so we're done
            if (h.getRight() == null) {
                return h;
            }

            int cmp2 = key.compareTo((Key) h.getRight().getKey());
            if (cmp2 < 0) {
                h.getRight().setLeft(splay(h.getRight().getLeft(), key));
                if (h.getRight().getLeft() != null)
                    h.setRight(zag(h.getRight()));
            }
            else if (cmp2 > 0) {
                h.getRight().setRight(splay(h.getRight().getRight(), key));
                h = zig(h);
            }

            if (h.getRight() == null) return h;
            else                 return zig(h);
        }

        else return h;
    }


    /***************************************************************************
     *  Helper functions.
     ***************************************************************************/

    // height of tree (1-node tree has height 0)
    public int height() { return height(this.root); }
    private int height(NodeST x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.getLeft()), height(x.getRight()));
    }


    public int size() {
        return size(this.root);
    }

    private int size(NodeST x) {
        if (x == null) return 0;
        else return 1 + size(x.getLeft()) + size(x.getRight());
    }

    // right rotate
    private NodeST zag(NodeST h) {
        NodeST x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        return x;
    }

    // zig rotate
    private NodeST zig(NodeST h) {
        NodeST x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        return x;
    }

    // test client


}

