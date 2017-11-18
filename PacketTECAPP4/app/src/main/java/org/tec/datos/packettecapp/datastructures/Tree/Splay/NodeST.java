package org.tec.datos.packettecapp.datastructures.Tree.Splay;

public class NodeST <Key extends Comparable<Key>, Value>{
    private Key key;            // key
    private Value value;        // associated data
    private NodeST left, right;   // left and right subtrees

    public NodeST(Key key, Value value) {
        this.key   = key;
        this.value = value;
    }

    public NodeST getLeft() {
        return this.left;
    }

    public NodeST getRight() {
        return this.right;
    }

    public Key getKey() {
        return this.key;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setLeft(NodeST left) {
        this.left = left;
    }

    public void setRight(NodeST right) {
        this.right = right;
    }
}