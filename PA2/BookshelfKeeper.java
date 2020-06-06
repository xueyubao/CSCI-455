// Name: Jiahui Liu
// USC NetID: jliu4728@usc.edu
// CSCI455 PA2
// Spring 2020
// Version 1.1

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;

/**
 * Class BookshelfKeeper
 *
 * Enables users to perform efficient put or pick operation on a bookshelf of books kept in
 * non-decreasing order by height, with the restriction that single books can only be added
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 *
 * Uses a Bookshelf class to model this restricted access.
 */
public class BookshelfKeeper {

    /**
     Representation invariant:


     <put rep. invar. comment here>

     */
    // currOperation is the current step for one pick or put
    private int currOperations = 0;
    // totalOperation is the total steps since books have been initialized.
    private int totalOperations = 0;
    private Bookshelf books;

    // <add instance variables here>


    /**
     * Creates a BookShelfKeeper object with an empty bookshelf
     */
    public BookshelfKeeper() {
        BookshelfKeeper shelfKeeper = new BookshelfKeeper();
        currOperations = 0;
        totalOperations = 0;
    }

    /**
     * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
     * Note: method does not make a defensive copy of the bookshelf.
     *
     * PRE: sortedBookshelf.isSorted() is true.
     */
    public BookshelfKeeper(Bookshelf sortedBookshelf) {
        if (sortedBookshelf.isSorted()) {
            this.books = sortedBookshelf;
        }
    }

    /**
     * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted
     * after picking up the book.
     *
     * Returns the number of calls to mutators on the contained bookshelf used to complete this
     * operation. This must be the minimum number to complete the operation.
     *
     * PRE: position must be in the range [0, getNumBooks()).
     */
    // in this method, I use an temp ArrayList to store the books that I need to firstly remove. Then I will put
    // them again in the shelf.
    public int pickBook(int position) {
        currOperations = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        // check boundary case
        if (position < 0 || position > getNumBooks() - 1) {
            return -1;
        } else if (position < getNumBooks() / 2) {
            // compare the position I want to pick with the size of books. And then decide to do actions from
            // front or behind.
            for (int i = 0; i < position; i++) {
                temp.add(books.removeFront());
                currOperations++;
            }
            books.removeFront();
            currOperations++;
            for (int i = temp.size() - 1; i >= 0; i--) {
                books.addFront(temp.get(i));
                currOperations++;
            }
        } else if (position >= getNumBooks() / 2) {
            int fixLength = getNumBooks();
            for (int i = position + 1 ; i < fixLength; i++) {
                temp.add(books.removeLast());
                currOperations++;
            }
            books.removeLast();
            currOperations++;
            for (int i = temp.size() - 1; i >= 0; i--) {
                books.addLast(temp.get(i));
                currOperations++;
            }
        }
        totalOperations += currOperations;
        return currOperations;
    }

    /**
     * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted
     * after the insertion.
     *
     * Returns the number of calls to mutators on the contained bookshelf used to complete this
     * operation. This must be the minimum number to complete the operation.
     *
     * PRE: height > 0
     *
     */
    // in this method, I use an temp ArrayList to store the books that I need to firstly remove. Then I will put
    // them again in the shelf.
    public int putBook(int height) {
        ArrayList<Integer> temp = new ArrayList<>();
        currOperations = 0;
        // this is boundary case, if there is no books in the shelf.
        if (books.size() == 0) {
            books.addFront(height);
            totalOperations++;
            currOperations++;
            return 1;
        }
        // compare my height that I will input with the height of the book since books' heights are sorted.
        // Then I choose whether insert from the front or behind.
        else if (height < books.getHeight(books.size() / 2)) {    // put from the front
            for (int i = 0; i < books.size() / 2; i++) {
                while (height > books.getHeight(i)) {
                    temp.add(books.removeFront());
                    currOperations++;
                }
            }
            books.addFront(height);
            currOperations++;
            for (int i = temp.size() - 1; i >= 0; i--) {
                books.addFront(temp.get(i));
                currOperations++;
            }
        }else if (height >= books.getHeight(books.size() / 2)) {
            int fixLength = getNumBooks();
            for (int i = books.size() - 1; i > fixLength / 2; i--) {
                if (height < books.getHeight(i)) {
                    temp.add(books.removeLast());
                    currOperations++;
                }
            }
            books.addLast(height);
            currOperations++;
            for (int i = temp.size() - 1; i >= 0; i--) {
                books.addLast(temp.get(i));
                currOperations++;
            }
        }
        totalOperations += currOperations;
        return currOperations; // dummy code to get stub to compile
    }

    /**
     * Returns the total number of calls made to mutators on the contained bookshelf
     * so far, i.e., all the ones done to perform all of the pick and put operations
     * that have been requested up to now.
     */
    public int getTotalOperations() {
        return totalOperations;   // dummy code to get stub to compile
    }

    /**
     * Returns the number of books on the contained bookshelf.
     */
    public int getNumBooks() {
        return books.size();   // dummy code to get stub to compile
    }

    /**
     * Returns string representation of this BookshelfKeeper. Returns a String containing height
     * of all books present in the bookshelf in the order they are on the bookshelf, followed
     * by the number of bookshelf mutator calls made to perform the last pick or put operation,
     * followed by the total number of such calls made since we created this BookshelfKeeper.
     *
     * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
     *
     */
    public String toString() {
        if (books.isSorted()) {
            String strBookOfKeeper = String.valueOf(books);
            return strBookOfKeeper + " " + String.valueOf(currOperations) + " " + String.valueOf(totalOperations);
        } else {
            return "Error: Heights must be specified in non-decreasing order";
        }
    }

    /**
     * Returns true iff the BookshelfKeeper data is in a valid state.
     * (See representation invariant comment for details.)
     */
    private boolean isValidBookshelfKeeper() {
        if (!books.isSorted()) {
            return false;
        }
        return true;  // dummy code to get stub to compile
    }

    // add any other private methods here

}
