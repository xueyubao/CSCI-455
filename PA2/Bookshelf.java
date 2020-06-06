// Name: Jiahui Liu
// USC NetID: jliu4728@usc.edu
// CSCI455 PA2
// Spring 2020
// Version 1.1

import java.util.ArrayList;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
 */
public class Bookshelf {
    /**
     Representation invariant:

     <put rep. invar. comment here>

     */

    private ArrayList<Integer> bookShelf = null;

    // <add instance variables here>


    /**
     * Creates an empty Bookshelf object i.e. with no books
     */
    public Bookshelf() {
        bookShelf = new ArrayList<Integer>();
        assert isValidBookshelf();  // sample assert statement (you will be adding more of these calls)
    }

    /**
     * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
     * values: [20, 1, 9].
     *
     * PRE: pileOfBooks contains an array list of 0 or more positive numbers
     * representing the height of each book.
     */
    public Bookshelf(ArrayList<Integer> pileOfBooks) {
        this.bookShelf = pileOfBooks;
        assert isValidBookshelf();

    }
    // this is a set method, the typed passed in is ArrayList
    public void setBookShelf(ArrayList<Integer> bookShelf) {
        this.bookShelf = bookShelf;
        assert isValidBookshelf();
    }



    /**
     * Inserts book with specified height at the start of the Bookshelf, i.e., it
     * will end up at position 0.
     *
     * PRE: height > 0 (height of book is always positive)
     */
    public void addFront(int height) {
        assert height > 0;
        bookShelf.add(0,height);
        assert isValidBookshelf();
    }

    /**
     * Inserts book with specified height at the end of the Bookshelf.
     *
     * PRE: height > 0 (height of book is always positive)
     */
    public void addLast(int height) {
        assert height > 0;
        bookShelf.add(height);
        assert isValidBookshelf();
    }


    /**
     * Removes book at the start of the Bookshelf and returns the height of the
     * removed book.
     *
     * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
     */
    public int removeFront() {
        if (size() > 0) {
            return bookShelf.remove(0);
        }
        assert isValidBookshelf();
        return -1;   // dummy code to get stub to compile
    }

    /**
     * Removes book at the end of the Bookshelf and returns the height of the
     * removed book.
     *
     * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
     */
    public int removeLast() {
        if (size() > 0) {
            return bookShelf.remove(size() - 1);
        }
        assert isValidBookshelf();
        return -1;   // dummy code to get stub to compile
    }
    /*
     * Gets the height of the book at the given position.
     *
     * PRE: 0 <= position < this.size()
     */
    public int getHeight(int position) {
        assert position < size();
        assert isValidBookshelf();
        return bookShelf.get(position);
    }

    /**
     * Returns number of books on the this Bookshelf.
     */
    public int size() {
        assert isValidBookshelf();
        return bookShelf.size();
    }

    /**
     * Returns string representation of this Bookshelf. Returns a string with the height of all
     * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
     * by example here:  “[7, 33, 5, 4, 3]”
     */
    public String toString() {
        String strBookshelf = String.valueOf(bookShelf);
        assert isValidBookshelf();
        return strBookshelf;
    }
    /**
     * Returns true iff the books on this Bookshelf are in non-decreasing order.
     * (Note: this is an accessor; it does not change the bookshelf.)
     */
    public boolean isSorted() {
        for (int i = 0; i < bookShelf.size() - 1; i++) {
            if(bookShelf.get(i) > bookShelf.get(i + 1)) {
                return false;
            }
        }
        assert isValidBookshelf();
        return true;
    }

    /**
     * Returns true iff the Bookshelf data is in a valid state.
     * (See representation invariant comment for more details.)
     */
    private boolean isValidBookshelf() {
        for (int i = 0; i < bookShelf.size(); i++) {
            if (bookShelf.get(i) <= 0) {
                return false;
            }
        }
        return true;  // dummy code to get stub to compile
    }


}
