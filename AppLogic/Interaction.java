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
    //
    //private final int MAX_NUMBER_OF_DEVELOPERS = 4;
    private final String indentation = "                     ";

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

    public Interaction() {
        this.listOfEmployee = new ArrayList<Employee>();
        this.listOfDevelopers = new ArrayList<Employee>();
        this.listOfManagers = new ArrayList<Employee>();
        this.listOfResourcesManagers = new ArrayList<Employee>();
        this.listOfProjects = new ArrayList<Projects>();
    }

    public boolean checkResponsibles() { // Check Flag 
        boolean checkManager = true;
        boolean checkResourceManager = true;
        if (listOfManagers.isEmpty()) 
        {
            System.out.println("\n      You aren't able create project without a manager!\n");
            checkManager = false;
        }
        if (listOfResourcesManagers.isEmpty()) 
        {
            System.out.println("\n      You aren't able create project without a resource manager!\n");
            checkResourceManager = false;
        }
            
        if (checkManager && checkResourceManager)
            return true;
        else
            return false;
    }
    public boolean checkID(int id, int n) {
        switch (n) {
            case 1:
            if (listOfEmployee.isEmpty()) 
            {
                System.out.println("\n      There aren't employees in company!\n");
                System.err.println("   Press 'Enter' to continue");
                return false;
            }
            else 
            {
                if (id < listOfEmployee.size()) 
                {
                    return true;
                }
                else {
                    System.out.println("\n      Entered ID doesn't exit!\n");
                    System.err.println("   Press 'Enter' to continue");
                    return false;
                }
            }
            case 2:
                if (listOfProjects.isEmpty()) 
                {
                    System.out.println("\n      There aren't projects in company!\n");
                    System.err.println("   Press 'Enter' to continue");
                    return false;
                }
                else 
                {
                    if (id < listOfProjects.size()) 
                    {
                        return true;
                    }
                    else {
                        System.out.println("\n      Entered ID doesn't exit!\n");
                        System.err.println("   Press 'Enter' to continue");
                        return false;
                    }
                }
            case 3:
                if (getEmployee(id).getStatus()) 
                {
                    return true;
                }
                else {
                    System.out.println("\n      This employee is already fired!\n");
                    System.err.println("   Press 'Enter' to continue");
                    return false;
                }
            default:
                if (getProjects(id).getStatus()) 
                {
                    return true;
                }
                else {
                    System.out.println("\n      This project is already done!\n");
                    System.err.println("   Press 'Enter' to continue");
                    return false;
                }
        }
    }
    public boolean checkID(int n) {
        switch(n) {
            case 1:
                if (listOfDevelopers.isEmpty()) 
                {
                    System.out.println("\n      There aren't developers in company!\n");
                    return false;
                }
                else 
                {
                    if (listOfDevelopers.size() > 2) 
                    {
                        return true;
                    }
                    else 
                    {
                        System.out.println("\n      There aren't enough developers (min 3)!\n");
                        return false;
                    }
                }
            case 2:
                if (listOfEmployee.isEmpty()) 
                {
                    System.out.println("\n      There aren't employees in company!\n");
                    return false;
                }
                else 
                {
                    return true;
                }
            default:
                if (listOfProjects.isEmpty()) 
                {
                    System.out.println("\n      There aren't projects in company!\n");
                    return false;
                }
                else 
                {
                    return true;
                }
        }
    }
    public boolean checkResponsibles(int n) {
        switch (n) {
            case 1:
                if (listOfResourcesManagers.isEmpty()) 
                {
                    System.out.println("\n      There aren't resources managers in company!\n");
                    return false;
                }
                else 
                {
                    return true;
                }
            default:
                if (listOfProjects.isEmpty()) 
                {
                    System.out.println("\n      There aren't projects in company!\n");
                    return false;
                }
                else 
                {
                    return true;
                }
        }
    }

    public void relateToEmployee(Scanner input) {
        System.out.print("\n   Resouce Manager ID: ");
        int resouceManager = input.nextInt();

        System.out.println("\n   Enter Developers ID in order!\n");

        int n = checkNumberOfEnteredDevs(input, resouceManager);

        System.out.println("\n    Developer ID");
        System.out.println("   --------------");
        int projectID = getEmployee(resouceManager).getProjectID();
        for (int i = 0; i < n; i++) {
            System.out.print("    ID | ");
            int developer = input.nextInt();
            getEmployee(resouceManager).setDevelopers(developer);
            getEmployee(developer).setProjects(projectID);
            getEmployee(developer).setFlag("Developer", "work");
        }
        getProjects(projectID).setFlag("has devs");
        System.out.println("   --------------");
    }
    private int checkNumberOfEnteredDevs(Scanner input, int resouceManager) {
        
        int n = getEmployee(resouceManager).getDevs().size();
        switch (n) {
            case 0:
                boolean resultOfChecking;
                do {
                    System.out.print("   Enter min 3 or max 4 developers ID: ");
                    n = input.nextInt(); 
                    
                    resultOfChecking = (n > 2 && n < 5) ? false : true;

                } while (resultOfChecking);
                return n;
            case 3:
                System.out.println("   You can add only 1 developer!");
                n = 1;
                return n;
            case 4:
                System.out.println("   Number of devs is above the limit!\n   You cann't add devs to resouceManager");
                n = 0;
                return n;
            default:
                return 0;
        }
    }
    public void relateToProject(Scanner input) {
        System.out.print("\n   Project ID ");
        int project = input.nextInt();

        System.out.println("\n   Enter Developers ID in order!\n");
        System.out.print("   Enter number of devs: ");
        int n = input.nextInt();

        int developer;
        for (int i = 0; i < n; i++) {
            System.out.print("   ID: ");
            developer = input.nextInt();

            int resourceManager = getProjects(project).getResourceManager();
            getEmployee(resourceManager).setDevelopers(developer);
            getEmployee(developer).setProjects(project);
            getEmployee(developer).setFlag("Developer", "work");
        }
        getProjects(project).setFlag("has devs");
    }
    public void setProjectIdForEmployees() {
        int size = listOfProjects.size() - 1;

        int manager = listOfProjects.get(size).getManager();
        listOfEmployee.get(manager).setProjects(size);
        getEmployee(manager).setFlag("Manager", "increase");

        int resouceManager = listOfProjects.get(size).getResourceManager();
        listOfEmployee.get(resouceManager).setProjectID(size);
        getEmployee(resouceManager).setFlag("Resoures Manager", "work");
    }

                    // All Employees and Projects

    public void displayAllEmployees() {
        System.out.println("\n" + indentation + "             Managers");
        System.out.println(indentation + "----------------------------------");
        System.out.println(indentation + " ID  | Status   | Name ");
        System.out.println(indentation + " --------------------------------");
        for (Employee e : listOfManagers) 
        {
            if (e.getStatus())
                System.out.printf(indentation + "    %d   | Enrolled | %s\n", e.getId(), e.getName());
            else
                System.out.printf(indentation + "    %d   | Fired    | %s\n", e.getId(), e.getName());
        }
        System.out.println(indentation + "----------------------------------");

        System.out.println("\n" + indentation + "         Resource Managers");
        System.out.println(indentation + "----------------------------------");
        System.out.println(indentation + " ID  | Status   | Name ");
        System.out.println(indentation + " --------------------------------");
        for (Employee e : listOfResourcesManagers) 
        {
            if (e.getStatus())
                System.out.printf(indentation + "    %d   | Enrolled | %s\n", e.getId(), e.getName());
            else
                System.out.printf(indentation + "    %d   | Fired    | %s\n", e.getId(), e.getName());
        }
        System.out.println(indentation + "----------------------------------");

        System.out.println("\n" + indentation + "            Developers");
        System.out.println(indentation + "----------------------------------");
        System.out.println(indentation + " ID  | Status   | Name ");
        System.out.println(indentation + " --------------------------------");
        for (Employee e : listOfDevelopers) 
        {
            if (e.getStatus())
                System.out.printf(indentation + "    %d   | Enrolled | %s\n", e.getId(), e.getName());
            else
                System.out.printf(indentation + "    %d   | Fired    | %s\n", e.getId(), e.getName());
        }
        System.out.println(indentation + "----------------------------------\n");
    }
    public void displayAllProjects() {
        System.out.println("\n      Projects");
        System.out.println("   ------------------------------------");
        System.out.println("    ID  | Status   | Manager ID | Name ");
        System.out.println("   ------------------------------");
        for (Projects p : listOfProjects) 
        {
            if (p.getStatus()) 
                System.out.printf("    %d  | Enrolled | %d          | %s\n", p.getId(), p.getManager(), p.getName());
            else 
                System.out.printf("    %d  | Fired    | %d          | %s\n", p.getId(), p.getManager(), p.getName());
        }
        System.out.println("   ------------------------------------");
    }
    
    public void displayValiables(int n) {
        int valiableId;
        String valiableName;
        switch(n) {
            case 1:
                System.out.println("\n" + indentation + "       Valiable Managers");
                System.out.println(indentation + " ----------------------------");
                for (Employee e : listOfManagers) 
                {
                    if (e.getStatus() && !e.getFlag()) 
                    {
                        valiableId = e.getId();
                        valiableName = e.getName();
                        System.out.printf(indentation + "    %d | %s\n", valiableId, valiableName);
                    }
                }
                System.out.println(indentation + " ----------------------------"); 
                break;
            case 2: 
                System.out.println("\n" + indentation + "  Valiable Resource Managers");
                System.out.println(indentation + " ----------------------------");
                for (Employee e : listOfResourcesManagers) 
                {
                    if (e.getStatus() && !e.getFlag()) 
                    {
                        valiableId = e.getId();
                        valiableName = e.getName();
                        System.out.printf(indentation + "    %d | %s\n", valiableId, valiableName);
                    }
                    
                }
                System.out.println(indentation + " ----------------------------");
                break;
            case 5: 
                System.out.println("\n" + indentation + "  Valiable Resource Managers");
                System.out.println(indentation + " ----------------------------");
                for (Employee e : listOfResourcesManagers) 
                {
                    if (e.getStatus() && e.getFlag() && ((4 - e.getDevs().size()) > 0)) 
                    {
                        valiableId = e.getId();
                        valiableName = e.getName();
                        System.out.printf(indentation + "    %d | %s\n", valiableId, valiableName);
                    }
                    
                }
                System.out.println(indentation + " ----------------------------");
                break;
            case 3: 
                System.out.println("\n" + indentation + "      Valiable Developers");
                System.out.println(indentation + " ----------------------------");
                for (Employee e : listOfDevelopers) 
                {
                    if (e.getStatus() && !e.getFlag()) 
                    {
                        valiableId = e.getId();
                        valiableName = e.getName();
                        System.out.printf(indentation + "    %d | %s\n", valiableId, valiableName);
                    }
                }
                System.out.println(indentation + " ----------------------------"); 
                break;
            default:
                System.out.println("\n" + indentation + "       Valiable Projects");
                System.out.println(indentation + " ----------------------------");
                for (Projects p : listOfProjects) 
                {
                    if (p.getStatus() && !p.getFlag()) 
                    {
                        valiableId = p.getId();
                        valiableName = p.getName();
                        System.out.printf(indentation + "    %d | %s\n", valiableId, valiableName);
                    }
                    
                }
                System.out.println(indentation + " ----------------------------\n");
                break;
        }
    }
}
