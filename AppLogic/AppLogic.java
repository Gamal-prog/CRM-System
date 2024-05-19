package AppLogic;
// Java's Packages
import java.util.Scanner;
// Custom Packages
import CompanyStaff.*;

public class AppLogic {

    public static Scanner input = new Scanner(System.in);

    public void startApp() {
        String command;
        int countOfEnterPushing = 0;
        int countOfGarbagePushing = 0;
        
        Description manual = new Description(); // Manual 
        Interaction conection = new Interaction(); // Conection 

        boolean loop = true;
        do 
        {
            System.out.print("   ");
            command = input.nextLine();
            
            switch (command) {
                case "/create -e": 
                    conection.setEmployee(new Employee(input));
                    countOfEnterPushing = 0;
                    break;
                case "/create -p": 
                    if(conection.checkResponsibles()) 
                    {
                        conection.displayValiables(1);
                        conection.displayValiables(2);
                        conection.setProjects(new Projects(input));
                        conection.setProjectIdForEmployees();
                    }
                    countOfEnterPushing = 0;
                    break;
                case "/create rs -e":
                    if (conection.checkResponsibles(1)) 
                        if (conection.checkID(1)) 
                        {
                            conection.displayValiables(5);
                            conection.displayValiables(3);
                            conection.relateToEmployee(input);
                        }
                    countOfEnterPushing = 0;
                    break;
                case "/create rs -p":
                    if (conection.checkResponsibles(2))
                        if (conection.checkID(1)) 
                        {
                            conection.displayValiables(4);
                            conection.displayValiables(3);
                            conection.relateToProject(input);
                        }
                    countOfEnterPushing = 0;
                    break;
                case "/display -e":
                    if (conection.checkID(2)) 
                        conection.displayAllEmployees();
                    break;
                case "/display -p":
                    if (conection.checkID(3))
                        conection.displayAllProjects();
                    break;
                case "/exit": 
                case "End of the World":
                    loop = false;
                    break;
                case "/help": 
                    manual.displayManual();
                    break;
                case "/help commands": 
                    manual.displayCommands();
                    break;
                case "/help tutorial": 
                    manual.displayTutorial();
                    break;
                case "/help extensions": 
                    manual.displayExtensions();
                    break;
                case "/status -e":
                    System.out.print("\n      Employee ID: ");
                    int specificEmployee = input.nextInt();
                    if (conection.checkID(specificEmployee, 1)) 
                        conection.getEmployee(specificEmployee).displayEmployee();
                        
                    countOfEnterPushing = 0; 
                    break;
                case "/status -p": 
                    System.out.print("\n      Project ID: ");
                    int specificProject = input.nextInt();
                    if (conection.checkID(specificProject, 2))
                        conection.getProjects(specificProject).displayProject();
                    countOfEnterPushing = 0;
                    break;
                case "/status rm -e": 
                    System.out.print("\n      Employee ID: ");
                    specificEmployee = input.nextInt();
                    if (conection.cID(specificEmployee)) 
                        conection.removeEmplyee(input, specificEmployee, "fire", -1);
                    
                    countOfEnterPushing = 0;
                    break;
                case "/status rm -p": 
                    System.out.print("\n      Project ID: ");
                    specificProject = input.nextInt();
                    conection.finishProject(specificProject);
                    
                    countOfEnterPushing = 0;
                    break;
                case "/status rm -e -p":
                    System.out.print("\n      Project ID: ");
                    specificProject = input.nextInt();
                    conection.removeEmplyee(input, specificProject);

                    countOfEnterPushing = 0;
                    break;
                case "": 
                    if (countOfEnterPushing == 3) 
                    {
                        System.out.println("\n   Does not increase the working area, please!\n");
                        countOfEnterPushing = 0; 
                    }
                    else 
                    {
                        countOfEnterPushing++; 
                    }
                    break;
                default:
                    if (countOfGarbagePushing == 2) 
                    {
                        System.out.println("\n   Does not garbage the working area, please!\n");
                        countOfGarbagePushing = 0;
                    }  
                    else 
                    {
                        countOfGarbagePushing++;
                    }
                    break;
            }
        }
        while (loop);

        input.close();
    }
}
