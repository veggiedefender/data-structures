public class Node<T>
{
    T value;
    Node<T> next;
    Node<T> prev;

    public Node(T v) {
        value = v;
    }

    public T getValue() {
        return value;
    }
    public void setValue(T v) {
        value = v;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> n) {
        next = n;
    }
    public Node<T> getPrev() {
        return prev;
    }
    public void setPrev(Node<T> p) {
        prev = p;
    }
}