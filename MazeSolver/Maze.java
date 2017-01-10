/**
 * Maze class containing a maze and methods for operating on the maze
 * @author Jesse Li
 */

import java.io.*;
import java.util.Scanner;

public class Maze {
    char[][] maze;
    Pos start;
    Pos end;
    int width = 0;
    int height = 0;

    final char START = '@';
    final char END = '$';
    final char WALL = '#';
    final char PATH = '.';

    /**
     * Constructor method. Reads a maze into a 2D array of chars
     * @param  mazeFile              path to file containing maze
     * @throws FileNotFoundException thrown when specified file does not exist
     */
    public Maze(String mazeFile) throws FileNotFoundException {
        //Find dimensions of maze
        Scanner scan = new Scanner(new BufferedReader(new FileReader(mazeFile)));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            height++;
            width = line.length();
        }
        maze = new char[height][width];

        scan = new Scanner(new BufferedReader(new FileReader(mazeFile)));

        //Fill in maze array
        for(int i = 0; i < height; i++) {
            String line = scan.nextLine();
            for(int j = 0; j < width; j++) {
                char c = line.charAt(j);
                maze[i][j] = line.charAt(j);

                //Set start and end points when encountered
                if (c == START) {
                    start = new Pos(i, j);
                }
                if (c == END) {
                    end = new Pos(i, j);
                }
            }
        }
    }

    /**
     * Checks the specified spot for it it's a legal move
     * @param  pos position to be checked
     * @return     is the move legal?
     */
    public boolean check(Pos pos) {
        try {
            char c = maze[pos.getY()][pos.getX()];
            return (c == PATH || c == START || c == END );
        } catch (ArrayIndexOutOfBoundsException e) {
            //places outside the maze are illegal
            return false;
        }
    }

    /**
     * Marks a position on the maze visited
     * @param curr position to mark
     */
    public void setVisited(Pos curr) {
        maze[curr.getY()][curr.getX()] = '?';
    }
    
    /**
     * Prints the maze and a marker indicating current position
     * Unused in final product but useful for debugging or showing off
     * @param pos position to be marked as current position
     */
    public void printMazeAnimated(Pos pos) {
        System.out.println("\n\n\n\n\n\n\n\n\n");
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++) {
                if(i == pos.getY() && j == pos.getX()) {
                    System.out.print("O");
                } else {
                    System.out.print(maze[i][j]);
                }
            }
            System.out.println();
        }        
    }
    
    /**
     * Get start position of maze
     * @return start position of maze
     */
    public Pos getStart() {
        return start;
    }

    /**
     * Get end position of maze
     * @return end position of maze
     */
    public Pos getEnd() {
        return end;
    }

}