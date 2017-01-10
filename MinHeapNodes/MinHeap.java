/**
 * Min heap of nodes where the root is the lowest cost. Can insert, delete, peek,
 * and print values
 * @author Jesse Li
 */
import java.util.*;
public class MinHeap {
    ArrayList<Node> heap = new ArrayList<Node>();

    /**
     * Insert a value and sift up to preserve
     * heap structure
     * @param val number to insert
     */
    public void insert(int cost, int number) {
        Node val = new Node(cost, number);
        heap.add(val);
        int curr = heap.size() - 1;

        while (val.getCost() < heap.get(getParent(curr)).getCost()) {
            swap(curr, getParent(curr));
            curr = getParent(curr);
        }
    }

    /**
     * Get index of parent given child index
     * @param  index index of child
     * @return       index of parent
     */
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Get indices of children given parent index
     * @param  index parent index
     * @return       array of child indices
     */
    private int[] getChildren(int index) {
        int[] children = new int[] {
            2 * index + 1,
            2 * index + 2
        };
        return children;
    }

    /**
     * Swap values of two indices
     * @param index1 first index
     * @param index2 second inxed
     */
    private void swap(int index1, int index2) {
        Node temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /**
     * Delete root value and sift down to
     * preserve heap structure
     * @return value of original root
     */
    public int delete() {
        int ret = heap.get(0).getCost();
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        siftDown(0);

        return ret;
    }

    /**
     * Sift down recursively
     * @param index index of node we are on, 0 if starting
     */
    private void siftDown(int index) {
        int[] children = getChildren(index);
        int minChild = min(children);

        if (minChild == -1) {
            return;
        } else {
            int val = heap.get(index).getCost();
            if (val > heap.get(minChild).getCost()) {
                swap(index, minChild);
                siftDown(minChild);
            }
        }
    }

    /**
     * Get the index of the child that has the least value
     * @param  children children to compare values for
     * @return          index of min value, -1 if out of range
     */
    private int min(int[] children) {
        int max = heap.size() - 1;
        if (children[0] <= max && children[1] <= max) {
            if (heap.get(children[0]).getCost() < heap.get(children[1]).getCost()) {
                return children[0];
            } else {
                return children[1];
            }
        } else {
            return -1;
        }
    }

    /**
     * Get root cost without deleting
     * @return root cost
     */
    public int peek() {
        return heap.get(0).getCost();
    }

    /**
     * Get root node number without deleting
     * @return [description]
     */
    public int peekNode() {
        return heap.get(0).getNumber();
    }

    /**
     * Print values of heap on one line separated
     * by spaces
     */
    public void print() {
        for (Node i : heap) {
            System.out.print(i.getCost() + " ");
        }
        System.out.println();
    }

    /**
     * Node class with a number and a cost.
     * You can get those values with the appropriate
     * getters. You can only set values using
     * the constructor.
     */
    public class Node {
        int number;
        int cost;

        Node(int c, int n) {
            cost = c;
            number = n;
        }

        int getNumber() {
            return number;
        }
        int getCost() {
            return cost;
        }
    }
}