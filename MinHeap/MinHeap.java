/**
 * Min heap where the root is the lowest value. Can insert, delete, peek,
 * and print values
 * @author Jesse Li
 */
import java.util.*;
public class MinHeap {
    ArrayList<Integer> heap = new ArrayList<Integer>();

    /**
     * Insert a value and sift up to preserve
     * heap structure
     * @param val number to insert
     */
    public void insert(int val) {
        heap.add(val);
        int curr = heap.size() - 1;

        while (val < heap.get(getParent(curr))) {
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
     * Get indices of children given parnet index
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
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /**
     * Delete root value and sift down to
     * preserve heap structure
     * @return value of original root
     */
    public int delete() {
        int ret = heap.get(0);
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
            int val = heap.get(index);
            if (val > heap.get(minChild)) {
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
            if (heap.get(children[0]) < heap.get(children[1])) {
                return children[0];
            } else {
                return children[1];
            }
        } else {
            return -1;
        }
    }

    /**
     * Get root value without deleting
     * @return root value
     */
    public int peek() {
        return heap.get(0);
    }

    /**
     * Print values of heap on one line separated
     * by spaces
     */
    public void print() {
        for (int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}