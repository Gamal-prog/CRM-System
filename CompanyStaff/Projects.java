package CompanyStaff;

import java.util.Scanner;
//import java.util.ArrayList;

//import AppLogic.*;

public class Projects {
    private String name;
    private String description;
    private boolean status;
    private int manager;
    private int resourceManager;
    private int id;
    // For Use Global Variable input
    private Scanner input;
    //private Interaction conection; //!? Static del

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

    /* 
    public Projects(Interaction conection) {
        this.conection = conection; 
    }
    
    public Projects(Scanner scanner, Interaction conection) {
        this.input = scanner;
        this.conection = conection; 
        this.status = true; // In progress

        displayManagers();
        displayResourceManagers();

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
    */

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
    /* 
    private ArrayList<Integer> searchManagers() {
        ArrayList<Integer> managers = new ArrayList<Integer>();

        char position;
        for (Employee e : conection.getList()) {
            position = e.getPosition().charAt(0);

            switch (position) {
                case 'M':
                    managers.add(e.getId());
                    break;
                default:
                    break;
            }
        }

        return managers;
    }
    private ArrayList<Integer> searchResourceManagers() {
        ArrayList<Integer> managers = new ArrayList<Integer>();
        
        char position;
        for (Employee e : conection.getList()) {
            position = e.getPosition().charAt(0);

            switch (position) {
                case 'R':
                    managers.add(e.getId());
                    break;
                default:
                    break;
            }
        }

        return managers;
    }
    private boolean searchResponsibles(ArrayList<Integer> managers, 
                                        ArrayList<Integer> resourceManagers) 
    {
        boolean checkManager = true;
        boolean checkResourceManager = true;
        if (managers.isEmpty()) {
            System.out.println("\n   You aren't able create project without a manager!\n");
            checkManager = false;
        }
        if (resourceManagers.isEmpty()) {
            System.out.println("\n   You aren't able create project without a resource manager!\n");
            checkResourceManager = false;
        }
            
        if (checkManager && checkResourceManager)
            return true;
        else
            return false;
    }
    public boolean checkResponsibles() {
        ArrayList<Integer> managers = searchManagers();
        ArrayList<Integer> resourceManagers = searchResourceManagers();
        boolean result = searchResponsibles(managers, resourceManagers);

        return result;
    }
    
    
    private void displayManagers() {
        System.out.println("\n          Valiable Managers");
        System.out.println("   -----------------------------");
        ArrayList<Integer> managers = searchManagers();
        int valiableId;
        String valiableName;
        for (Integer e : managers) {
            valiableId = conection.getEmployee(e).getId();
            valiableName = conection.getEmployee(e).getName();
            System.out.printf("    %d | %s\n", valiableId, valiableName);
        }
        System.out.println("   -----------------------------");  
    }
    private void displayResourceManagers() {
        System.out.println("\n    Valiable Resource Managers");
        System.out.println("   -----------------------------");
        ArrayList<Integer> managers = searchResourceManagers();
        int valiableId;
        String valiableName;
        for (Integer e : managers) {
            valiableId = conection.getEmployee(e).getId();
            valiableName = conection.getEmployee(e).getName();
            System.out.printf("    %d | %s\n", valiableId, valiableName);
        }
        System.out.println("   -----------------------------");
    }
    */

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
