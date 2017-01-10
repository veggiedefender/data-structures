/**
 * @author Jesse Li
 */

public class BstTester <T> {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        
        tree.printTree();

        System.out.println("\nBALANCING\n");
        tree.balance();

        tree.printTree();
    }
}