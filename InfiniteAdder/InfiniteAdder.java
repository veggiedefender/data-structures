/**
 * Reads comma integers from files num1.txt and num2.txt represented
 * by comma separated integers in reverse order, then prints the sum
 * of the two integers, one digit per line.
 * @author Jesse Li
 */

import java.io.*;
import java.util.Scanner;

public class InfiniteAdder {
    /**
     * Reads comma separated integers from a file into a linked list
     * @param  fileName              Name of file to be read
     * @return                       Head of linked list of integers
     * @throws FileNotFoundException Scanner needs this to function
     */
    public static Digit readFile(String fileName) throws FileNotFoundException {
        Scanner scan;
        scan = new Scanner(new BufferedReader(new FileReader(fileName)));
        scan.useDelimiter(",");

        //Set head to first int in scanner
        Digit head = new Digit(scan.nextInt());
        Digit curr = head;

        //Populate linked list with file contents
        while(scan.hasNext()) {
            curr.setNext(new Digit(scan.nextInt()));
            curr = curr.getNext();
        }

        //Add a 0 in front just in case we need to carry one extra
        curr.setNext(new Digit(0));

        return head;
    }
    
    /**
     * Turn a null pointer into a digit with value 0. Used in the case
     * of adding integers with different lengths
     * @param  num Pointer to digit.
     * @return     A digit with either its original value or 0
     */
    public static Digit zeroPad(Digit num) {
        if (num == null) {
            num = new Digit(0);
        }
        return num;
    }
    
    /**
     * Add two linked lists of integers
     * @param  num1 First addend
     * @param  num2 Second addend
     * @return      Tail of linked list containing the sum in reverse order
     */
    public static Digit add(Digit num1, Digit num2) {
        Digit curr1 = num1;
        Digit curr2 = num2;
        
        Digit answer = new Digit(0);
        Digit currAnswer = answer;

        int carry = 0;
        while (curr1 != null || curr2 != null) {
            curr1 = zeroPad(curr1);
            curr2 = zeroPad(curr2);

            //Add numbers and carry if necessary
            int sum = curr1.getValue() + curr2.getValue() + carry;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum - (carry * 10);
            } else {
                carry = 0;
            }

            currAnswer.setNext(new Digit(sum));
            Digit prevAnswer = currAnswer;
            currAnswer = currAnswer.getNext();
            currAnswer.setPrev(prevAnswer);

            curr1 = curr1.getNext();
            curr2 = curr2.getNext();
        }
        
        //currAnswer is conveniently placed at the end
        return currAnswer;
    }
    /**
     * Reads comma integers from files num1.txt and num2.txt represented
     * by comma separated integers in reverse order, then prints the sum
     * of the two integers, one digit per line.
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        try {
            Digit num1 = readFile("num1.txt");
            Digit num2 = readFile("num2.txt");            
            
            Digit answerList = add(num1, num2);

            //Fill in string backwards to un-reverse
            boolean firstDigit = true;
            for(Digit curr = answerList; curr.getPrev() != null; curr = curr.getPrev()) {
                if (firstDigit) {
                    if (curr.getValue() != 0) {
                        System.out.println(curr.getValue());
                    }
                    firstDigit = false;
                } else {
                    System.out.println(curr.getValue());
                }
            }
        } catch (Exception e) {
            System.out.println("WAT " + e);
        }
    }
}
