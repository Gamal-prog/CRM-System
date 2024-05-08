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
                case "/create -e": // done
                    conection.setEmployee(new Employee(input));
                    break;
                case "/create -p": // done
                    if(conection.checkResponsibles()) 
                    {
                        conection.displayValiables(2);
                        conection.displayValiables(3);
                        conection.setProjects(new Projects(input));
                        conection.setProjectIdForEmployees();
                    }
                    break;
                case "/create rs -e":
                    conection.displayValiables(1);
                    conection.displayValiables(3);
                    conection.relateToEmployee(input);
                    //attache employee to employee
                    break;
                case "/create rs -p":
                    conection.displayValiables(1);
                    conection.displayValiables(4);
                    //attache employee to project
                    break;
                case "/display -e": // done
                    conection.displayAllEmployees();
                    break;
                case "/display -p": // done
                    conection.displayAllProjects();
                    break;
                case "/exit": // done
                case "End of the World":
                    loop = false;
                    break;
                case "/help": // done
                    manual.displayManual();
                    break;
                case "/help commands": // done
                    manual.displayCommands();
                    break;
                case "/help tutorial": // done
                    manual.displayTutorial();
                    break;
                case "/help extensions": // done
                    manual.displayExtensions();
                    break;
                case "/status -e":
                    System.out.print("\n      Employee ID: ");
                    int specificEmployee = input.nextInt();
                    conection.getEmployee(specificEmployee).displayEmployee();
                    // Условие для проверки введенное число не больше или равно ID
                    break;
                case "/status -p": 
                    System.out.print("\n      Project ID: ");
                    int specificProject = input.nextInt();
                    // check ID
                    conection.getProjects(specificProject).displayProject();
                    break;
                case "/status rm -e": //done
                    System.out.print("\n      Employee ID: ");
                    specificEmployee = input.nextInt();
                    conection.getEmployee(specificEmployee).fireOfEmployee();
                    break;
                case "/status rm -p": //done
                    System.out.print("\n      Project ID: ");
                    specificProject = input.nextInt();
                    conection.getProjects(specificProject).finishProject();
                    break;
                case "/status rm -e -p":
                    // remove employee from project
                    break;
                case "": // done
                    countOfEnterPushing++; 
                    if (countOfEnterPushing == 3) 
                    {
                        System.out.println("\n   Does not increase the working area, please!\n");
                        countOfEnterPushing = 0; 
                    }
                    break;
                default:
                    countOfGarbagePushing++;
                    if (countOfGarbagePushing == 2) 
                    {
                        System.out.println("\n   Does not garbage the working area, please!\n");
                        countOfGarbagePushing = 0;
                    } 
                    countOfEnterPushing = 0; 
            }
        }
        while (loop);

        input.close();
    }
}
