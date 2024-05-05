package AppLogic;
// Java's Packages
import java.util.ArrayList;
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
                    // All Employees and Projects

    public void displayAllEmployees() {
        System.out.println("\n      Employees");
        System.out.println("   ------------------------------");
        System.out.println("    ID  | Status   | Name ");
        System.out.println("    ----------------------------");
        for (Employee e : listOfEmployee) {
            if (e.getStatus())
                System.out.printf("    %d   | Enrolled | %s\n", e.getId(), e.getName());
            else
                System.out.printf("    %d   | Fired    | %s\n", e.getId(), e.getName());
        }
        System.out.println("   ------------------------------");
    }
    public void displayAllProjects() {
        System.out.println("\n      Projects");
        System.out.println("   ------------------------------------");
        System.out.println("    ID  | Status   | Manager ID | Name ");
        System.out.println("   ------------------------------");
        for (Projects e : listOfProjects) {
            if (e.getStatus()) 
                System.out.printf("    %d  | Enrolled | %d          | %s\n", e.getId(), e.getManager(), e.getName());
            else 
                System.out.printf("    %d  | Fired    | %d          | %s\n", e.getId(), e.getManager(), e.getName());
        }
        System.out.println("   ------------------------------------");
    }
    
    public void displayValiables() {
        System.out.println("\n          Valiable Managers");
        System.out.println("   -----------------------------");
        int valiableId;
        String valiableName;
        for (Employee e : listOfManagers) {
            if (e.getStatus()) {
                valiableId = e.getId();
                valiableName = e.getName();
                System.out.printf("    %d | %s\n", valiableId, valiableName);
            }
        }
        System.out.println("   -----------------------------"); 

        System.out.println("\n    Valiable Resource Managers");
        System.out.println("   -----------------------------");
        for (Employee e : listOfResourcesManagers) {
            if (e.getStatus()) {
                valiableId = e.getId();
                valiableName = e.getName();
                System.out.printf("    %d | %s\n", valiableId, valiableName);
            }
            
        }
        System.out.println("   -----------------------------");
    }
}
