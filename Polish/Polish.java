/**
 * Reads and evaluates polish notation from the first line of polish.txt
 * @author Jesse Li
 */

import java.io.*;
import java.util.Scanner;

public class Polish {
    /**
     * Reads and evaluates polish notation from the first line of polish.txt
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        try {
            Stack<String> input = readFile("polish.txt");
            Stack<Integer> numbers = new Stack<Integer>();
            while (input.peek() != null) {
                //FILO nature of stacks let us read the line in reverse order
                String symbol = input.pop();
                
                //Detect whether symbol is an integer or operator
                //Cute trick or dirty hack depending on who you ask
                try {
                    numbers.push(Integer.parseInt(symbol));
                } catch (NumberFormatException e) {
                    int operand1 = numbers.pop();
                    int operand2 = numbers.pop();
                    
                    numbers.push(compute(operand1, operand2, symbol));
                }
            }

            System.out.println(numbers.peek());
        } catch (Exception e) {
            System.out.println("You done goofed.");
        }
    }
    
    /**
     * Reads file tokenized by spaces into a stack
     * @param  fileName              name of file to read
     * @return                       stack containing tokenized text
     * @throws FileNotFoundException thrown if file doesn't exist
     */
    public static Stack<String> readFile(String fileName) throws FileNotFoundException {
        Scanner file;
        file = new Scanner(new BufferedReader(new FileReader(fileName)));
        Stack<String> input = new Stack<String>();
        
        while(file.hasNext()) {
            input.push(file.next());
        }
        
        return input;
    }
    
    /**
     * Calculate the result when an operator is applied to two operands
     * @param  a        first number
     * @param  b        second number
     * @param  operator operator to be applied
     * @return          value of a operator b
     */
    public static int compute(int a, int b, String operator) {
        if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("*")) {
            return a * b;
        } else if (operator.equals("/")) {
            return a / b;
        } else {
            //This should really throw an error but I don't know how
            System.out.println("Unknown operator '" + operator + "'");
            return 0;
        }
    }
}