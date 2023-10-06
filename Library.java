
import java.util.*;

class Book{
	String title ;
	int no_copies;
	 
	public Book(String title,int initialCopies) {
		 this.title=title;
		 this.no_copies=initialCopies;
	 }
	
    public String getTitle() {
	        return title;
	    }

	    public int getNo_copies() {
	        return no_copies;
	    }

	    public void loan() {
	    	no_copies--;
	    }

	    public void returnBook() {
	    	no_copies++;
	    }
		
		
}
class BookUnavailableException extends Exception {
    public BookUnavailableException(String message) {
        super(message);
    }
}
class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}
class Lib{
    private Map<String, Book> books = new HashMap<>();

    public void addBook(String title, int initialCopies) {
    	 books.put(title, new Book(title, initialCopies));
    }

    public void loanBook(String title) throws BookUnavailableException, BookNotFoundException {
    	 Book bl = books.get(title);
        if (!books.containsKey(title)) {
            throw new BookNotFoundException("Book not found in the library: " + title);
        }

        if (bl.getNo_copies() <= 0) {
            throw new BookUnavailableException("No available copies of the book: " + title);
        }
        bl.loan();
    }

    public void returnBook(String title) throws BookNotFoundException {
    	Book b2= books.get(title);
        if (!books.containsKey(title)) {
            throw new BookNotFoundException("Book not found in the library: " + title);
        }
      b2.returnBook();
    }
}
public class Library {
	public static void main(String[] args) {
        Lib lib = new Lib();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("MENU:");
                System.out.println("1. Add Book");
                System.out.println("2. Loan Book");
                System.out.println("3. Return Book");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter initial number of copies: ");
                        int initialCopies = sc.nextInt();
                        sc.nextLine(); // Consume newline

                        lib.addBook(title,initialCopies);
                        System.out.println("Book added to the library.");
                        break;
                    case 2:
                        System.out.print("Enter book title to loan: ");
                        title = sc.nextLine();
                        lib.loanBook(title);
                        System.out.println("Book loaned successfully.");
                        break;
                    case 3:
                        System.out.print("Enter book title to return: ");
                        title = sc.nextLine();
                        lib.returnBook(title);
                        System.out.println("Book returned successfully.");
                        break;
                    case 4:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (BookUnavailableException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (BookNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

	

}

