package CompanyStaff;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private String name;
    private boolean status;
    private String position;
    private int id;
    private boolean flag;
    private int numberOfActualProjects; // For Manager
    private int projectID; //For Resoures Manager
    private ArrayList<Integer> listOfDevelopers; //For Resoures Manager
    private ArrayList<Integer> listOfProjects; //For Manager & Developers
    // Final Attributes
    private final int MAX_NUMBER_OF_PROJETS_FOR_MANAGER = 3;
    private final int MIN_LENGTH_OF_EMPLOYEE_NAME = 3;
    private final int MAX_LENGTH_OF_EMPLOYEE_NAME = 15;
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
        return numberOfActualProjects; 
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
    public void setFlag(String employee, String action) {
        switch (employee) {
            case "Manager":
                countOfManagerProject(action);
                break;
            case "Resoures Manager":
            case "Developer":
                switch (action) {
                    case "work":
                        this.flag = true;
                        break;
                    case "free":
                        this.flag = false;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }
    public void countOfManagerProject(String action) {
        switch (action) {
            case "increase":
                numberOfActualProjects++;
                break;
            case "decrease":
                numberOfActualProjects--;
                break;
            case "reset":
                numberOfActualProjects = 0;
                break;
            default:
                break;
        }
        if (numberOfActualProjects < MAX_NUMBER_OF_PROJETS_FOR_MANAGER)
            this.flag = false;
        else 
            this.flag = true;
    }
    //
    public void setProjects(int id) {
        listOfProjects.add(id);
    }
    public void setDevelopers(int id) {
        listOfDevelopers.add(id);
    }
    public void setProjectID(int id) {
        this.projectID = id;
    }

    public Employee(Scanner scanner) {
        this.input = scanner;
        this.status = true; // Employee is enrolled
        this.flag = false; // Employee is free
        
        // Input
        System.out.println("\n" + indentation + "           Employee");
        System.out.println(indentation + "------------------------------");
        boolean resultOfChecking;
        String checking;
        do {
            System.out.print(indentation + " Name     | ");
            checking = input.nextLine();

            resultOfChecking = checkLength(checking);

        } while(resultOfChecking);

        do {
            try 
            {
                System.out.print(indentation + " Position | ");
                checking = input.nextLine();

                resultOfChecking = testOfCorrectness(checking);
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("\n      Enter the employee position, please!\n");
                resultOfChecking = true;
            }
            
        } while (resultOfChecking);

        System.out.println(indentation + "------------------------------\n");

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
                System.out.println("\n      Please, enter a corect position! \n");
                return true;
        }
    }
    private boolean checkLength(String line) {
        if (line.length() >= MIN_LENGTH_OF_EMPLOYEE_NAME && line.length() < MAX_LENGTH_OF_EMPLOYEE_NAME) 
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
        System.out.println("\n" + indentation + "         Employee Info");
        System.out.println(indentation + "--------------------------------");
        System.out.println(indentation + " ID         | " + getId());
        System.out.println(indentation + " -----------|------------------");
        System.out.println(indentation + " Name       | " + getName());
        System.out.println(indentation + " -----------|------------------");
        System.out.println(indentation + " Position   | " + getPosition());
        System.out.println(indentation + " -----------|------------------");
        if (getStatus()) 
        {
            display(position);
            System.out.println(indentation + " Status     | Enrolled");
        }
        else
        {
            display(position);
            System.out.println(indentation + " Status     | Fired");
        }
        System.out.println(indentation + "--------------------------------\n");
        System.out.println("   Press 'Enter' to continue");
    }
    
    private void display(String position) {
        char n = position.charAt(0);
        int id;

        id = listOfProjects.size() - 1;
        switch (n) {
            case 'M':
                for (int p : listOfProjects) 
                {
                    System.out.printf(indentation + "            | %d\n", listOfProjects.get(p));
                }
                System.out.println(indentation + " -----------|------------------");
                break;
            case 'D':
                if (getFlag()) 
                {
                    id = listOfProjects.size() - 1;
                    System.out.println(indentation + " Actual     | " + listOfProjects.get(id));
                    System.out.println(indentation + " Project    |");
                    System.out.println(indentation + " -----------|------------------");
                    if (listOfProjects.size() == 1) 
                    {
                        System.out.println(indentation + " Finished   | None");
                    }
                    else 
                    {
                        for (int i = 0; i < id; i++) 
                        {
                            System.out.printf(indentation + " Finished   | %d\n", listOfProjects.get(i));
                        }
                    }
                    System.out.println(indentation + " -----------|------------------");
                }
                else 
                {
                    System.out.println(indentation + " Actual     | None");
                    System.out.println(indentation + " Project    |");
                    System.out.println(indentation + " -----------|------------------");
                    for (int p : listOfProjects) 
                    {
                        System.out.printf(indentation + " Finished   | %d\n", p);
                    }
                    System.out.println(indentation + " -----------|------------------");
                }
                break;
            case 'R':
                if (getFlag()) 
                {
                    id = listOfDevelopers.size() - 1;
                    System.out.println(indentation + " Actual     | " + getProjectID());
                    System.out.println(indentation + " Project    |");
                    System.out.println(indentation + " -----------|------------------"); 
                    if (listOfDevelopers.isEmpty()) 
                    {
                        System.out.println(indentation + " Developers | None");
                        System.out.println(indentation + " -----------|------------------");
                    }             
                    else 
                    {
                        System.out.println(indentation + " Developers | " + listOfDevelopers.get(id));
                        for (int i = 0; i < id; i++) 
                        {
                            System.out.printf(indentation + "            | %d\n", listOfDevelopers.get(i));
                        }
                        System.out.println(indentation + " -----------|------------------");
                    }  
                }
                else 
                {
                    System.out.println(indentation + " Actual     | None");
                    System.out.println(indentation + " -----------|------------------");
                    System.out.println(indentation + " Developers | None");
                    System.out.println(indentation + " -----------|------------------");
                }
                break;
            default:
                break;
        }
    }
}