package CompanyStaff;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Projects {
    private String name;
    private String description;
    private boolean status;
    private int manager;
    private int resourceManager;
    private int id;
    private boolean flag;
    // Fianl Attributes
    private final int MIN_LENGTH_OF_PROJECT_NAME = 5;
    private final int MAX_LENGTH_OF_PROJECT_NAME = 20;
    private final int MIN_LENGTH_OF_PROJECT_DESCRIPTION = 15;
    private final int MAX_LENGTH_OF_PROJECT_DESCRIPTION = 50;
    private final String indentation = "                ";
    // For Use Global Variable input
    private Scanner input;

    // For All Projects
    static int numberOfFinishProjects;
    static int idOfProjects;
    static {
        numberOfFinishProjects = 0;
        idOfProjects = -1;
    }
    private void countOfProject() {
        idOfProjects++;
    }
    private void countOfFinishProjects() {
        numberOfFinishProjects++;
    }
    public void finishProject() {
        status = false;
        countOfFinishProjects();
    }

    // Getters 
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public boolean getStatus() {
        return status;
    }
    public int getManager() {
        return manager;
    }
    public int getResourceManager() {
        return resourceManager;
    }
    public int getId() {
        return id;
    }
    public boolean getFlag() {
        return flag;
    }

    // Setters
    public void setFlag(String anction) {
        switch (anction) {
            case "has devs":
                this.flag = true;
                break;
            case "has not devs":
                this.flag = false;
                break;
            default:
                break;
        }
    }
    public void setManager(int manager) {
        this.manager = manager;
    }
    public void setResourceManager(int resourceManager) {
        this.resourceManager = resourceManager;
    }

    public Projects(Scanner scanner) {
        this.input = scanner;
        this.status = true; // In progress
        this.flag = false; // Project without devs

        // Input
        System.out.println("\n" + indentation + "                Project");
        System.out.println(indentation + "-----------------------------------------");

        boolean resultOfChecking;
        String checking;
        do {
            System.out.print(indentation + " Name             | ");
            checking = input.nextLine();

            resultOfChecking = checkLength(checking, "Name");

        } while (resultOfChecking);

        do {
            System.out.print(indentation + " Description      | ");
            checking = input.nextLine();

            resultOfChecking = checkLength(checking, "Description");

        } while (resultOfChecking);

        
        try{
            System.out.print(indentation + " Manager          | ");
            this.manager = input.nextInt();
        } 
        catch (InputMismatchException e)
        {
            System.out.println("\n      Enter valid manager ID, please!\n");
            resultOfChecking = true;
            input.next();
        }
        
        try 
        {
            System.out.print(indentation + " Resource Manager | ");
            this.resourceManager = input.nextInt();
        }
        catch (InputMismatchException e) 
        {
            System.out.println("      Enter valid resource manager ID, please!");
            resultOfChecking = true;
            input.next();
        }
        

        System.out.println(indentation + "-----------------------------------------\n");

        countOfProject();

        this.id = idOfProjects;
    }
    // Validation of Data
    private boolean checkLength(String line, String type) {
        
        switch (type) {
            case "Name":
                if (line.length() >= MIN_LENGTH_OF_PROJECT_NAME && line.length() <= MAX_LENGTH_OF_PROJECT_NAME) 
                {
                    this.name = line;
                    return false;
                }
                else 
                {
                    System.out.println("\n      Length of name should be less than 21 and more than 4 symbols!\n");
                    return true;
                }
            case "Description":
                if (line.length() >= MIN_LENGTH_OF_PROJECT_DESCRIPTION && line.length() <= MAX_LENGTH_OF_PROJECT_DESCRIPTION) 
                {
                    this.description = line;
                    return false;
                }
                else 
                {
                    System.out.println("\n      Length of description should be less than 51 and more than 14 symbols!\n");
                    return true;
                }
            default:
                return true;
        }
    }

    // Display Project Info 
    public void displayProject() {
        String line = "";
        int time = (getDescription().length() / 10) - 1;
        int tail = getDescription().length() % 10;
        int start = 0;
        int end = 10;
        System.out.println("\n" + indentation + "            Project Info");
        System.out.println(indentation + "-----------------------------------------");
        System.out.println(indentation + " ID                  | " + getId());
        System.out.println(indentation + " --------------------|------------------");
        System.out.println(indentation + " Name                | " + getName());
        System.out.println(indentation + " --------------------|------------------");
        line = getDescription().substring(start, end);
        System.out.printf(indentation + " Description         | %s\n", line);
        for (int i = 0; i < time; i++) {
            start = start + 10;
            end = end + 10;
            line = getDescription().substring(start, end);
            System.out.printf(indentation + "                     | %s\n", line);
        }
        start = time * 10;
        end = tail + start;
        line = getDescription().substring(start, end);
        System.out.printf(indentation + "                     | %s\n", line);
        System.out.println(indentation + " --------------------|------------------");
        System.out.println(indentation + " Manager ID          | " + getManager());
        System.out.println(indentation + " --------------------|------------------");
        System.out.println(indentation + " Resource Manager ID | " + getResourceManager());
        System.out.println(indentation + " --------------------|------------------");
        if (getFlag()) // hasn't devs shows when num of devs RS = 3! Logical Error
            System.out.println(indentation + " Developers          | has devs");
        else // because of flag TRUE after finishing of project project would show that devs there're, but the truth is there aren't
            System.out.println(indentation + " Developers          | hasn't devs");
        System.out.println(indentation + " --------------------|------------------");
        if (getStatus())
            System.out.println(indentation + " Status              | In progress");
        else
            System.out.println(indentation + " Status              | Done");
        System.out.println(indentation + "-----------------------------------------\n");
        System.out.println("   Press 'Enter' to continue");
    }
}
