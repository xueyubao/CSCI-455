// Name: Jiahui Liu
// USC NetID: jliu4728@usc.edu
// CSCI455 PA2
// Spring 2020
// Version 1.1
import java.util.ArrayList;
import java.util.Scanner;
public class BookshelfKeeperProg {
    private static final int EXIT_NUM = 0;
    private static final int CONTINUE_NUM = 1;
    public static void main(String[] args) {
        //initialization of bookshelf, books, shelfKeeper
        Bookshelf bookShelf = new Bookshelf();
        ArrayList<Integer> books = new ArrayList<>();
        bookShelf.setBookShelf(books);
        BookshelfKeeper shelfKeeper = new BookshelfKeeper(bookShelf);
        Scanner input = new Scanner(System.in);
        int initialNum = initial(input, bookShelf, books, shelfKeeper);
        if (initialNum == EXIT_NUM) {
            return;
        }
        int pickOrPutNum = pickOrPut(input, bookShelf, shelfKeeper);
        if (pickOrPutNum == EXIT_NUM) {
            return;
        }
    }
    // This is a private method and pass several parameters into this method. This method aims to initialize the
    // start books for a shelf.
    private static int initial(Scanner input, Bookshelf bookShelf, ArrayList<Integer> books, BookshelfKeeper shelfKeeper) {
        System.out.println("Please enter initial arrangement of books followed by newline:");
        String line = input.nextLine().trim();
        Scanner lineScanner = new Scanner(line);
        // this is a while loop to initialize my start shelf. If you have int for the height of books, then you will
        // put it in that shelf.
        while (lineScanner.hasNextInt()) {
            // heightOfBooks means the height of books
            int heightOfBook = lineScanner.nextInt();
            // check for whether the height is larger than 0
            if (heightOfBook <= 0) {
                System.out.println("ERROR: Height of a book must be positive.");
                System.out.println("Exiting Program.");
                return EXIT_NUM;
            }
            books.add(heightOfBook);
        }
        // check whether the books in the shelf are sorted.
        if (!bookShelf.isSorted()) {
            System.out.println("ERROR: Heights must be specified in non-decreasing order.");
            System.out.println("Exiting Program.");
            return EXIT_NUM;
        }
        System.out.println(shelfKeeper.toString());
        return CONTINUE_NUM;
    }

    // this method mainly contains different operations such as pick a book, put a book, exit the program and
    // other operation.
    private static int pickOrPut(Scanner input, Bookshelf bookShelf, BookshelfKeeper shelfKeeper) {
        // I use a local variable to control the while loop. If currStep == true, we can continuously do different actions for the
        // program. However, if we type "end" we set currStep == false, and we jump out the while loop.
        boolean currStep = true;
        System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
        while (currStep) {
            String operation = input.nextLine().trim();
            Scanner in = new Scanner(operation);
            String lineScanner = in.next();
            if (lineScanner.equals("end")){
                System.out.println("Exiting Program.");
                currStep = false;
            } else if (lineScanner.equals("put")) {
                int heightOfBook = in.nextInt();
                if (heightOfBook <= 0) {
                    System.out.println("ERROR: Height of a book must be positive.");
                    System.out.println("Exiting Program.");
                    return EXIT_NUM;
                }
                shelfKeeper.putBook(heightOfBook);
                System.out.println(shelfKeeper.toString());
            } else if (lineScanner.equals("pick")) {
                int positionOfBook = in.nextInt();
                if (positionOfBook  > bookShelf.size() - 1){
                    System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
                    System.out.println("Exiting Program.");
                    return EXIT_NUM;
                }
                shelfKeeper.pickBook(positionOfBook );
                System.out.println(shelfKeeper.toString());
            }else {
                System.out.println("ERROR: Operation should be either pick or put.");
                System.out.println("Exiting Program.");
                return EXIT_NUM;
            }
        }
        return CONTINUE_NUM;
    }

}
