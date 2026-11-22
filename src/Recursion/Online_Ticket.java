
package Recursion;

import java.util.Scanner;

class Ticket {
    int ticketId;
    String passengerName;
    String destination;
    Ticket next;

    Ticket(int ticketId, String passengerName, String destination) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.destination = destination;
        this.next = null;
    }
}

public class Online_Ticket {

    static Ticket head = null;
    static Ticket tail = null;

    static void bookTicket(int id, String name, String destination) {
        Ticket newNode = new Ticket(id, name, destination);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        System.out.println("Ticket booked successfully!");
    }

    static void cancelTicket(int id) {
        if (head == null) {
            System.out.println("No tickets available!");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;

        do {
            if (current.ticketId == id) {

                if (head == tail) {
                    head = tail = null;
                } else {
                    previous.next = current.next;

                    if (current == head) {
                        head = current.next;
                    }

                    if (current == tail) {
                        tail = previous;
                    }

                    tail.next = head;
                }

                System.out.println("Ticket cancelled successfully!");
                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        System.out.println("Ticket ID not found!");
    }

    static void searchTicket(int id) {
        if (head == null) {
            System.out.println("No tickets available!");
            return;
        }

        Ticket temp = head;

        do {
            if (temp.ticketId == id) {
                System.out.println("Ticket Found!");
                System.out.println("Passenger: " + temp.passengerName);
                System.out.println("Destination: " + temp.destination);
                return;
            }

            temp = temp.next;

        } while (temp != head);

        System.out.println("Ticket not found!");
    }

    static void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available!");
            return;
        }

        Ticket temp = head;

        System.out.println("\n--- All Booked Tickets ---");

        do {
            System.out.println("Ticket ID: " + temp.ticketId);
            System.out.println("Passenger: " + temp.passengerName);
            System.out.println("Destination: " + temp.destination);
            System.out.println("--------------------");

            temp = temp.next;

        } while (temp != head);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Search Ticket");
            System.out.println("4. Display All Tickets");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Passenger Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Destination: ");
                    String destination = sc.nextLine();

                    bookTicket(id, name, destination);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int cancelId = sc.nextInt();
                    cancelTicket(cancelId);
                    break;

                case 3:
                    System.out.print("Enter Ticket ID to search: ");
                    int searchId = sc.nextInt();
                    searchTicket(searchId);
                    break;

                case 4:
                    displayTickets();
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
