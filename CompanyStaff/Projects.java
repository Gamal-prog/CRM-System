package CompanyStaff;

import java.util.Scanner;

public class Projects {
    private String name;
    private String description;
    private boolean status;
    private String manager;
    private String resourceManager;
    // For Use Global Variable input
    private Scanner input;

    public Projects(Scanner scanner) {
        this.input = scanner;
        this.status = true;
        this.name = input.nextLine();
        this.description = input.nextLine();
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
    public String getManager() {
        return manager;
    }
    public String getResourceManager() {
        return resourceManager;
    }
}
