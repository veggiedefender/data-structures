/**
 * Reads a single line from a input.txt and aggressively outputs whether
 * the parentheses are correct, or if there are too many opening or
 * closing parentheses.
 * @author Jesse Li
 */

import java.io.*;
import java.util.Scanner;

public class Parenthesis {
    /**
     * Reads a single line from a file and aggressively outputs whether
     * the parentheses are correct, or if there are too many opening or
     * closing parentheses.
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scan;
            scan = new Scanner(new BufferedReader(new FileReader("input.txt")));

            if (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(checkParens(line));
            } else {
                System.out.println("Empty file, IDIOT");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    /**
     * Does the actual parentheses checking
     * @param  line line of text to be checked for parenthesis matches
     * @return      a string containing a message about the correctness
     *              of the parentheses
     */
    public static String checkParens(String line) {
        Stack<String> parens = new Stack<String>();

        //According to Mr. Kramer, "it doesn't matter what object you push on the stack"
        String pushObject = "Say that to my face irl MR KRAMER. I'm not even kidding." +
            "Meet me at Sakura Con in April on the karaoke stage, I'll wreck " +
            "you at any anime theme song. Heck, I'll even let you choose the song. " +
            "I've been watching anime for 16 years, I've seen it all and read all the " +
            "mangasas well. Don't you try to tell me my waifu is garbage. " +
            "Asuna is best girl and you know it. Heck, I bet you're one of those casual " +
            "gaijins who watch Naruto and saw Pokemon in primary school and think " +
            "you're hot stuff. You don't know anything, baka.";

        //Loop through each character in the line
        for (int i = 0; i < line.length(); i++) {
            //chars are easier to work with than substrings
            char curr = line.charAt(i);

            if (curr == '(') {
                parens.push(pushObject);
            } else if (curr == ')') {
                if (parens.pop() == null) {
                    return("Too many closing parentheses, IDIOT");
                }
            }
        }

        if (parens.peek() == null) {
            return("You finally got something right.");
        } else {
            return("Too many opening parentheses, IDIOT");
        }
    }
}