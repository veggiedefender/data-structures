/**
 * Stack class. Can push, peek, and pop the stack.
 * @author Jesse Li
 */

public class Stack {
    Node top;
    
    /**
     * Set the top of the stack to a node
     * @param newTop Node to be set to the new top of the stack
     */
    public void push(Node newTop) {
        newTop.setPrev(top);
        top = newTop;
    }
    
    /**
     * Returns node on top of the stack
     * @return the top of the stack
     */
    public Node peek() {        
        return top;
    }
    
    /**
     * Returns node on top of the stack and remove it
     * @return the top of the stack
     */
    public Node pop() {
        Node popped = top;
        top = top.getPrev();
        return popped;
    }
}