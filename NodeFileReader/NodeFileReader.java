/**
 * Reads comma separated numbers from nums.txt and prints the
 * numbers out on separate lines.
 * 
 * @author Jesse Li
 */

import java.io.*;
import java.util.Scanner;

public class NodeFileReader
{
    /**
     * Reads comma separated numbers from nums.txt and prints the
     * numbers out on separate lines.
     * @param args array of command line arguments
     */
    public static void main(String [] args) {
        try {
            Scanner scan;
            scan = new Scanner(new BufferedReader(new FileReader("nums.txt")));
            scan.useDelimiter(",");

            //set head to first int in scanner
            Node head = new Node(scan.nextInt());
            Node curr = head;

            while(scan.hasNext()) {
                curr.setNext(new Node(scan.nextInt()));
                curr = curr.getNext();
            }

            //loop through nodes
            curr = head;
            while(curr != null) {
                System.out.println(curr.getValue());
                curr = curr.getNext();
            }
        }
        catch (Exception e) {
            System.out.println("WAT");
            System.exit(0);
        }
    }
}
