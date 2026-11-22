
package Recursion;

import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;

    Book next;
    Book prev;

    Book(String title, String author, String genre,
         int bookId, boolean available) {

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;

        next = null;
        prev = null;
    }
}

public class Library_Management {

    static Book head = null;
    static Book tail = null;


    static void insertBeginning(String t, String a, String g,
                                int id, boolean av) {

        Book newNode = new Book(t, a, g, id, av);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }


    static void insertEnd(String t, String a, String g,
                          int id, boolean av) {

        Book newNode = new Book(t, a, g, id, av);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }


    static void insertPosition(String t, String a, String g,
                               int id, boolean av, int pos) {

        if (pos == 1) {
            insertBeginning(t, a, g, id, av);
            return;
        }

        Book temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        if (temp == tail) {
            insertEnd(t, a, g, id, av);
            return;
        }

        Book newNode = new Book(t, a, g, id, av);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }


    static void delete(int id) {

        Book temp = head;

        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book Not Found");
            return;
        }

        if (temp == head) {
            head = temp.next;
        } else {
            temp.prev.next = temp.next;
        }

        if (temp == tail) {
            tail = temp.prev;
        } else {
            temp.next.prev = temp.prev;
        }

        System.out.println("Book Deleted");
    }


    static void searchTitle(String title) {

        Book temp = head;
        boolean found = false;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(title)) {

                System.out.println("Title: " + temp.title);
                System.out.println("Author: " + temp.author);
                System.out.println("Genre: " + temp.genre);
                System.out.println("Book ID: " + temp.bookId);
                System.out.println("Available: " + temp.available);

                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book Not Found");
        }
    }


    static void searchAuthor(String author) {

        Book temp = head;
        boolean found = false;

        while (temp != null) {

            if (temp.author.equalsIgnoreCase(author)) {

                System.out.println(
                        temp.title + " " +
                                temp.author + " " +
                                temp.genre + " " +
                                temp.bookId + " " +
                                temp.available
                );

                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book Not Found");
        }
    }


    static void updateAvailability(int id, boolean status) {

        Book temp = head;

        while (temp != null) {

            if (temp.bookId == id) {
                temp.available = status;
                System.out.println("Availability Updated");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Book Not Found");
    }


    static void displayForward() {

        Book temp = head;

        if (temp == null) {
            System.out.println("Library is Empty");
            return;
        }

        while (temp != null) {

            System.out.println(
                    "Title: " + temp.title +
                            " Author: " + temp.author +
                            " Genre: " + temp.genre +
                            " ID: " + temp.bookId +
                            " Available: " + temp.available
            );

            temp = temp.next;
        }
    }


    static void displayReverse() {

        Book temp = tail;

        if (temp == null) {
            System.out.println("Library is Empty");
            return;
        }

        while (temp != null) {

            System.out.println(
                    "Title: " + temp.title +
                            " Author: " + temp.author +
                            " Genre: " + temp.genre +
                            " ID: " + temp.bookId +
                            " Available: " + temp.available
            );

            temp = temp.prev;
        }
    }


    static void countBooks() {

        int count = 0;
        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total Books: " + count);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert Beginning");
            System.out.println("2. Insert End");
            System.out.println("3. Insert Position");
            System.out.println("4. Delete Book");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Count Books");
            System.out.println("11. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            String t, a, g;
            int id, pos;
            boolean av;

            switch (ch) {

                case 1:
                case 2:
                case 3:

                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    t = sc.nextLine();

                    System.out.print("Enter Author: ");
                    a = sc.nextLine();

                    System.out.print("Enter Genre: ");
                    g = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    System.out.print("Available? (true/false): ");
                    av = sc.nextBoolean();

                    if (ch == 1) {
                        insertBeginning(t, a, g, id, av);
                    }
                    else if (ch == 2) {
                        insertEnd(t, a, g, id, av);
                    }
                    else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();

                        insertPosition(t, a, g, id, av, pos);
                    }

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    delete(id);
                    break;

                case 5:

                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    t = sc.nextLine();

                    searchTitle(t);
                    break;

                case 6:

                    sc.nextLine();

                    System.out.print("Enter Author: ");
                    a = sc.nextLine();

                    searchAuthor(a);
                    break;

                case 7:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter Availability (true/false): ");
                    av = sc.nextBoolean();

                    updateAvailability(id, av);
                    break;

                case 8:
                    displayForward();
                    break;

                case 9:
                    displayReverse();
                    break;

                case 10:
                    countBooks();
                    break;

                case 11:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
