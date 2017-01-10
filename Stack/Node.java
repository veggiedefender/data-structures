public class Node
{
    int value;
    Node next;
    Node prev;

    public Node(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int v) {
        value = v;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node n) {
        next = n;
    }
    public Node getPrev() {
        return prev;
    }
    public void setPrev(Node p) {
        prev = p;
    }
}