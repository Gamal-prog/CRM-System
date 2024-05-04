package AppLogic;
// Java's Packages
import java.util.ArrayList;
// Custom Packages
import CompanyStaff.*;

public class Interaction {
    private ArrayList<Employee> listOfEmployee;
    private ArrayList<Projects> listOfProjects;
    
    public Interaction() {
        this.listOfEmployee = new ArrayList<Employee>();
        this.listOfProjects = new ArrayList<Projects>();
    }

    // Setters
    public void setEmployee(Employee employee) {
        listOfEmployee.add(employee);
    }
    public void setProjects(Projects project) {
        listOfProjects.add(project);
    }
    public void setEmployeeAndProject(Employee employee, 
                                        Projects project
    ) {
        listOfEmployee.add(employee);
        listOfProjects.add(project);
    }

    // Getters 
    public Employee getEmployee(int index) {
        return listOfEmployee.get(index);
    }
    public Projects getProjects(int index) {
        return listOfProjects.get(index);
    }

                    // All Employees and Projects

    public void displayAllEmployees() {

    }
    public void displayAllProjects() {

    }
    // All Employees and Projects
    // !?
}
