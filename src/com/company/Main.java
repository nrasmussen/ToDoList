package com.company;

public class Main {

    public static void main(String[] args) {

        //One has to set their credentials, and their preferred name in the constructor.
        User soeland = new ToDoList("Mr.Soeland", "soeland", "soeland123");

        //This conditional statement asks the user to input their credentials.
        //In the case that the inputted credentials are correct, the main program (run method) is executed.
        //Adversely, if this is not the case, the user has 4 more
        // tries to input the credentials before the program shuts down.

        if (((ToDoList) soeland).login()==1){
            System.out.println("Successful Login");
            ((ToDoList) soeland).run();
        } else {
            System.exit(0);
        }
    }
}

