package CompanyStaff;

import java.util.Scanner;

public class Projects {
    private String name;
    private String description;
    private boolean status;
    private int manager;
    private int resourceManager;
    private int id;
    // For Use Global Variable input
    private Scanner input;

    // All Projects
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

    public Projects(Scanner scanner) {
        this.input = scanner;
        this.status = true; // In progress

        // Input
        System.out.println("\n                Project");
        System.out.println("   ---------------------------------------");
        System.out.print("    Name             | ");
        this.name = input.nextLine();
        System.out.print("    Description      | ");
        this.description = input.nextLine();
        System.out.print("    Manager          | ");
        this.manager = input.nextInt();
        System.out.print("    Resource Manager | ");
        this.resourceManager = input.nextInt();
        System.out.println("   ---------------------------------------\n");

        countOfProject();

        this.id = idOfProjects;
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
