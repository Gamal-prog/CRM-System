package CompanyStaff;

import java.util.Scanner;
import java.util.ArrayList;

public class Employee {
    private String name;
    private boolean status;
    private String position;
    private int id;
    private ArrayList<Integer> listOfDevelopers; //For Resoures Manager
    private int projectID; //For Resoures Manager
    private ArrayList<Integer> listOfProjects; //For Manager & Developers

    // For Use Global Variable input
    private Scanner input;

    // All Employees
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

    public Employee(Scanner scanner) {
        this.input = scanner;
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
        
        this.id = idOfEmployees;

        this.listOfDevelopers = new ArrayList<Integer>();
        this.listOfProjects = new ArrayList<Integer>();
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
                System.out.println("\n   Please, enter a corect position! \n");
                return true;
        }
    }

    public void fireOfEmployee() {
        status = false;
        countOfFireEmployee();
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
    public int getProjectID() {
        return projectID;
    }
    public ArrayList<Integer> getProjects() {
        return listOfProjects;
    }
    public ArrayList<Integer> getDevs() {
        return listOfDevelopers;
    }

    // Setters
    public void setProjects(int id, int index) {
        listOfProjects.add(index, id);
    }
    public void setDevelopers(int id, int index) {
        listOfDevelopers.add(index, id);
    }
    public void setProjectID(int id) {
        this.projectID = id;
    }

    private void checkPosition() {
        char n = position.charAt(0);

        switch (n) {
            case 'M':
            case 'D':
                if (!listOfProjects.isEmpty()) 
                {
                    System.out.println("    -----------|--------");
                    for (int p : listOfProjects)
                        System.out.printf("    Projects   | %d", p);
                }
                break;
            case 'R':
                if (!listOfDevelopers.isEmpty()) 
                {
                    System.out.println("    -----------|--------");
                    for (int e : listOfDevelopers)
                        System.out.printf("    Developer  | %d\n", e);
                }  
                break;
            default:
                break;
        }
    }
    // Display Employee Info 
    public void displayEmployee() {
        System.out.println("\n       Employee Info");
        System.out.println("   ----------------------");
        System.out.println("    ID         | " + getId());
        System.out.println("    -----------|--------");
        System.out.println("    Name       | " + getName());
        System.out.println("    -----------|--------");
        System.out.println("    Position   | " + getPosition());
        System.out.println("    -----------|--------");
        if (getStatus()) 
        {
            System.out.println("    Status     | Enrolled");
            checkPosition();
        }
        else 
        {
            System.out.println("    Status     | Fired");
        }
        System.out.println("   ----------------------\n");
        System.out.println("   Press 'Enter' to continue");
    }
}