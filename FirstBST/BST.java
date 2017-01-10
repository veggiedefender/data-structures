/**
 * Class containing data and methods for a binary search tree
 * Can insert values, print nodes in order, and check for existence
 * @author Jesse Li
 */
public class BST <T> {
    BSTNode<T> root;

    /**
     * Inserts a value into the appropriate spot in the tree
     * @param insertMe value to be inserted
     */
    public void insert(T insertMe) {
        BSTNode<T> curr = root;
        //check if root exists
        if (root == null) {
            //set the root if not
            root = new BSTNode<T>();
            root.set(insertMe);
        } else {
            while (true) {
                if (curr.getc().compareTo(insertMe) > 0) {
                    //item belongs left of current node
                    if (curr.getLeft() == null) {
                        curr.setLeft(new BSTNode<T>());
                        curr = curr.getLeft();
                        curr.set(insertMe);
                        break;
                    }
                    curr = curr.getLeft();
                } else {
                    //item belongs right of current node
                    if (curr.getRight() == null) {
                        curr.setRight(new BSTNode<T>());
                        curr = curr.getRight();
                        curr.set(insertMe);
                        break;
                    }
                    curr = curr.getRight();
                }
            }
        }
    }

    /**
     * Print all values of the tree in order
     * Helper function for inOrderPrint()
     */
    public void inOrderPrint() {
        inOrderPrint(root);
    }

    /**
     * Print all values in order starting from a specified node
     * @param start current node when recursing, or starting node when called first
     */
    public void inOrderPrint(BSTNode<T> start) {
        if (start == null) {
            return;
        }
        inOrderPrint(start.getLeft());
        System.out.println(start.get());
        inOrderPrint(start.getRight());
    }

    /**
     * Check if a value is inside the tree
     * @param  checkMe value to be searched for
     * @return         true if exists, false if not
     */
    public boolean exists(T checkMe) {
        BSTNode<T> curr = root;
        while (curr != null) {
            if (curr.getc().compareTo(checkMe) > 0) {
                curr = curr.getLeft();
            } else if (curr.getc().compareTo(checkMe) < 0) {
                curr = curr.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Class representing nodes in a tree
     */
    public class BSTNode <X>
    {
        X val;
        BSTNode<X> left;
        BSTNode<X> right;

        /**
         * Get pointer to left node
         * @return pointer to left node
         */
        BSTNode<X> getLeft() {
            if (left == null) {
                return null;
            }
            return left;
        }

        /**
         * Get pointer to right node
         * @return pointer to right node
         */
        BSTNode<X> getRight() {
            if (right == null) {
                return null;
            }
            return right;
        }

        /**
         * Set pointer of left node
         * @param bn pointer of left node
         */
        void setLeft(BSTNode<X> bn) {
            left = bn;
        }

        /**
         * Set pointer of right node
         * @param bn pointer of right node
         */
        void setRight(BSTNode<X> bn) {
            right = bn;
        }

        /**
         * Get value of this node
         * @return value of node
         */
        X get() {
            return val;
        }

        /**
         * Set value of this node
         * @param v new value
         */
        void set(X v) {
            val = v;
        }

        /**
         * need a version of get that returns a comparable object,
         * because compareTo won't work on generic types by default
         * use get when you need to access the value, use getc
         * when you need to do a comparison
         * This will crash if a non-comparable object is used.
         * @return value typecasted to a comparable object
         */
        Comparable<X> getc() {
            return (Comparable<X>) val;
        }
    }
}