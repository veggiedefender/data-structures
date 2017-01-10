/**
 * Class containing a coordinate and helper functions
 * @author Jesse Li
 */

public class Pos {
    int y;
    int x;

    /**
     * Constructor
     * @param  y initial Y position
     * @param  x initial X position
     */
    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }

    /**
     * Copy a position into a new object
     * @return new object identical to current one
     */
    public Pos copy() {
        return new Pos(y, x);
    }
    
    /**
     * Check if two positions are equal
     * @param  other other position to check for equality
     * @return       are the two positions equal?
     */
    public boolean equals(Pos other) {
        return other.getX() == x && other.getY() == y;
    }

    /**
     * Check if two positions are not equal
     * @param  other other position to check for inequality
     * @return       are the two positions inequal?
     */
    public boolean notEquals(Pos other) {
        return !(this.equals(other));
    }

    /**
     * Get X coordinate
     * @return X coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get Y coordinate
     * @return Y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Move position up
     */
    public void moveUp() {
        y--;
    }

    /**
     * Move position down
     */
    public void moveDown() {
        y++;
    }

    /**
     * Move position left
     */
    public void moveLeft() {
        x--;
    }

    /**
     * Move position right
     */
    public void moveRight() {
        x++;
    }

    /**
     * Create a hypothetical position above the current
     * @return new position
     */
    public Pos testUp() {
        Pos test = this.copy();
        test.moveUp();
        return test;
    }

    /**
     * Create a hypothetical position below the current
     * @return new position
     */
    public Pos testDown() {
        Pos test = this.copy();
        test.moveDown();
        return test;
    }

    /**
     * Create a hypothetical position to the left of the current
     * @return new position
     */
    public Pos testLeft() {
        Pos test = this.copy();
        test.moveLeft();
        return test;
    }

    /**
     * Create a hypothetical position to the right of the current
     * @return new position
     */
    public Pos testRight() {
        Pos test = this.copy();
        test.moveRight();
        return test;
    }

    /**
     * Prints out coordinates separated by a comma.
     */
    public void print() {
        System.out.println(y + ", " + x);
    }
}