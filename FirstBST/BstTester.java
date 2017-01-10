/**
 * Test class for BST
 * Expected output:
 *
 * TESTING INTEGERS
 * Root: 6
 * 
 * 4 exists:  true
 * 7 exists:  true
 * 
 * 0 exists:  false
 * 11 exists: false
 * 
 * Printed in order:
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 
 * TESTING STRINGS
 * Root: Crabcake
 * 
 * Salmon exists:   true
 * Aaron exists:    true
 * 
 * Biscotti exists: false
 * Shark exists:    false
 * 
 * Printed in order:
 * Aardvark
 * Aaron
 * Biscuit
 * Boulevard
 * Crabcake
 * Dalmation
 * Salmon
 * Salmons
 * Shunty
 * 
 * @author Jesse Li
 */

public class BstTester <T> {
    public static void main(String[] args) {
        System.out.println("TESTING INTEGERS");
        BST<Integer> tree = new BST<Integer>();

        tree.insert(6);
        tree.insert(3);
        tree.insert(7);
        tree.insert(4);
        tree.insert(8);
        tree.insert(1);
        tree.insert(2);
        tree.insert(5);
        tree.insert(9);

        System.out.println("Root: " + tree.root.get());
        System.out.println();

        System.out.println("4 exists:  " + tree.exists(4));
        System.out.println("7 exists:  " + tree.exists(7));

        System.out.println();

        System.out.println("0 exists:  " + tree.exists(0));
        System.out.println("11 exists: " + tree.exists(11));

        System.out.println("\nPrinted in order:");
        tree.inOrderPrint();
        System.out.println();
        ///////////////////////////////////////////////////
        System.out.println("TESTING STRINGS");
        BST<String> tree2 = new BST<String>();

        tree2.insert("Crabcake");
        tree2.insert("Zebra");
        tree2.insert("Aardvark");
        tree2.insert("Dalmation");
        tree2.insert("Salmons");
        tree2.insert("Boulevard");
        tree2.insert("Aaron");
        tree2.insert("Salmon");
        tree2.insert("Shunty");

        System.out.println("Root: " + tree2.root.get());
        System.out.println();

        System.out.println("Salmon exists:   " + tree2.exists("Salmon"));
        System.out.println("Aaron exists:    " + tree2.exists("Aaron"));

        System.out.println();

        System.out.println("Biscotti exists: " + tree2.exists("Biscotti"));
        System.out.println("Shark exists:    " + tree2.exists("Shark"));

        System.out.println("\nPrinted in order:");
        tree2.inOrderPrint();
    }
}