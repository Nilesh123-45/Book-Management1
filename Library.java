import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Scanner scanner) {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine().trim();
        if (books.containsKey(bookId)) {
            System.out.println("Error: Book with ID '" + bookId + "' already exists.");
            return;
        }
        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Error: Title cannot be empty.");
            return;
        }
        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("Error: Author cannot be empty.");
            return;
        }
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine().trim();
        System.out.print("Enter Availability Status (Available/Checked Out): ");
        String availabilityStatus = scanner.nextLine().trim();

        Book newBook = new Book(bookId, title, author, genre, availabilityStatus);
        if (newBook.getAvailabilityStatus() != null) { // Check if availability status was valid
            books.put(bookId, newBook);
            System.out.println("Book added successfully...");
        }
    }

    public void viewAllBooks() {
        System.out.println("\n    All Books    ");
        if (books.isEmpty()) {
            System.out.println("No books present in the given details in library.We're Sorry!");
            return;
        }
        for (Book book : books.values()) {
            book.displayDetails();
        }
    }

    public void searchBook(Scanner scanner) {
        System.out.println("\n    Search Book    ");
        System.out.print("Search by (ID/Title): ");
        String searchBy = scanner.nextLine().trim().toLowerCase();

        if (searchBy.equals("id")) {
            System.out.print("Enter unique Book ID: ");
            String bookId = scanner.nextLine().trim();
            if (books.containsKey(bookId)) {
                books.get(bookId).displayDetails();
            } else {
                System.out.println("Book with ID '" + bookId + "'is not found.");
            }
        } else if (searchBy.equals("title")) {
            System.out.print("Enter Book Title: ");
            String title = scanner.nextLine().trim();
            boolean found = false;
            for (Book book : books.values()) {
                if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    book.displayDetails();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books found with title containing '" + title + "'.");
            }
        } else {
            System.out.println("Invalid search option. Please enter 'ID' or 'Title'.");
        }
    }

    public void updateBookDetails(Scanner scanner) {
        System.out.println("\n--- Update Book Details ---");
        System.out.print("Enter Book ID to update the details: ");
        String bookIdToUpdate = scanner.nextLine().trim();

        if (books.containsKey(bookIdToUpdate)) {
            Book bookToUpdate = books.get(bookIdToUpdate);
            System.out.println("Current details of the book:");
            bookToUpdate.displayDetails();

            System.out.println("\n    Enter new details (leave blank to keep current)    ");

            System.out.print("New Title (" + bookToUpdate.getTitle() + "): ");
            String newTitle = scanner.nextLine().trim();
            if (!newTitle.isEmpty()) {
                bookToUpdate.setTitle(newTitle);
            }

            System.out.print("New Author (" + bookToUpdate.getAuthor() + "): ");
            String newAuthor = scanner.nextLine().trim();
            if (!newAuthor.isEmpty()) {
                bookToUpdate.setAuthor(newAuthor);
            }

            System.out.print("New Genre (" + bookToUpdate.getGenre() + "): ");
            String newGenre = scanner.nextLine().trim();
            if (!newGenre.isEmpty()) {
                bookToUpdate.setGenre(newGenre);
            }

            System.out.print("New Availability Status (" + bookToUpdate.getAvailabilityStatus() + ") (Available/Checked Out): ");
            String newAvailabilityStatus = scanner.nextLine().trim();
            if (!newAvailabilityStatus.isEmpty()) {
                bookToUpdate.setAvailabilityStatus(newAvailabilityStatus);
            }

            System.out.println("Book details updated successfully!");
            bookToUpdate.displayDetails();
        } else {
            System.out.println("Book with ID '" + bookIdToUpdate + "' not found.");
        }
    }

    public void deleteBook(Scanner scanner) {
        System.out.println("\n--- Delete Book ---");
        System.out.print("Enter Book ID to delete: ");
        String bookIdToDelete = scanner.nextLine().trim();

        if (books.containsKey(bookIdToDelete)) {
            books.remove(bookIdToDelete);
            System.out.println("Book with ID '" + bookIdToDelete + "' deleted successfully!");
        } else {
            System.out.println("Book with ID '" + bookIdToDelete + "' not found.");
        }
    }
}

