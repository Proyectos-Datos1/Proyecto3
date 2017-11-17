package org.tec.datos.datastructures.Tree.BinarySearch;



public class ArbolBB<T extends Comparable<? super T>>
{

    // Local variables
    private BinaryNode<T> root;					// Pointer to root node, if present
    private boolean removalSuccesful;	// Set to true when remove() succeeds


    public ArbolBB()
    {
        this.root = null;
    }


    public boolean isEmpty()
    {
        return (this.root == null);
    }


    public T find(T elem)
    {
        BinaryNode found = find(this.root, elem);
        return (found == null) ? null : (T) found.getElement();
    }


    private BinaryNode find(BinaryNode start, T elem)
    {
        // If the element isn't found, return null
        if (start == null)
        {
            return null;
        }

        // Compare the current node's element to the element we're looking for
        int comparison = start.getElement().compareTo(elem);


        // If we should look down the left tree
        if (comparison > 0)
        {
            return find(start.getLeft(), elem);
        }
        // If we should look down the right tree
        else if (comparison < 0)
        {
            return find(start.getRight(), elem);
        }
        // If we've found it
        else
        {
            return start;
        }
    }


    public boolean insert(T elem)
    {
        return insert_aux(this.root, elem);
    }


    private boolean insert_aux(BinaryNode start, T elem)
    {
        // We've reached the point of insertion
        if (start == null)
        {
            // Insert our element into a new node
            this.root = new BinaryNode<>(elem, null, null);
            return true;
        }

        // Compare the current node's element to the element we're looking to
        // delete
        int comparison = start.getElement().compareTo(elem);

        // If are insertion will happen somewhere down the left tree
        if (comparison > 0)
        {
            // If we've reached the point of insertion
            if (start.getLeft() == null)
            {
                // Insert our element into a new node
                start.setLeft(new BinaryNode<>(elem, null, null));
                return true;
            }

            // Otherwise, keep traversing until we reach the point of insertion
            return insert_aux(start.getLeft(), elem);
        }
        // If are insertion will happen somewhere down the right tree
        else if (comparison < 0)
        {
            // If we've reached the point of insertion
            if (start.getRight() == null)
            {
                // Insert our element into a new node
                start.setRight(new BinaryNode<>(elem, null, null));
                return true;
            }

            // Otherwise, keep traversing until we reach the point of insertion
            return insert_aux(start.getRight(), elem);
        }
        // If the element is already in the tree
        else
        {
            // Don't insert the element
            return false;
        }
    }


    public boolean remove(T elem)
    {
        removalSuccesful = true;
        this.root = remove(root, elem);
        return removalSuccesful;
    }


    private BinaryNode<T> remove(BinaryNode<T> start, T elem)
    {
        // If the element we want to delete wasn't found
        if (start == null)
        {
            // Go back up the recursive loop, but let our object know that the
            // element we wanted to delete wasn't found
            removalSuccesful = false;
            return null;
        }

        // Compare the current node's element to the element we're looking for
        int comparison = start.getElement().compareTo(elem);

        // If the deletion will happen somewhere down the left tree
        if (comparison > 0)
        {
            // Attempt to delete down the left tree
            start.setLeft(remove(start.getLeft(), elem));
        }
        // If the deletion will happen somewhere down the right tree
        else if (comparison < 0)
        {
            // Attempt to delete down the right tree
            start.setRight(remove(start.getRight(), elem));
        }
        // If we are at the element we want to delete
        else
        {
            // If the node we want to delete has two children
            if (start.getLeft() != null && start.getRight() != null)
            {
                // Back up pointers
                BinaryNode<T> left = start.getLeft();
                BinaryNode<T> right = start.getRight();

                // Replace the current element with the smallest element in the
                // right subtree
                start = removeMin(start.getRight(), start);

                // Back up pointer
                BinaryNode minRight = start.getRight();

                // Fix pointers
                start.setLeft(left);
                start.setRight(right);

                // We need to fix start.right if it points to the node we just
                // moved
                if (start.getRight().getElement() == start.getElement())
                {
                    start.setRight(minRight);
                }
            }
            // If the node we want to delete is a leaf
            else if (start.getLeft() == null && start.getRight() == null)
            {
                // Delete the current node from the tree
                start = null;
            }
            // If the node we want to delete just has a left child
            else if (start.getLeft() != null)
            {
                start = start.getLeft();
            }
            // If the node we want to delete just has a right child
            else
            {
                start = start.getRight();
            }
        }

        return start;
    }



    private BinaryNode<T> removeMin(BinaryNode<T> start, BinaryNode parent)
    {
        // If there is nothing to traverse or remove
        if (start == null)
        {
            return null;
        }

        // If we've found the minimum node
        if (start.getLeft() == null)
        {
            // Save the important values from the node
            //T elem = start.element;
            //BinaryNode deletedRight = start.right;

            // Rewire nodes
            if (parent != this.root)
            {
                parent.setLeft(start.getRight()); //deletedRight;
            }

            //start = null;

            // Return a new node that follows this method's specifications
            return start;
        }

        // Recurse until we get to the minimum node
        return removeMin(start.getLeft(), start);
    }


    public void clear()
    {
        this.root = null;
    }


    @SuppressWarnings("unchecked")
    public boolean equals(Object other)
    {
        // Make sure a BST was passed in
        if (other instanceof ArbolBB)
        {
            // Attempt to determine the equality of the two BSTs
            try
            {
                ArbolBB<T> compare = (ArbolBB<T>) other;
                return equals(this.root, compare.root);
            }
            // In case the user passes a BST filled with different kind of
            // elements
            catch (Exception e)
            {
                return false;
            }
        }

        return false;
    }


    private boolean equals(BinaryNode<T> start1, BinaryNode<T> start2)
    {
        // If we've reached the end of each tree without any differences
        if (start1 == null && start2 == null)
        {
            // They are the same
            return true;
        }
        // If we've reached the end of one tree but not the other
        else if (start1 == null || start2 == null)
        {
            // They are different
            return false;
        }

        // Determine whether the left subtrees are equivalent
        boolean leftSame = equals(start1.getLeft(), start2.getLeft());

        // Determine whether the current elements are equivalent
        boolean currentSame = start1.getElement().equals(start2.getElement());

        // Determine whether the right subtrees are equivalent
        boolean rightSame = equals(start1.getRight(), start2.getRight());

        // Return true if everything is equivalent
        return (leftSame && currentSame && rightSame);
    }


    public void print()
    {
        print(this.root);
    }


    private void print(BinaryNode start)
    {
        if (start != null)
        {
            print(start.getLeft());
            System.out.println(start.getElement());
            print(start.getRight());
        }
    }
}