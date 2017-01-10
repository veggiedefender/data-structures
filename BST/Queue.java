/**
 * Queue class doing queue things SUCH AS enqueueueueing, dequeueing, and peeking
 * @author Jesse Li
 */
public class Queue<T> {
    Node<T> first;
    Node<T> last;

    /**
     * Add an element to the queue
     * @param val value to add to queue
     */
    public void enqueue(T val) {
        if (first == null) {
            first = new Node<T>(val);
            last = first;
        } else {
            last.setNext(new Node<T>(val));
            last = last.getNext();
        }
    }

    /**
     * Return value of first element and remove it
     * @return value of first element
     */
    public T dequeue() {
        if (first == null) {
            return null;
        } else {
            T val = first.getValue();
            first = first.getNext();
            return val;
        }
    }

    /**
     * Peek value of first element but don't take it off
     * @return value of first element
     */
    public T peek() {
        if (first == null) {
            return null;
        } else {
            return first.getValue();
        }
    }
}