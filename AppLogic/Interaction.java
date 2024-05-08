package AppLogic;
// Java's Packages
import java.util.ArrayList;
import java.util.Scanner;

// Custom Packages
import CompanyStaff.*;

public class Interaction {
    private ArrayList<Employee> listOfEmployee;
    private ArrayList<Employee> listOfDevelopers;
    private ArrayList<Employee> listOfManagers;
    private ArrayList<Employee> listOfResourcesManagers;
    private ArrayList<Projects> listOfProjects;
    
    public Interaction() {
        this.listOfEmployee = new ArrayList<Employee>();
        this.listOfDevelopers = new ArrayList<Employee>();
        this.listOfManagers = new ArrayList<Employee>();
        this.listOfResourcesManagers = new ArrayList<Employee>();
        this.listOfProjects = new ArrayList<Projects>();
    }

    // Setters
    public void setEmployee(Employee employee) {
        listOfEmployee.add(employee);

        String position = employee.getPosition();
        char n = position.charAt(0);

        switch (n) {
            case 'M':
                listOfManagers.add(employee);
                break;
            case 'D':
                listOfDevelopers.add(employee);
                break;
            case 'R':
                listOfResourcesManagers.add(employee);
                break;
            default:
                break;
        }
    }
    public void setProjects(Projects project) {
        listOfProjects.add(project);
    }

    // Getters 
    public Employee getEmployee(int index) {
        return listOfEmployee.get(index);
    }
    public Projects getProjects(int index) {
        return listOfProjects.get(index);
    }

    public boolean checkResponsibles() {
        boolean checkManager = true;
        boolean checkResourceManager = true;
        if (listOfManagers.isEmpty()) {
            System.out.println("\n   You aren't able create project without a manager!\n");
            checkManager = false;
        }
        if (listOfResourcesManagers.isEmpty()) {
            System.out.println("\n   You aren't able create project without a resource manager!\n");
            checkResourceManager = false;
        }
            
        if (checkManager && checkResourceManager)
            return true;
        else
            return false;
    }

    public void relateToEmployee(Scanner input) {
        System.out.print("\n   Resouce Manager ID ");
        int resouceManager = input.nextInt();

        System.out.println("\n   Enter Developers ID in order!\n");
        System.out.print("   Enter number of devs: ");
        int n = input.nextInt();

        int[] devs = new int[4];
        for (int i = 0; i < n; i++) {
            System.out.print("   ID: ");
            int developer = input.nextInt();
            devs[i] = developer;
            getEmployee(resouceManager).setDevelopers(developer);
        }

        int projectID = getEmployee(resouceManager).getProjectID();
        for (int i = 0; i < n; i++) {
            getEmployee(devs[i]).setProjects(projectID);
        }
    }

    public void setProjectIdForEmployees() {
        int size = listOfProjects.size() - 1;

        int manager = listOfProjects.get(size).getManager();
        listOfEmployee.get(manager).setProjects(size);

        int resouceManager = listOfProjects.get(size).getResourceManager();
        listOfEmployee.get(resouceManager).setProjectID(size);
    }

                    // All Employees and Projects

    public void displayAllEmployees() {
        System.out.println("\n             Managers");
        System.out.println("   ------------------------------");
        System.out.println("    ID  | Status   | Name ");
        System.out.println("    ----------------------------");
        for (Employee e : listOfManagers) {
            if (e.getStatus())
                System.out.printf("    %d   | Enrolled | %s\n", e.getId(), e.getName());
            else
                System.out.printf("    %d   | Fired    | %s\n", e.getId(), e.getName());
        }
        System.out.println("   ------------------------------");

        System.out.println("\n         Resource Managers");
        System.out.println("   ------------------------------");
        System.out.println("    ID  | Status   | Name ");
        System.out.println("    ----------------------------");
        for (Employee e : listOfResourcesManagers) {
            if (e.getStatus())
                System.out.printf("    %d   | Enrolled | %s\n", e.getId(), e.getName());
            else
                System.out.printf("    %d   | Fired    | %s\n", e.getId(), e.getName());
        }
        System.out.println("   ------------------------------");

        System.out.println("\n            Developers");
        System.out.println("   ------------------------------");
        System.out.println("    ID  | Status   | Name ");
        System.out.println("    ----------------------------");
        for (Employee e : listOfDevelopers) {
            if (e.getStatus())
                System.out.printf("    %d   | Enrolled | %s\n", e.getId(), e.getName());
            else
                System.out.printf("    %d   | Fired    | %s\n", e.getId(), e.getName());
        }
        System.out.println("   ------------------------------\n");
    }
    public void displayAllProjects() {
        System.out.println("\n                 Projects");
        System.out.println("   ---------------------------------------------");
        System.out.println("    ID  | Status      | Manager ID | Name ");
        System.out.println("    -------------------------------------------");
        for (Projects e : listOfProjects) {
            if (e.getStatus()) 
                System.out.printf("    %d   | In progress | %d          | %s\n", e.getId(), e.getManager(), e.getName());
            else 
                System.out.printf("    %d   | Done        | %d          | %s\n", e.getId(), e.getManager(), e.getName());
        }
        System.out.println("   ---------------------------------------------\n");
    }
    public void displayValiables(int n) {
        int valiableId;
        String valiableName;
        switch (n) 
        {
            case 1:
                System.out.println("\n        Valiable Developers");
                System.out.println("   -----------------------------");
                for (Employee e : listOfDevelopers) {
                    if (e.getStatus()) 
                    {
                        valiableId = e.getId();
                        valiableName = e.getName();
                        System.out.printf("    %d | %s\n", valiableId, valiableName);
                    }
                }
                System.out.println("   -----------------------------"); 
                break;
            case 2:
                System.out.println("\n          Valiable Managers");
                System.out.println("   -----------------------------");
                for (Employee e : listOfManagers) {
                    if (e.getStatus()) 
                    {
                        valiableId = e.getId();
                        valiableName = e.getName();
                        System.out.printf("    %d | %s\n", valiableId, valiableName);
                    }
                }
                System.out.println("   -----------------------------"); 
                break;
            case 3:
                System.out.println("\n    Valiable Resource Managers");
                System.out.println("   -----------------------------");
                for (Employee e : listOfResourcesManagers) {
                    if (e.getStatus()) 
                    {
                        valiableId = e.getId();
                        valiableName = e.getName();
                        System.out.printf("    %d | %s\n", valiableId, valiableName);
                    }
                    
                }
                System.out.println("   -----------------------------");
                break;
            default:
                System.out.println("\n          Valiable Projects");
                System.out.println("   -----------------------------");
                for (Projects p : listOfProjects) {
                    if (p.getStatus()) 
                    {
                        valiableId = p.getId();
                        valiableName = p.getName();
                        System.out.printf("    %d | %s\n", valiableId, valiableName);
                    }
                    
                }
                System.out.println("   -----------------------------\n");
                break;
        }
    }
}
