public class Digit
{
    int value;
    Digit next;
    Digit prev;    

    public Digit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int v) {
        value = v;
    }
    public Digit getNext() {
        return next;
    }
    public void setNext(Digit n) {
        next = n;
    }
    public Digit getPrev() {
        return prev;
    }
    public void setPrev(Digit p) {
        prev = p;
    }
}