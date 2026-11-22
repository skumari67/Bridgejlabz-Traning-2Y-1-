
package Recursion;

import java.util.Scanner;

class State {
    String text;
    State prev, next;

    State(String text) {
        this.text = text;
    }
}

public class Undo_Redo {

    static State head = null;
    static State current = null;
    static int size = 0;
    static final int LIMIT = 10;

    static void addState(String text) {
        State newNode = new State(text);

        if (head == null) {
            head = current = newNode;
            size = 1;
            return;
        }


        State temp = current.next;
        while (temp != null) {
            size--;
            temp = temp.next;
        }
        current.next = null;


        newNode.prev = current;
        current.next = newNode;
        current = newNode;
        size++;


        while (size > LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    static void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo!");
            return;
        }

        current = current.prev;
        System.out.println("Undo successful!");
    }

    static void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo!");
            return;
        }

        current = current.next;
        System.out.println("Redo successful!");
    }

    static void display() {
        if (current == null) {
            System.out.println("Text is empty!");
        } else {
            System.out.println("Current Text: " + current.text);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    addState(text);
                    break;

                case 2:
                    undo();
                    break;

                case 3:
                    redo();
                    break;

                case 4:
                    display();
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
