import java.util.HashMap;
import java.util.Scanner;

public class LibrarySystem {

    static class Book {
        String title;
        String author;
        int quantity;

        Book(String title, String author, int quantity) {
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }
    }

    private static final HashMap<String, Book> library = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    borrowBooks(scanner);
                    break;
                case 3:
                    returnBooks(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        if (library.containsKey(title)) {
            Book existingBook = library.get(title);
            existingBook.quantity += quantity;
            System.out.println("Updated the quantity of \"" + title + "\" to " + existingBook.quantity + ".");
        } else {
            library.put(title, new Book(title, author, quantity));
            System.out.println("Added \"" + title + "\" by " + author + " to the library.");
        }
    }

    private static void borrowBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to borrow: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        if (library.containsKey(title)) {
            Book book = library.get(title);
            if (book.quantity >= quantity) {
                book.quantity -= quantity;
                System.out.println("You have successfully borrowed " + quantity + " copies of \"" + title + "\".");
            } else {
                System.out.println("Error: Only " + book.quantity + " copies of \"" + title + "\" are available.");
            }
        } else {
            System.out.println("Error: \"" + title + "\" is not available in the library.");
        }
    }

    private static void returnBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to return: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        if (library.containsKey(title)) {
            Book book = library.get(title);
            book.quantity += quantity;
            System.out.println("You have successfully returned " + quantity + " copies of \"" + title + "\".");
        } else {
            System.out.println("Error: \"" + title + "\" does not belong to this library.");
        }
    }
}
