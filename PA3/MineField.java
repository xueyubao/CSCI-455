// Name: Jiahui Liu
// USC NetID: jliu4728@usc.edu
// CS 455 PA3
// Spring 2020


import java.util.Random;

/**
 * MineField
 * class with locations of mines for a game.
 * This class is mutable, because we sometimes need to change it once it's created.
 * mutators: populateMineField, resetEmpty
 * includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {
    // <put instance variables here>
    private int[][] mineField;
    private int numRows;
    private int numCols;
    private int numMines;
    private final int NO_MINES = 0;
    private final int HAS_MINE = 1;
    private Random randomGenerator;


    /**
     * Create a minefield with same dimensions as the given array, and populate it with the mines in the array
     * such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
     * this minefield will corresponds to the number of 'true' values in mineData.
     *
     * @param mineData the data for the mines; must have at least one row and one col.
     */
    public MineField(boolean[][] mineData) {
        assert mineData.length >= 1 && mineData[0].length >= 1;
        this.numRows = mineData.length;
        this.numCols = mineData[0].length;
        this.mineField = new int[numRows][numCols];
        int numTrue = 0;
        for (int i = 0; i <= numRows - 1; i++) {
            for (int j = 0; j <= numCols - 1; j++) {
                if (mineData[i][j] == true) {
                    mineField[i][j] = HAS_MINE;
                    numTrue++;
                }
            }
        }
        numMines = numTrue;
    }


    /**
     * Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once
     * populateMineField is called on this object).  Until populateMineField is called on such a MineField,
     * numMines() will not correspond to the number of mines currently in the MineField.
     *
     * @param numRows  number of rows this minefield will have, must be positive
     * @param numCols  number of columns this minefield will have, must be positive
     * @param numMines number of mines this minefield will have,  once we populate it.
     *                 PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations).
     */
    public MineField(int numRows, int numCols, int numMines) {
        assert numRows > 0 && numCols > 0;
        assert numMines > 0 && numMines < numRows * numCols / 3.0;
        this.numRows = numRows;
        this.numCols = numCols;
        this.numMines = numMines;
        mineField = new int[numRows][numCols];
        randomGenerator = new Random();
    }


    /**
     * Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
     * ensuring that no mine is placed at (row, col).
     *
     * @param row the row of the location to avoid placing a mine
     * @param col the column of the location to avoid placing a mine
     *            PRE: inRange(row, col)
     */
    public void populateMineField(int row, int col) {
        assert inRange(row, col);
        resetEmpty();
        int currMine = numMines;
        while (currMine > 0) {
            int putRow = new Random().nextInt(numRows());
            int putCol = new Random().nextInt(numCols());
            if (mineField[putRow][putCol] == NO_MINES ) {
                mineField[putRow][putCol] = HAS_MINE;
            }
            currMine--;
        }


    }


    /**
     * Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
     * Thus, after this call, the actual number of mines in the minefield does not match numMines().
     * Note: This is the state the minefield is in at the beginning of a game.
     */
    public void resetEmpty() {
        mineField = new int[numRows][numCols];
    }


    /**
     * Returns the number of mines adjacent to the specified mine location (not counting a possible
     * mine at (row, col) itself).
     * Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     *
     * @param row row of the location to check
     * @param col column of the location to check
     * @return the number of mines adjacent to the square at (row, col)
     * PRE: inRange(row, col)
     */
    public int numAdjacentMines(int row, int col) {
        int numNear = 0;       // DUMMY CODE so skeleton compiles
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if ( inRange(i, j) && (i != row || j != col)) {
                    if (mineField[i][j] == HAS_MINE) {
                        numNear++;
                    }
                }
            }
        }
        return numNear;
    }


    /**
     * Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
     * start from 0.
     *
     * @param row row of the location to consider
     * @param col column of the location to consider
     * @return whether (row, col) is a valid field location
     */
    public boolean inRange(int row, int col) {
        if ((row >= 0 && row <= numRows() - 1) && (col >= 0 && col <= numCols() - 1)) {
            return true;
        }
        return false;       // DUMMY CODE so skeleton compiles
    }


    /**
     * Returns the number of rows in the field.
     *
     * @return number of rows in the field
     */
    public int numRows() {
        return numRows;       // DUMMY CODE so skeleton compiles
    }


    /**
     * Returns the number of columns in the field.
     *
     * @return number of columns in the field
     */
    public int numCols() {
        return numCols;       // DUMMY CODE so skeleton compiles
    }


    /**
     * Returns whether there is a mine in this square
     *
     * @param row row of the location to check
     * @param col column of the location to check
     * @return whether there is a mine in this square
     * PRE: inRange(row, col)
     */
    public boolean hasMine(int row, int col) {
        assert inRange(row, col);
        if (mineField[row][col] == HAS_MINE) {
            return true;
        }
        return false;       // DUMMY CODE so skeleton compiles
    }


    /**
     * Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
     * some of the time this value does not match the actual number of mines currently on the field.  See doc for that
     * constructor, resetEmpty, and populateMineField for more details.
     *
     * @return
     */
    public int numMines() {
        return numMines;       // DUMMY CODE so skeleton compiles
    }


    // <put private methods here>


}

