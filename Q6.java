
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class book1 {
    private String title;
    private String author;
    private String isbn;

    public book1(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn;
    }
}

class ReferenceBook extends book1 {
    private String category;

    public ReferenceBook(String title, String author, String isbn, String category) {
        super(title, author, isbn);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    
    public String toString() {
        return super.toString() + "\nCategory: " + category;
    }
}

class Library1 {
    private List<book1> books = new ArrayList<>();

    public void addbook1(book1 book) {
        books.add(book);
        System.out.println("Book added to the library:\n" + book);
    }

    public void removeBook(String isbn) {
        boolean removed = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                removed = true;
                System.out.println("Book with ISBN " + isbn + " removed from the library.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Book with ISBN " + isbn + " not found in the library.");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Library Books:");
            for (book1 book : books) {
                System.out.println(book);
                System.out.println("-----------------------");
            }
        }
    }
}

public class Q6 {
    public static void main(String[] args) {
        Library1 library = new Library1();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Is it a reference book? (yes/no): ");
                    String isReference = sc.nextLine().toLowerCase();
                    if ("yes".equals(isReference)) {
                        System.out.print("Enter book category: ");
                        String category = sc.nextLine();
                        ReferenceBook referenceBook = new ReferenceBook(title, author, isbn, category);
                        library.addbook1(referenceBook);
                    } else {
                        book1 book = new book1(title, author, isbn);
                        library.addbook1(book);
                    }
                    break;
                case 2:
                    System.out.print("Enter book ISBN to remove: ");
                    String isbnToRemove = sc.nextLine();
                    library.removeBook(isbnToRemove);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}