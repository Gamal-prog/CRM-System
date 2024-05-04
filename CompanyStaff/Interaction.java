package CompanyStaff;

import java.util.ArrayList;

public class Interaction {
    private ArrayList<Object> listOfProjects;
    private ArrayList<Object> listOfEmployee;

    public Interaction() {
        this.listOfEmployee = new ArrayList<Object>();
        this.listOfProjects = new ArrayList<Object>();
    }

    // Setters
    public void setEmployee(Object employee) {
        listOfEmployee.add(employee);
    }
    public void setProjects(Object project) {
        listOfProjects.add(project);
    }
    public void setEmployeeAndProject(Object employee, 
                                        Object project
    ) {
        listOfEmployee.add(employee);
        listOfProjects.add(project);
    }
}
