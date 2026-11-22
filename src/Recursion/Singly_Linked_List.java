
package Recursion;

import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        next = null;
    }
}

public class Singly_Linked_List {

    static Item head = null;


    static void insertBeginning(String n, int id, int q, double p) {
        Item newNode = new Item(n, id, q, p);
        newNode.next = head;
        head = newNode;
    }


    static void insertEnd(String n, int id, int q, double p) {
        Item newNode = new Item(n, id, q, p);

        if (head == null) {
            head = newNode;
            return;
        }

        Item temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }


    static void insertPosition(String n, int id, int q, double p, int pos) {

        if (pos == 1) {
            insertBeginning(n, id, q, p);
            return;
        }

        if (pos < 1) {
            System.out.println("Invalid Position");
            return;
        }

        Item temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        Item newNode = new Item(n, id, q, p);
        newNode.next = temp.next;
        temp.next = newNode;
    }


    static void delete(int id) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item Deleted");
            return;
        }

        Item temp = head;

        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item Not Found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item Deleted");
        }
    }


    static void updateQuantity(int id, int q) {

        Item temp = head;

        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = q;
                System.out.println("Quantity Updated");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Item Not Found");
    }


    static void searchID(int id) {

        Item temp = head;

        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Name: " + temp.name);
                System.out.println("ID: " + temp.id);
                System.out.println("Quantity: " + temp.quantity);
                System.out.println("Price: " + temp.price);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Item Not Found");
    }


    static void searchName(String name) {

        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(
                        temp.name + " " +
                                temp.id + " " +
                                temp.quantity + " " +
                                temp.price
                );

                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item Not Found");
        }
    }


    static void display() {

        Item temp = head;

        if (temp == null) {
            System.out.println("Inventory is Empty");
            return;
        }

        while (temp != null) {
            System.out.println(
                    "Name: " + temp.name +
                            " ID: " + temp.id +
                            " Quantity: " + temp.quantity +
                            " Price: " + temp.price
            );

            temp = temp.next;
        }
    }


    static void totalValue() {

        double total = 0;
        Item temp = head;

        while (temp != null) {
            total = total + (temp.price * temp.quantity);
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }


    static void sort(String type, String order) {

        if (head == null) {
            System.out.println("Inventory is Empty");
            return;
        }

        for (Item i = head; i.next != null; i = i.next) {

            for (Item j = i.next; j != null; j = j.next) {

                boolean swap = false;

                if (type.equalsIgnoreCase("name")) {

                    int result = i.name.compareToIgnoreCase(j.name);

                    if (order.equalsIgnoreCase("asc") && result > 0) {
                        swap = true;
                    }

                    if (order.equalsIgnoreCase("desc") && result < 0) {
                        swap = true;
                    }
                }

                else if (type.equalsIgnoreCase("price")) {

                    if (order.equalsIgnoreCase("asc") && i.price > j.price) {
                        swap = true;
                    }

                    if (order.equalsIgnoreCase("desc") && i.price < j.price) {
                        swap = true;
                    }
                }

                if (swap) {
                    String tempName = i.name;
                    int tempId = i.id;
                    int tempQuantity = i.quantity;
                    double tempPrice = i.price;

                    i.name = j.name;
                    i.id = j.id;
                    i.quantity = j.quantity;
                    i.price = j.price;

                    j.name = tempName;
                    j.id = tempId;
                    j.quantity = tempQuantity;
                    j.price = tempPrice;
                }
            }
        }

        System.out.println("Inventory Sorted");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert Beginning");
            System.out.println("2. Insert End");
            System.out.println("3. Insert Position");
            System.out.println("4. Delete Item");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Display Inventory");
            System.out.println("9. Total Inventory Value");
            System.out.println("10. Sort Inventory");
            System.out.println("11. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            String n;
            int id, q, pos;
            double p;

            switch (ch) {

                case 1:
                case 2:
                case 3:

                    sc.nextLine();

                    System.out.print("Enter Item Name: ");
                    n = sc.nextLine();

                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    q = sc.nextInt();

                    System.out.print("Enter Price: ");
                    p = sc.nextDouble();

                    if (ch == 1) {
                        insertBeginning(n, id, q, p);
                    } else if (ch == 2) {
                        insertEnd(n, id, q, p);
                    } else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();
                        insertPosition(n, id, q, p, pos);
                    }

                    break;

                case 4:

                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();

                    delete(id);
                    break;

                case 5:

                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    q = sc.nextInt();

                    updateQuantity(id, q);
                    break;

                case 6:

                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();

                    searchID(id);
                    break;

                case 7:

                    sc.nextLine();

                    System.out.print("Enter Item Name: ");
                    n = sc.nextLine();

                    searchName(n);
                    break;

                case 8:
                    display();
                    break;

                case 9:
                    totalValue();
                    break;

                case 10:

                    sc.nextLine();

                    System.out.println("Sort By: name / price");
                    String type = sc.nextLine();

                    System.out.println("Order: asc / desc");
                    String order = sc.nextLine();

                    if ((type.equalsIgnoreCase("name") ||
                            type.equalsIgnoreCase("price")) &&
                            (order.equalsIgnoreCase("asc") ||
                                    order.equalsIgnoreCase("desc"))) {

                        sort(type, order);
                    } else {
                        System.out.println("Invalid Sorting Choice");
                    }

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
