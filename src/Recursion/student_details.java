
package Recursion;

import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        next = null;
    }
}


public class student_details {

    static Student head = null;


    static void insertBeginning(int r, String n, int a, String g) {
        Student newNode = new Student(r, n, a, g);
        newNode.next = head;
        head = newNode;
    }


    static void insertEnd(int r, String n, int a, String g) {
        Student newNode = new Student(r, n, a, g);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }


    static void insertPosition(int r, String n, int a, String g, int pos) {
        if (pos == 1) {
            insertBeginning(r, n, a, g);
            return;
        }

        Student temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        Student newNode = new Student(r, n, a, g);
        newNode.next = temp.next;
        temp.next = newNode;
    }


    static void delete(int roll) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.roll == roll) {
            head = head.next;
            System.out.println("Student Deleted");
            return;
        }

        Student temp = head;

        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student Not Found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student Deleted");
        }
    }


    static void search(int roll) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Roll: " + temp.roll);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student Not Found");
    }


    static void display() {
        Student temp = head;

        if (temp == null) {
            System.out.println("List is Empty");
            return;
        }

        while (temp != null) {
            System.out.println(
                    "Roll: " + temp.roll +
                            " Name: " + temp.name +
                            " Age: " + temp.age +
                            " Grade: " + temp.grade
            );

            temp = temp.next;
        }
    }


    static void updateGrade(int roll, String grade) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = grade;
                System.out.println("Grade Updated");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student Not Found");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert Beginning");
            System.out.println("2. Insert End");
            System.out.println("3. Insert Position");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Update Grade");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            int r, a, pos;
            String n, g;

            switch (ch) {

                case 1:
                case 2:
                case 3:

                    System.out.print("Enter Roll Number: ");
                    r = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    n = sc.nextLine();

                    System.out.print("Enter Age: ");
                    a = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Grade: ");
                    g = sc.nextLine();

                    if (ch == 1) {
                        insertBeginning(r, n, a, g);
                    }
                    else if (ch == 2) {
                        insertEnd(r, n, a, g);
                    }
                    else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();
                        insertPosition(r, n, a, g, pos);
                    }

                    break;

                case 4:

                    System.out.print("Enter Roll Number: ");
                    r = sc.nextInt();

                    delete(r);
                    break;

                case 5:

                    System.out.print("Enter Roll Number: ");
                    r = sc.nextInt();

                    search(r);
                    break;

                case 6:

                    display();
                    break;

                case 7:

                    System.out.print("Enter Roll Number: ");
                    r = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Grade: ");
                    g = sc.nextLine();

                    updateGrade(r, g);
                    break;

                case 8:

                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
