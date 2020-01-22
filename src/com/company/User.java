package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class User {
    private String name;
    private String username;
    private String password;

    private int assignmentNumber;

    private String[][] list;

    //Row number 0 corresponds to Assignment.
    //Row number 1 corresponds to DateDue.
    //Row number 2 corresponds to AssignmentLabel.
    //Row number 3 corresponds to estimatedTimeToComplete.

    private Scanner input = new Scanner(System.in);

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.list = new String[4][100];

        System.out.println("Hey " + getName() + ", for the free version of this program, the maximum amount of assignments that you can add is 100.");
        System.out.println();

        //In the case that the save files don't exist, don't read data. Adversely, read it.

        File f = new File("assignmentNumber.txt");
        if (f.exists()) {
            readData();
        } else {
            setAssignmentNumber(0);
            removeAllAssignments();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAssignmentNumber() {
        return assignmentNumber;
    }

    public void setAssignmentNumber(int assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }

    void printSpecificAssignmentCategory() {
        Scanner input = new Scanner(System.in);

        int assignmentNumber;
        String category;

        System.out.println("What assignment do you want to see?");
        try {
            assignmentNumber = (Integer.parseInt(input.nextLine())) - 1;
        } catch(Exception e){
            System.out.println("Invalid Input");
            return;
        }
        if (list[0][assignmentNumber] == null) {
            System.out.println("Assignment does not exist.");
        } else {
            System.out.println("What category do you want to see? \n1. Assignment Name \n2. Due Date \n3. Label \n4. Estimated Time To Complete");
            category = input.nextLine();
            System.out.println(list[Integer.parseInt(category)][assignmentNumber]);
        }
    }

    void printSpecificAssignment() {
        System.out.println("Please input Assignment Number:");
        try {
            int assignmentNumber = (Integer.parseInt(input.nextLine())) - 1;
        } catch(Exception e){
            System.out.println("Invalid Input");
            return;
        }

        if (list[0][assignmentNumber] == null) {
            System.out.println("Assignment does not exist.");
        } else {
            System.out.println(("Assignment Name: " + list[0][assignmentNumber]) + "\n Date Due: " + (list[1][assignmentNumber]) + "\n Assignment Label: " + (list[2][assignmentNumber]) + "\n Expected time to complete: " + (list[3][assignmentNumber]));
        }
    }

    void printAssignment(int assignmentNumber) {
        System.out.println(("Assignment Name: " + list[0][assignmentNumber]) + "\n Date Due: " + (list[1][assignmentNumber]) + "\n Assignment Label: " + (list[2][assignmentNumber]) + "\n Expected time to complete: " + (list[3][assignmentNumber]) + "\n");

    }

    void printToDoList() {
        int i;

        if (getAssignmentNumber() == 0) {
            i = -1;
        } else {
            i = 0;
        }

        while (i < getAssignmentNumber()) {
            if (list[0][0] == null) {
                System.out.println("You have no assignments, congratulations!");
                break;
            }
            System.out.println((" " + (i + 1) + "." + "\n Assignment Name:" + list[0][i]) + "\n Date Due: " + (list[1][i]) + "\n Assignment Label: " + (list[2][i]) + "\n Expected time to complete: " + (list[3][i]) + "\n");
            i++;
        }

    }

    int printToDoListForEdit() {
        for (int i = 0; i < getAssignmentNumber(); i++) {
            if (list[0][0] == null) {
                System.out.println("No assignments found.");
                return 0;
            }
            System.out.println((" " + (i + 1) + "." + "\n Assignment Name:" + list[0][i]) + "\n Date Due: " + (list[1][i]) + "\n Assignment Label: " + (list[2][i]) + "\n Expected time to complete: " + (list[3][i]) + "\n");
        }
        return 1;
    }

    void addAssignment() {
        System.out.println("What is the name of your assignment?");
        list[0][getAssignmentNumber()] = input.nextLine();
        System.out.println("When is this assignment due?");
        list[1][getAssignmentNumber()] = input.nextLine();
        System.out.println("What label do you want to put on the assignment?");
        list[2][getAssignmentNumber()] = input.nextLine();
        System.out.println("What is the estimated time to complete this assignment?");
        list[3][getAssignmentNumber()] = input.nextLine();
        printAssignment(getAssignmentNumber());
        setAssignmentNumber(getAssignmentNumber() + 1);

    }

    void editAssignment() {
        int assignmentNumber = 0;
        String assignmentCategory;
        if (printToDoListForEdit() == 1) {
            System.out.println("What Assignment do you want to edit?");
            try {
                assignmentNumber = (Integer.parseInt(input.nextLine())) - 1;
            } catch(Exception e){
                System.out.println("Invalid Input");
                return;
            }

            try {
                if (list[0][assignmentNumber] == null) {
                    System.out.println("Assignment does not exist.");
                } else {

                    System.out.println("What category do you want to edit? \n1. Assignment Name \n2. Due Date \n3. Label \n4. Estimated Time To Complete");
                    assignmentCategory = input.nextLine();

                    System.out.println("What do you want to replace it with:");
                    switch (assignmentCategory) {
                        case "1":
                            list[0][assignmentNumber] = input.nextLine();
                            list[0][assignmentNumber] = " " + list[0][assignmentNumber];
                            break;
                        case "2":
                            list[1][assignmentNumber] = input.nextLine();
                            list[1][assignmentNumber] = " " + list[1][assignmentNumber];
                            break;
                        case "3":
                            list[2][assignmentNumber] = input.nextLine();
                            list[2][assignmentNumber] = " " + list[2][assignmentNumber];
                            break;
                        case "4":
                            list[3][assignmentNumber] = input.nextLine();
                            list[3][assignmentNumber] = " " + list[3][assignmentNumber];
                            break;
                        default:
                            System.out.println("Error");
                            break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Input");
            }
        }

    }

    void removeAssignment() {
        System.out.println("What Assignment do you want to remove?");
        int temporary = 0;
        try {
             temporary = (Integer.parseInt(input.nextLine())) - 1;
        } catch(Exception e){
            System.out.println("Invalid Input");
            return;
        }

        if(temporary<=0){
            System.out.println("Invalid Input");
            return;
        }

        list[0][temporary] = null;
        list[1][temporary] = null;
        list[2][temporary] = null;
        list[3][temporary] = null;

        for (int i = temporary; i < list.length; i++) {
            list[0][i] = list[0][i + 1];
            list[1][i] = list[1][i + 1];
            list[2][i] = list[2][i + 1];
            list[3][i] = list[3][i + 1];
        }

        setAssignmentNumber((getAssignmentNumber()) - 1);
    }

    void removeAllAssignments() {
        int i = 0;
        while (list[0][i] != null) {

            list[0][i] = null;
            list[1][i] = null;
            list[2][i] = null;
            list[3][i] = null;
            i++;
        }
        setAssignmentNumber(0);
    }

    void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream("todolist.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);

        } catch (Exception e) {
            System.out.println("Error");
        }

        try {
            Writer wr = new FileWriter("assignmentNumber.txt");
            wr.write(Integer.toString(getAssignmentNumber()));
            wr.close();
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

    private void readData() {
        try {
            FileInputStream fis = new FileInputStream("todolist.dat");
            ObjectInputStream iis = new ObjectInputStream(fis);
            list = (String[][]) iis.readObject();

        } catch (Exception e) {
            System.out.println("Error");
        }

        String temporary = null;
        try {
            temporary = Files.readString(Paths.get("assignmentNumber.txt"));
        } catch (IOException e) {
            System.out.println("Error");
            System.exit(0);
        }
        setAssignmentNumber(Integer.parseInt(temporary));
    }
}
