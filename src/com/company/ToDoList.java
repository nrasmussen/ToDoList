package com.company;

import java.util.Scanner;

public class ToDoList extends User {

    ToDoList(String name, String username, String password) {
        super(name, username, password);
    }

    void run() {

        Scanner input = new Scanner(System.in);

        String optionChosen;

        while (true) {
            saveData();
            System.out.println("Welcome to " + getName() + "'s To-Do List. What would you like to do? " + "\n1. Add" + "\n2. Delete" + "\n3. Delete all" + "\n4. Edit" + "\n5. View specific assignment" + "\n6. View specific category" + "\n7. View all assignments" + "\n8. Exit");
            optionChosen = input.nextLine();

            switch (optionChosen) {
                case "1":
                    addAssignment();
                    break;
                case "2":
                    removeAssignment();
                    break;
                case "3":
                    removeAllAssignments();
                    break;
                case "4":
                    editAssignment();
                    break;
                case "5":
                    printSpecificAssignment();
                    break;
                case "6":
                    printSpecificAssignmentCategory();
                    break;
                case "7":
                    printToDoList();
                    break;
                case "8":
                    System.out.println("See you soon, " + getName() + "!");
                    System.exit(0);
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }

    int login() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the login page, you will input your credentials. You only have 5 chances when typing in the credentials.");

        System.out.println("Please input username:");
        String inputtedUsername = input.nextLine();

        System.out.println("Please input password:");
        String inputtedPassword = input.nextLine();


        if (!inputtedUsername.equalsIgnoreCase(getUsername()) || !inputtedPassword.equals(getPassword())) {
            for (int i = 0; i < 4; i++) {
                System.out.println("Incorrect Username or Password, try again.");
                System.out.println("Please input username:");
                inputtedUsername = input.nextLine();
                System.out.println("Please input password:");
                inputtedPassword = input.nextLine();
                if ((getUsername().equals(inputtedUsername)) && (getPassword().equals(inputtedPassword))) {
                    return 1;
                }
            }
        } else {
            return 1;
        }
        return 0;
    }
}
