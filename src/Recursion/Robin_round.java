
package Recursion;

import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;

    Process next;

    Process(int id, int burst, int priority) {
        this.processId = id;
        this.burstTime = burst;
        this.priority = priority;
        this.remainingTime = burst;
        next = null;
    }
}

public class Robin_round {

    static Process head = null;


    static void insertEnd(int id, int burst, int priority) {

        Process newNode = new Process(id, burst, priority);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Process temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }


    static void delete(int id) {

        if (head == null) {
            return;
        }

        Process temp = head;
        Process prev = null;

        do {
            if (temp.processId == id) {
                break;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        if (temp.processId != id) {
            return;
        }

        if (temp == head && temp.next == head) {
            head = null;
            return;
        }

        if (temp == head) {
            Process last = head;

            while (last.next != head) {
                last = last.next;
            }

            head = head.next;
            last.next = head;

        } else {
            prev.next = temp.next;
        }
    }


    static void display() {

        if (head == null) {
            System.out.println("No Processes");
            return;
        }

        Process temp = head;

        do {
            System.out.println(
                    "PID: " + temp.processId +
                            " Burst Time: " + temp.remainingTime +
                            " Priority: " + temp.priority
            );

            temp = temp.next;

        } while (temp != head);
    }


    static void roundRobin(int quantum) {

        if (head == null) {
            System.out.println("No Processes Available");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completed = 0;

        int n = 0;
        Process temp = head;

        do {
            n++;
            temp = temp.next;
        } while (temp != head);

        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] burst = new int[n];
        int[] ids = new int[n];

        temp = head;

        for (int i = 0; i < n; i++) {
            burst[i] = temp.burstTime;
            ids[i] = temp.processId;
            temp = temp.next;
        }

        int[] remaining = burst.clone();
        int currentTime = 0;

        while (completed < n) {

            temp = head;

            do {
                if (temp.remainingTime > 0) {

                    int execute = Math.min(quantum, temp.remainingTime);

                    temp.remainingTime -= execute;
                    currentTime += execute;

                    System.out.println(
                            "Process " + temp.processId +
                                    " executed for " + execute + " units"
                    );

                    if (temp.remainingTime == 0) {

                        int index = -1;

                        for (int i = 0; i < n; i++) {
                            if (ids[i] == temp.processId) {
                                index = i;
                                break;
                            }
                        }

                        if (index != -1) {
                            turnaroundTime[index] = currentTime;
                            waitingTime[index] =
                                    turnaroundTime[index] - burst[index];
                        }

                        completed++;

                        System.out.println(
                                "Process " + temp.processId + " Completed"
                        );
                    }
                }

                temp = temp.next;

            } while (temp != head);

            System.out.println("\nRemaining Processes:");
            display();
        }

        for (int i = 0; i < n; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        System.out.println("\nProcess Details:");

        for (int i = 0; i < n; i++) {
            System.out.println(
                    "PID: " + ids[i] +
                            " Waiting Time: " + waitingTime[i] +
                            " Turnaround Time: " + turnaroundTime[i]
            );
        }

        System.out.println(
                "Average Waiting Time: " + (double) totalWaitingTime / n
        );

        System.out.println(
                "Average Turnaround Time: " + (double) totalTurnaroundTime / n
        );

        head = null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Process");
            System.out.println("2. Delete Process");
            System.out.println("3. Display Processes");
            System.out.println("4. Round Robin Scheduling");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            int id, burst, priority, quantum;

            switch (ch) {

                case 1:

                    System.out.print("Enter Process ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter Burst Time: ");
                    burst = sc.nextInt();

                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();

                    if (burst <= 0) {
                        System.out.println("Burst Time must be positive");
                        break;
                    }

                    insertEnd(id, burst, priority);
                    break;

                case 2:

                    System.out.print("Enter Process ID: ");
                    id = sc.nextInt();

                    delete(id);
                    break;

                case 3:

                    display();
                    break;

                case 4:

                    System.out.print("Enter Time Quantum: ");
                    quantum = sc.nextInt();

                    if (quantum <= 0) {
                        System.out.println("Invalid Quantum");
                        break;
                    }

                    roundRobin(quantum);
                    break;

                case 5:

                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
