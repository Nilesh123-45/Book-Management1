import java.util.Scanner;

public class DigitalLibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;
        do {
            System.out.println("\n    Digital Library System    ");
            System.out.println("1. Add a Book: ");
            System.out.println("2. View All Books: ");
            System.out.println("3. Search Book by ID or Title: ");
            System.out.println("4. Update Book Details: ");
            System.out.println("5. Delete a Book Record: ");
            System.out.println("6. Exit System: ");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        library.addBook(scanner);
                        break;
                    case 2:
                        library.viewAllBooks();
                        break;
                    case 3:
                        library.searchBook(scanner);
                        break;
                    case 4:
                        library.updateBookDetails(scanner);
                        break;
                    case 5:
                        library.deleteBook(scanner);
                        break;
                    case 6:
                        System.out.println("Exiting the system. Have a nice day!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again later.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                choice = -1; // To continue the loop
            }
        } while (choice != 6);

        scanner.close();
    }
}