package CompanyStaff;

import java.util.Scanner;

public class Employee {
    private String name;
    private boolean status;
    private String position;
    //private String[] listOfDevelopers; //For Resoures Manager
    //private String[] listOfProjects; //For Manager 
    // Fpr Use Global Variable input
    private Scanner input;

    // All Employees
    static int numberOfEmployee;
    static {
        numberOfEmployee = 0;
    }
    private void countOfEmployee(){ // Когда увольняю нужно до отнимать, но и доступ у метода другой должен быть
        numberOfEmployee++;
    }

    public Employee(Scanner scanner) {
        this.input = scanner;
        // On staff
        this.status = true; // Employee is enrolled
        
        // Input
        System.out.println("\n          Employee");
        System.out.println("   ----------------------");
        System.out.print("    Name     | ");
        this.name = input.nextLine();

        boolean resultOfChecking;
        do {
            System.out.print("    Position | ");
            String checking = input.nextLine();

            resultOfChecking = testOfCorrectness(checking);
            
        } while (resultOfChecking);

        System.out.println("   ----------------------\n");

        countOfEmployee();        
    }

    // Available in class only
    private boolean testOfCorrectness(String checking) {
        char n = checking.charAt(0);

        switch (n) {
            case 'm':
            case 'M':
                this.position = "Manager";
                return false;
            case 'd':
            case 'D':
                this.position = "Developer";
                return false;
            case 'r':
            case 'R':
                this.position = "Resources manager";
                return false;
            default:
                System.out.println("\n   Please, enter a corect position! \n");
                return true;
        }
    }

    protected void fireOfEmployee() {
        status = false;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public boolean getStatus() {
        return status;
    }
}
