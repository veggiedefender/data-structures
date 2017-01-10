/**
 * Class containing data and methods for inserting, reading, and balancing
 * a binary search tree.
 * @author Jesse Li
 */

import java.util.*;

public class BST <T> {
    BSTNode <T> root;

    /**
     * Prints the tree level by level, separating leaves with tab (\t) characters
     * and separating depths with newlines.
     */
    public void printTree() {
        reset(root);
        //Normally against single letter variables but this is clever as HECK
        //Also queue's spelling makes no sense
        Queue<BSTNode<T>> q = new Queue<BSTNode<T>>();
        ArrayList<BSTNode<T>> nodes = new ArrayList<BSTNode<T>>();
        root.setDepth(0);
        q.enqueue(root);
        nodes.add(root);
        
        //BFS
        int depth = 0;
        while (q.peek() != null) {
            BSTNode<T> curr = q.dequeue();

            //Print leaf and newline if depth is increased
            if (curr.getDepth() > depth) {
                depth++;
                System.out.println();
            }
            System.out.print(curr.get() + "\t");

            ArrayList<BSTNode<T>> adjacents = new ArrayList<BSTNode<T>>();
            adjacents.add(curr.getLeft());
            adjacents.add(curr.getRight());

            for (BSTNode<T> node : adjacents) {
                if (node != null && node.depth == -1) {
                    node.setDepth(curr.getDepth() + 1);
                    q.enqueue(node);
                }
            }
        }
        System.out.println();
    }

    /**
     * Does an in-order traversal to set all depths to -1
     * signifying unexplored
     * @param parent Node to start traversal from. Usually the root.
     */
    public void reset(BSTNode<T> parent) {
        if (parent == null) return;
        reset(parent.getLeft());
        parent.setDepth(-1);
        reset(parent.getRight());
    }

    /**
     * Rebalances the tree so there are as few levels as possible for more
     * efficient searches and insertions
     */
    public void balance() {
        ArrayList<T> elements = new ArrayList<T>();
        fillInOrder(root, elements);
        root = new BSTNode<T>();
        balance_re(root, elements, 0, elements.size() - 1);
    }

    /**
     * Recursive function used by balance()
     * @param node     node to operate on
     * @param elements sorted ArrayList of all elements in the tree
     * @param start    start of slice of elements
     * @param end      end of slice of elements
     */
    private void balance_re(BSTNode<T> node, ArrayList<T> elements, int start, int end) {
        //get the middle and set current node
        int middle = (start + end) / 2;
        node.set(elements.get(middle));

        if (middle - start > 0) {
            node.setLeft(new BSTNode<T>());
            balance_re(node.getLeft(), elements, start, middle - 1);
        }

        if (end - middle > 0) {
            node.setRight(new BSTNode<T>());
            balance_re(node.getRight(), elements, middle + 1, end);
        }
    }

    /**
     * Fill an ArrayList with the sorted elements of the tree
     * @param node     Node to start in order traversal from. Usually root
     * @param elements ArrayList to populate with tree elements
     */
    private void fillInOrder(BSTNode<T> node, ArrayList<T> elements) {
        if (node == null) {
            return;
        }
        fillInOrder(node.getLeft(), elements);
        elements.add(node.get());
        fillInOrder(node.getRight(), elements);
    }
    
    /**
     * insert a single element into the tree. It is potentially possible to mess up the tree by modifying an element after insertion.
     * @param in the element to insert (the actual instance is inserted, NOT A CLONE)
     */
    public void insert(T in) {
        if (in == null) return;
        BSTNode <T> bin = new BSTNode<T>();
        bin.set(in);
        if (root == null) {
            root = bin;
        } else {
            insert_re(root, bin);
        }
    }

    private void insert_re(BSTNode parent, BSTNode insertMe) {
        if (parent.getc().compareTo(insertMe.getc()) > 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(insertMe);
            } else {
                insert_re(parent.getLeft(), insertMe);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(insertMe);
            } else {
                insert_re(parent.getRight(), insertMe);
            }
        }
    }

    /**
     * in order traversal of the tree, using println to output the elements
     */
    public void inOrderPrint() {
        if (root != null) {
            inOrderPrint_re(root);
        }
    }

    private void inOrderPrint_re(BSTNode<T> parent) {
        if (parent == null) return;
        inOrderPrint_re(parent.getLeft());
        System.out.println(parent.get());
        inOrderPrint_re(parent.getRight());
    }

    /**
     * See if an element exists in the tree
     * @param q element to search for in the tree
     * @return true if an element in the tree is equal to the q, false otherwise
     */
    public boolean exists(T q) {
        return exists_re(q,root);
    }

    private boolean exists_re(T q, BSTNode<T> parent) {
        if (parent == null) return false;
        if (((Comparable)q).compareTo(parent.getc()) == 0) { //Typecasting shenanigans necessary for compareTo to work
            return true;
        } else if (((Comparable)q).compareTo(parent.getc()) < 0) {
            return exists_re(q, parent.getLeft());
        } else {
            return exists_re(q, parent.getRight());
        }
    }

    public class BSTNode <X>
    {
        X val;
        BSTNode left;
        BSTNode right;
        int depth;

        BSTNode getLeft() {return left;}

        BSTNode getRight() {return right;}

        void setLeft(BSTNode bn) {left = bn;}

        void setRight(BSTNode bn) {right = bn;}

        X get() {return val;}

        void set(X v) {val = v;}

        Comparable getc() {return (Comparable) val;}

        void setDepth(int d) {depth=d;}
        int getDepth() {return depth;}
    }
}
