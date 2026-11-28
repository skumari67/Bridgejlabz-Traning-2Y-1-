
package Recursion;

import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;

    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        next = null;
        prev = null;
    }
}

public class Double_linked_LIst {

    static Movie head = null;
    static Movie tail = null;


    static void insertBeginning(String t, String d, int y, double r) {
        Movie newNode = new Movie(t, d, y, r);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }


    static void insertEnd(String t, String d, int y, double r) {
        Movie newNode = new Movie(t, d, y, r);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }


    static void insertPosition(String t, String d, int y, double r, int pos) {
        if (pos == 1) {
            insertBeginning(t, d, y, r);
            return;
        }

        Movie temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        if (temp == tail) {
            insertEnd(t, d, y, r);
            return;
        }

        Movie newNode = new Movie(t, d, y, r);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }


    static void delete(String title) {
        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie Not Found");
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

        System.out.println("Movie Deleted");
    }


    static void searchDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " " +
                        temp.director + " " +
                        temp.year + " " + temp.rating);
                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Movie Not Found");
        }
    }


    static void searchRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " " +
                        temp.director + " " +
                        temp.year + " " + temp.rating);
                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Movie Not Found");
        }
    }


    static void displayForward() {
        Movie temp = head;

        if (temp == null) {
            System.out.println("List is Empty");
            return;
        }

        while (temp != null) {
            System.out.println(
                    temp.title + " " +
                            temp.director + " " +
                            temp.year + " " +
                            temp.rating
            );

            temp = temp.next;
        }
    }


    static void displayReverse() {
        Movie temp = tail;

        if (temp == null) {
            System.out.println("List is Empty");
            return;
        }

        while (temp != null) {
            System.out.println(
                    temp.title + " " +
                            temp.director + " " +
                            temp.year + " " +
                            temp.rating
            );

            temp = temp.prev;
        }
    }


    static void updateRating(String title, double rating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = rating;
                System.out.println("Rating Updated");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie Not Found");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert Beginning");
            System.out.println("2. Insert End");
            System.out.println("3. Insert Position");
            System.out.println("4. Delete Movie");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Update Rating");
            System.out.println("10. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            String t, d;
            int y, pos;
            double r;

            switch (ch) {

                case 1:
                case 2:
                case 3:

                    sc.nextLine();

                    System.out.print("Enter Movie Title: ");
                    t = sc.nextLine();

                    System.out.print("Enter Director: ");
                    d = sc.nextLine();

                    System.out.print("Enter Release Year: ");
                    y = sc.nextInt();

                    System.out.print("Enter Rating: ");
                    r = sc.nextDouble();

                    if (ch == 1) {
                        insertBeginning(t, d, y, r);
                    } else if (ch == 2) {
                        insertEnd(t, d, y, r);
                    } else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();
                        insertPosition(t, d, y, r, pos);
                    }
                    break;

                case 4:

                    sc.nextLine();
                    System.out.print("Enter Movie Title: ");
                    t = sc.nextLine();

                    delete(t);
                    break;

                case 5:

                    sc.nextLine();
                    System.out.print("Enter Director: ");
                    d = sc.nextLine();

                    searchDirector(d);
                    break;

                case 6:

                    System.out.print("Enter Rating: ");
                    r = sc.nextDouble();

                    searchRating(r);
                    break;

                case 7:
                    displayForward();
                    break;

                case 8:
                    displayReverse();
                    break;

                case 9:

                    sc.nextLine();
                    System.out.print("Enter Movie Title: ");
                    t = sc.nextLine();

                    System.out.print("Enter New Rating: ");
                    r = sc.nextDouble();

                    updateRating(t, r);
                    break;

                case 10:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
