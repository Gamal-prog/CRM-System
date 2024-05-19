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
    // Final Attributes
    private final int MAX_NUMBER_OF_DEVELOPERS = 4;
    private final String indentation = "                     ";
    private final String second_indentation = "                            ";

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

    public boolean checkResponsibles() { 
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

        System.out.println("\n" + second_indentation + "    Developer ID");
        System.out.println(second_indentation + "   --------------");
        int projectID = getEmployee(resouceManager).getProjectID();
        int developer;
        for (int i = 0; i < n; i++) {
            System.out.print(second_indentation + "    ID | ");
            developer = input.nextInt();
            getEmployee(resouceManager).setDevelopers(developer);
            getEmployee(developer).setProjects(projectID);
            getEmployee(developer).setFlag("Developer", "work");
        }

        // update num of devs for RS 
        n = getEmployee(resouceManager).getDevs().size();
        boolean projectFull = (n == MAX_NUMBER_OF_DEVELOPERS) ? true : false;
        if (projectFull) 
        {
            getProjects(projectID).setFlag("has devs");
        }
        System.out.println(second_indentation + "   --------------");
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
        System.out.print("\n   Project ID: ");
        int project = input.nextInt();

        System.out.println("\n   Enter Developers ID in order!\n");
        
        int resourceManager = getProjects(project).getResourceManager();
        int n = checkNumberOfEnteredDevs(input, resourceManager);

        System.out.println("\n" + second_indentation +"    Developer ID");
        System.out.println(second_indentation + "   --------------");
        int developer;
        for (int i = 0; i < n; i++) {
            System.out.print(second_indentation +"    ID | ");
            developer = input.nextInt();

            getEmployee(resourceManager).setDevelopers(developer);
            getEmployee(developer).setProjects(project);
            getEmployee(developer).setFlag("Developer", "work");
        }

        // update num of devs for RS 
        n = getEmployee(resourceManager).getDevs().size();
        boolean projectFull = (n == MAX_NUMBER_OF_DEVELOPERS) ? true : false;
        if (projectFull) 
        {
            getProjects(project).setFlag("has devs");
        }
        System.out.println(second_indentation + "   --------------");
    }
    public void setProjectIdForEmployees() {
        int project = listOfProjects.size() - 1;
        
        int manager = listOfProjects.get(project).getManager();
        listOfEmployee.get(manager).setProjects(project);
        getEmployee(manager).setFlag("Manager", "increase");

        int resouceManager = listOfProjects.get(project).getResourceManager();
        listOfEmployee.get(resouceManager).setProjectID(project);
        getEmployee(resouceManager).setFlag("Resoures Manager", "work");
    }
    public void finishProject(int specificProject) {
        getProjects(specificProject).finishProject();

        int resouceManager = getProjects(specificProject).getResourceManager();
        getEmployee(resouceManager).setFlag("Resoures Manager", "free");
        for (int d : getEmployee(resouceManager).getDevs()) 
        {
            getEmployee(d).setFlag("Developer", "free");
        }
        getEmployee(resouceManager).getDevs().clear(); 

        int manager = getProjects(specificProject).getManager();
        getEmployee(manager).setFlag("Manager", "decrease");
    }
    public void removeEmplyee(Scanner input, int specificEmployee, String action, int specificProject) { 
        int actialProject;
        int resourceManager;
        String position = getEmployee(specificEmployee).getPosition();
        char n = position.charAt(0);

        switch (n) {
            case 'M':
                System.out.println("\n   Enter a manager ID who can lead the project in place the old one!\n");
                System.out.print("   ID: ");
                int manager = input.nextInt();

                    switch (action) {
                        case "remove":
                            
                            getProjects(specificProject).setManager(manager); 
                            getEmployee(manager).setFlag("Manager", "increase");
                            getEmployee(specificEmployee).setFlag("Manager", "decrease");
                            break;
                        case "fire":
                            for (int p : getEmployee(specificEmployee).getProjects()) 
                            {
                                getProjects(p).setManager(manager);
                                getEmployee(manager).setFlag("Manager", "increase");
                            }
                            getEmployee(specificEmployee).setFlag("Manager", "reset");
                            getEmployee(specificEmployee).fireOfEmployee();
                            break;
                        default:
                            break;
                    }
                break;
            case 'R':
                System.out.println("\n   Enter a resource manager ID who can lead the project in place the old one!\n");
                System.out.print("   ID: ");
                resourceManager = input.nextInt();

                    for (int d : getEmployee(specificEmployee).getDevs()) {
                        getEmployee(resourceManager).setDevelopers(d);
                    } // Attache devs to new RS

                    // Remove old RS and attache new RS
                    actialProject = getEmployee(specificEmployee).getProjectID();
                    getProjects(actialProject).setResourceManager(resourceManager);
                    getEmployee(resourceManager).setProjectID(actialProject);
                    getEmployee(resourceManager).setFlag("Resoures Manager", "work");
                    switch (action) {
                        case "remove":
                            getEmployee(specificEmployee).setFlag("Resoures Manager", "free");
                            break;
                        case "fire":
                            getEmployee(specificEmployee).setFlag("Resoures Manager", "free");
                            getEmployee(specificEmployee).fireOfEmployee();
                            break;
                        default:
                            break;
                    }
                    getEmployee(specificEmployee).setProjectID(-1);
                    getEmployee(specificEmployee).getDevs().clear();
                
                break;
            case 'D': 
                switch (action) 
                {
                    case "remove":
                        getEmployee(specificEmployee).setFlag("Developer", "free");
                        actialProject = getEmployee(specificEmployee).getProjects().size() - 1;
                        resourceManager = getProjects(actialProject).getResourceManager();

                        int developer = getEmployee(resourceManager).getDevs().indexOf(specificEmployee);
                        getEmployee(resourceManager).getDevs().remove(developer);
                        getProjects(actialProject).setFlag("has not devs");
                        break;
                    default:
                        break;
                }
            default:
                break;
        }
    }
    public void removeEmplyee(Scanner input, int specificProject) {
        if (getProjects(specificProject).getStatus()) 
        {
            System.out.print("\n   Enter the employee ID: ");
            int specificEmployee = input.nextInt();
            
            removeEmplyee(input, specificEmployee, "remove", specificProject);
        }
        else 
        {
            System.out.println("\n   The project is already done!");
        }
    }
    public boolean cID(int specificEmployee) { 

        if (getEmployee(specificEmployee).getStatus()) 
        {
            String position = getEmployee(specificEmployee).getPosition();
            char n = position.charAt(0);

            switch (n) { 
                case 'M':
                    if (getEmployee(specificEmployee).getNumberOfActualProjects() > 0) 
                    {
                        return true;
                    }
                    else if (getEmployee(specificEmployee).getNumberOfActualProjects() == 0) 
                    {
                        getEmployee(specificEmployee).fireOfEmployee();
                        return false;
                    }
                case 'R':
                    if (getEmployee(specificEmployee).getFlag())
                    {
                        return true;
                    }
                    else 
                    {
                        getEmployee(specificEmployee).fireOfEmployee();
                        return false;
                    }
                case 'D':
                    getEmployee(specificEmployee).setFlag("Developer", "free");
                    getEmployee(specificEmployee).fireOfEmployee();

                    int actialProject = getEmployee(specificEmployee).getProjects().size() - 1;
                    int resourceManager = getProjects(actialProject).getResourceManager();
                
                    int developer = getEmployee(resourceManager).getDevs().indexOf(specificEmployee);
                    getEmployee(resourceManager).getDevs().remove(developer);
                    getProjects(actialProject).setFlag("has not devs");
                    return false;
                default:
                    return false;
            }
        }
        else 
        {
            System.out.println("\n      This employee is already fired!\n");
            System.err.println("   Press 'Enter' to continue");
            return false;
        }
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
                int size;
                for (Projects p : listOfProjects) 
                {
                    size = getEmployee(p.getResourceManager()).getDevs().size();
                    if (p.getStatus() && !p.getFlag() && ((4 - size) > 0)) 
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
