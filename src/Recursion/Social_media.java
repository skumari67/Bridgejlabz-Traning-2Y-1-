
package Recursion;

import java.util.Scanner;

class Friend {
    int userId;
    String name;
    int age;
    Friend next;

    Friend(int id, String name, int age) {
        this.userId = id;
        this.name = name;
        this.age = age;
        next = null;
    }
}

class UserFriend {
    int friendId;
    UserFriend next;

    UserFriend(int id) {
        friendId = id;
        next = null;
    }
}

public class Social_media {

    static Friend head = null;

    // Add User
    static void addUser(int id, String name, int age) {
        Friend newNode = new Friend(id, name, age);

        if (head == null) {
            head = newNode;
            return;
        }

        Friend temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Find User
    static Friend findUser(int id) {
        Friend temp = head;

        while (temp != null) {
            if (temp.userId == id) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    // Add Friend Connection
    static void addFriend(int id1, int id2) {
        Friend user = findUser(id1);
        Friend friend = findUser(id2);

        if (user == null || friend == null) {
            System.out.println("User Not Found");
            return;
        }

        if (id1 == id2) {
            System.out.println("Cannot Add Yourself");
            return;
        }

        UserFriend temp = userFriends(user);

        while (temp != null) {
            if (temp.friendId == id2) {
                System.out.println("Already Friends");
                return;
            }
            temp = temp.next;
        }

        addConnection(user, id2);
        addConnection(friend, id1);

        System.out.println("Friend Added");
    }

    // Friend List for Each User
    static UserFriend userFriends(Friend user) {
        return friends[user.userId];
    }

    static UserFriend[] friends = new UserFriend[10000];

    // Add Connection
    static void addConnection(Friend user, int id) {
        UserFriend newNode = new UserFriend(id);

        if (friends[user.userId] == null) {
            friends[user.userId] = newNode;
            return;
        }

        UserFriend temp = friends[user.userId];

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Remove Friend Connection
    static void removeFriend(int id1, int id2) {
        Friend user = findUser(id1);
        Friend friend = findUser(id2);

        if (user == null || friend == null) {
            System.out.println("User Not Found");
            return;
        }

        removeConnection(user, id2);
        removeConnection(friend, id1);

        System.out.println("Friend Connection Removed");
    }

    // Remove Connection
    static void removeConnection(Friend user, int id) {
        UserFriend temp = friends[user.userId];
        UserFriend prev = null;

        while (temp != null && temp.friendId != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        if (prev == null) {
            friends[user.userId] = temp.next;
        } else {
            prev.next = temp.next;
        }
    }

    // Display Friends
    static void displayFriends(int id) {
        Friend user = findUser(id);

        if (user == null) {
            System.out.println("User Not Found");
            return;
        }

        UserFriend temp = friends[id];

        if (temp == null) {
            System.out.println("No Friends");
            return;
        }

        while (temp != null) {
            Friend f = findUser(temp.friendId);

            if (f != null) {
                System.out.println(
                        "ID: " + f.userId +
                                " Name: " + f.name +
                                " Age: " + f.age
                );
            }

            temp = temp.next;
        }
    }

    // Mutual Friends
    static void mutualFriends(int id1, int id2) {
        Friend user1 = findUser(id1);
        Friend user2 = findUser(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User Not Found");
            return;
        }

        UserFriend temp1 = friends[id1];
        boolean found = false;

        while (temp1 != null) {
            UserFriend temp2 = friends[id2];

            while (temp2 != null) {
                if (temp1.friendId == temp2.friendId) {
                    Friend f = findUser(temp1.friendId);

                    if (f != null) {
                        System.out.println(f.name + " ID: " + f.userId);
                        found = true;
                    }
                    break;
                }

                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        if (!found) {
            System.out.println("No Mutual Friends");
        }
    }

    // Search User by ID
    static void searchID(int id) {
        Friend temp = findUser(id);

        if (temp == null) {
            System.out.println("User Not Found");
        } else {
            System.out.println(
                    "ID: " + temp.userId +
                            " Name: " + temp.name +
                            " Age: " + temp.age
            );
        }
    }

    // Search User by Name
    static void searchName(String name) {
        Friend temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(
                        "ID: " + temp.userId +
                                " Name: " + temp.name +
                                " Age: " + temp.age
                );
                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("User Not Found");
        }
    }

    // Count Friends
    static void countFriends() {
        Friend temp = head;

        while (temp != null) {
            int count = 0;
            UserFriend f = friends[temp.userId];

            while (f != null) {
                count++;
                f = f.next;
            }

            System.out.println(
                    temp.name + " has " + count + " friends"
            );

            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. Add Friend");
            System.out.println("3. Remove Friend");
            System.out.println("4. Mutual Friends");
            System.out.println("5. Display Friends");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Count Friends");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            int id, id1, id2, age;
            String name;

            switch (ch) {

                case 1:
                    System.out.print("Enter User ID: ");
                    id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    age = sc.nextInt();

                    if (id < 0 || id >= friends.length || findUser(id) != null) {
                        System.out.println("Invalid or Existing User ID");
                        break;
                    }

                    addUser(id, name, age);
                    break;

                case 2:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();

                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();

                    addFriend(id1, id2);
                    break;

                case 3:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();

                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();

                    removeFriend(id1, id2);
                    break;

                case 4:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();

                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();

                    mutualFriends(id1, id2);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    id = sc.nextInt();

                    displayFriends(id);
                    break;

                case 6:
                    System.out.print("Enter User ID: ");
                    id = sc.nextInt();

                    searchID(id);
                    break;

                case 7:
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    name = sc.nextLine();

                    searchName(name);
                    break;

                case 8:
                    countFriends();
                    break;

                case 9:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

