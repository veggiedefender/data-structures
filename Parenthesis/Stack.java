public class Stack<T> {
    Node<T> top;

    public void push(T newValue) {
        Node<T> n = new Node<T>(newValue);
        n.setNext(top);
        top = n;
    }
    
    public T pop() {
        if (top == null) {
            return null;
        }
        Node<T> ret = top;
        top = top.getNext();
        ret.setNext(null);
        return ret.getValue();
    }
    
    public T peek() {
        if (top == null) {
            return null;
        }
        return top.getValue();
    }
}