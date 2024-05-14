package CompanyStaff;

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

        System.out.print(indentation + " Manager          | ");
        this.manager = input.nextInt();
        System.out.print(indentation + " Resource Manager | ");
        this.resourceManager = input.nextInt();
        System.out.println(indentation + "-----------------------------------------\n");

        countOfProject();

        this.id = idOfProjects;
    }
    // Validation of Data
    private boolean checkLength(String line, String type) {
        
        switch (type) {
            case "Name":
                if (line.length() > 4 && line.length() < 21) 
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
                if (line.length() > 14 && line.length() < 51) 
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
        System.out.println("\n            Project Info");
        System.out.println("   -----------------------------------");
        System.out.println("    ID                  | " + getId());
        System.out.println("    --------------------|------------");
        System.out.println("    Name                | " + getName());
        System.out.println("    --------------------|------------");
        System.out.println("    Description         | " + getDescription());
        System.out.println("    --------------------|------------");
        System.out.println("    Manager ID          | " + getManager());
        System.out.println("    --------------------|------------");
        System.out.println("    Resource Manager ID | " + getResourceManager());
        System.out.println("    --------------------|------------");
        if (getStatus())
            System.out.println("    Status              | In progress");
        else
            System.out.println("    Status              | Done");
        System.out.println("   -----------------------------------\n");
        System.out.println("   Press 'Enter' to continue");
    }
}
