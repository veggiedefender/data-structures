public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> x = new Stack<Integer>();
        x.push(23);
        x.push(77);
        int y = x.pop();
        System.out.println(y);
        System.out.println(x.peek());
    }
}