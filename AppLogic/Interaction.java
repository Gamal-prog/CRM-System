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
    public void setEmployee(Employee employee) {  //del
        listOfEmployee.add(employee);
    }

    public void setEmployees(Employee employee) {
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
    /* //del
    public void setDeveloper(Employee employee) {
        listOfDevelopers.add(employee);
    }
    public void setManager(Employee employee) {
        listOfManagers.add(employee);
    }
    public void setResourcesManager(Employee employee) {
        listOfResourcesManagers.add(employee);
    }
    */

    public void setProjects(Projects project) {
        listOfProjects.add(project);
    }
    /* //del
    public void setEmployeeAndProject(Employee employee, 
                                        Projects project
    ) {
        listOfEmployee.add(employee);
        listOfProjects.add(project);
    }
    */

    // Getters 
    public Employee getEmployee(int index) { //del
        return listOfEmployee.get(index);
    }
    public Employee getDeveloper(int index) {
        return listOfDevelopers.get(index);
    }
    public Employee getManager(int index) {
        return listOfManagers.get(index);
    }
    public Employee getResourcesManager(int index) {
        return listOfResourcesManagers.get(index);
    }

    public Projects getProjects(int index) {
        return listOfProjects.get(index);
    }
    public ArrayList<Employee> getList() {
        return listOfEmployee;
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

    public void displayM() {
        System.out.println("\n          Valiable Managers");
        System.out.println("   -----------------------------");
        int valiableId;
        String valiableName;
        for (Employee e : listOfManagers) {
            valiableId = e.getId();
            valiableName = e.getName();
            System.out.printf("    %d | %s\n", valiableId, valiableName);
        }
        System.out.println("   -----------------------------"); 
    }
    public void displayR() {
        System.out.println("\n    Valiable Resource Managers");
        System.out.println("   -----------------------------");
        int valiableId;
        String valiableName;
        for (Employee e : listOfResourcesManagers) {
            valiableId = e.getId();
            valiableName = e.getName();
            System.out.printf("    %d | %s\n", valiableId, valiableName);
        }
        System.out.println("   -----------------------------");
    }

                    // All Employees and Projects

    public void displayAllEmployees() {

    }
    public void displayAllProjects() {

    }
    // All Employees and Projects
    // !?
}
