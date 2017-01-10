/**
 * Solves a maze specified in maze.txt and outputs solution in
 * the form of coordinates.
 * # = wall
 * . = path
 * @ = start
 * $ = end
 * 
 * @author Jesse Li
 */

public class MazeSolver {
    /**
     * Solves a maze specified in maze.txt and outputs solution in
     * the form of coordinates.
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        try {
            Maze maze = new Maze("maze.txt");
            Stack<Pos> solution = solve(maze);
            while (solution.peek() != null) {
                solution.pop().print();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }

    /**
     * Does the actual maze solving
     * @param  maze Maze object containing maze to be solved
     * @return      stack of coordinates of the solution
     */
    public static Stack<Pos> solve(Maze maze) {
        //Set start and end to the opposites so we solve
        //the maze backwards and popping off the solution
        //stack yields the "correct" solution
        Pos start = maze.getEnd().copy();
        Pos end = maze.getStart().copy();

        Pos curr = start;
        Stack<Pos> steps = new Stack<Pos>();
        steps.push(curr.copy());

        //Check up, left, right, and down in that order
        //for an empty spot
        while (steps.peek().notEquals(end)) {
            if (maze.check(curr.testUp())) {
                curr.moveUp();
                maze.setVisited(curr);
                steps.push(curr.copy());
            } else if (maze.check(curr.testLeft())) {
                curr.moveLeft();
                maze.setVisited(curr);
                steps.push(curr.copy());
            } else if (maze.check(curr.testRight())) {
                curr.moveRight();
                maze.setVisited(curr);
                steps.push(curr.copy());
            } else if (maze.check(curr.testDown())) {
                curr.moveDown();
                maze.setVisited(curr);
                steps.push(curr.copy());
            } else {
                //if none are free, pop to backtrack
                steps.pop();
                curr = steps.peek().copy();
            }
        }
        return steps;
    }
}