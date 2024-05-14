package CompanyStaff;

import java.util.Scanner;

public class Employee {
    private String name;
    private boolean status;
    private String position;
    private int id;
    private boolean flag;
    private int numberOfActualProjects;
    // Fianl Attributes
    private final int MAX_NUMBER_OF_PROJETS_FOR_MANAGER = 3;
    private final String indentation = "                     ";
    // For Use Global Variable input
    private Scanner input;

    // For All Employees
    static int numberOfEmployee;
    static int idOfEmployees;
    static {
        numberOfEmployee = 0;
        idOfEmployees = -1;
    }
    private void countOfEmployee() {
        numberOfEmployee++;
        idOfEmployees++;
    }
    private void countOfFireEmployee() {
        numberOfEmployee--;
    }
    public void fireOfEmployee() {
        status = false;
        countOfFireEmployee();
    }

    //
    public void countOfManagerProject(String action) {
        switch (action) {
            case "increase":
                numberOfActualProjects++;
                break;
            case "decrease":
                numberOfActualProjects--;
                break;
            default:
                break;
        }
        if (numberOfActualProjects <= MAX_NUMBER_OF_PROJETS_FOR_MANAGER)
            this.flag = false;
        else 
            this.flag = true;
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
    public int getId() {
        return id;
    }
    public boolean getFlag() {
        return flag;
    }
    public int getNumberOfActualProjects() {
        // NOTHING
        return numberOfActualProjects; // NOTHING
    }

    // Setters
    public void setFlag(String employee, String action) {
        switch (employee) {
            case "Manager":
                countOfManagerProject(action);
                break;
            case "Resoures Manager":
            case "Developer":
                this.flag = true;
                break;
            default:
                break;
        }
    }

    public Employee(Scanner scanner) {
        this.input = scanner;
        this.status = true; // Employee is enrolled
        this.flag = false; // Employee is free
        
        // Input
        System.out.println("\n" + indentation + "            Employee");
        System.out.println(indentation + "------------------------------");
        boolean resultOfChecking;
        String checking;
        do {
            System.out.print(indentation + " Name     | ");
            checking = input.nextLine();

            resultOfChecking = checkLength(checking);

        } while(resultOfChecking);

        do {
            System.out.print(indentation + " Position | ");
            checking = input.nextLine();

            resultOfChecking = testOfCorrectness(checking);
            
        } while (resultOfChecking);

        System.out.println(indentation + "------------------------------\n");

        countOfEmployee(); 
        
        this.id = idOfEmployees;
    }

    // Validation of Data
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
                System.out.println("\n      Please, enter a corect position! \n");
                return true;
        }
    }
    private boolean checkLength(String line) {
        if (line.length() > 2 && line.length() < 16) 
                {
                    this.name = line;
                    return false;
                }
                else 
                {
                    System.out.println("\n      Length of name should be less than 16 and more than 2 symbols!\n");
                    return true;
                }
    }

    // Display Employee Info 
    public void displayEmployee() {
        System.out.println("\n       Employee Info");
        System.out.println("   ----------------------");
        System.out.println("    ID       | " + getId());
        System.out.println("    ---------|----------");
        System.out.println("    Name     | " + getName());
        System.out.println("    ---------|----------");
        System.out.println("    Position | " + getPosition());
        System.out.println("    ---------|----------");
        if (getStatus()) 
            System.out.println("    Status   | Enrolled");
        else
            System.out.println("    Status   | Fired");
        System.out.println("   ----------------------\n");
        System.out.println("   Press 'Enter' to continue");
    }
}