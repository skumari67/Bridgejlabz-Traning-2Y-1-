
package Recursion;

import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        next = null;
    }
}

public class Circular_linked_list {

    static Task head = null;
    static Task current = null;


    static void insertBeginning(int id, String name, int priority, String date) {
        Task newNode = new Task(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        Task temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }


    static void insertEnd(int id, String name, int priority, String date) {
        Task newNode = new Task(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        Task temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }


    static void insertPosition(int id, String name, int priority, String date, int pos) {

        if (pos == 1) {
            insertBeginning(id, name, priority, date);
            return;
        }

        if (head == null || pos < 1) {
            System.out.println("Invalid Position");
            return;
        }

        Task temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        if (temp.next == head && pos > 1) {
            if (pos == 2 && head.next == head) {
                insertEnd(id, name, priority, date);
            } else {
                int count = 1;
                Task t = head;

                while (t.next != head) {
                    count++;
                    t = t.next;
                }

                if (pos == count + 1) {
                    insertEnd(id, name, priority, date);
                } else {
                    System.out.println("Invalid Position");
                }
            }
            return;
        }

        Task newNode = new Task(id, name, priority, date);
        newNode.next = temp.next;
        temp.next = newNode;
    }


    static void delete(int id) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Task temp = head;
        Task prev = null;

        do {
            if (temp.taskId == id) {
                break;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        if (temp.taskId != id) {
            System.out.println("Task Not Found");
            return;
        }

        if (temp == head && temp.next == head) {
            head = null;
            current = null;
            System.out.println("Task Deleted");
            return;
        }

        if (temp == head) {
            Task last = head;

            while (last.next != head) {
                last = last.next;
            }

            head = head.next;
            last.next = head;
        } else {
            prev.next = temp.next;
        }

        if (current == temp) {
            current = temp.next;
        }

        System.out.println("Task Deleted");
    }


    static void nextTask() {

        if (current == null) {
            System.out.println("No Tasks Available");
            return;
        }

        System.out.println("Current Task:");
        System.out.println("ID: " + current.taskId);
        System.out.println("Name: " + current.taskName);
        System.out.println("Priority: " + current.priority);
        System.out.println("Due Date: " + current.dueDate);

        current = current.next;
    }


    static void display() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Task temp = head;

        do {
            System.out.println(
                    "ID: " + temp.taskId +
                            " Name: " + temp.taskName +
                            " Priority: " + temp.priority +
                            " Due Date: " + temp.dueDate
            );

            temp = temp.next;

        } while (temp != head);
    }

    static void searchPriority(int priority) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println(
                        temp.taskId + " " +
                                temp.taskName + " " +
                                temp.priority + " " +
                                temp.dueDate
                );

                found = true;
            }

            temp = temp.next;

        } while (temp != head);

        if (!found) {
            System.out.println("Task Not Found");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert Beginning");
            System.out.println("2. Insert End");
            System.out.println("3. Insert Position");
            System.out.println("4. Delete Task");
            System.out.println("5. View Current Task");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            int id, priority, pos;
            String name, date;

            switch (ch) {

                case 1:
                case 2:
                case 3:

                    System.out.print("Enter Task ID: ");
                    id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Task Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Due Date: ");
                    date = sc.nextLine();

                    if (ch == 1) {
                        insertBeginning(id, name, priority, date);
                    } else if (ch == 2) {
                        insertEnd(id, name, priority, date);
                    } else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();

                        insertPosition(id, name, priority, date, pos);
                    }
                    break;

                case 4:

                    System.out.print("Enter Task ID: ");
                    id = sc.nextInt();

                    delete(id);
                    break;

                case 5:
                    nextTask();
                    break;

                case 6:
                    display();
                    break;

                case 7:

                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();

                    searchPriority(priority);
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
