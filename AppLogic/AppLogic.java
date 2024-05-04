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
                case "/create -p":
                    break;
                case "/create rs -e":
                    break;
                case "/create rs -p":
                    break;
                case "/display -e":
                    break;
                case "/display -p":
                    break;
                case "/display -e -p":
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
                    System.out.print("\n      Employee Id: ");
                    int test = input.nextInt();
                    conection.getEmployee(test).displayEmployee();
                    // Условие для проверки введенное число не больше или равно ID
                    break;
                case "/status -p":
                    break;
                case "/status rm -e":
                    break;
                case "/status rm -p":
                    break;
                case "/status rm -e -p":
                    break;
                case "": // done
                    countOfEnterPushing++; 
                    if (countOfEnterPushing == 3) {
                        System.out.println("\n   Does not increase the working area, please!\n");
                        countOfEnterPushing = 0; 
                    }
                    break;
                default:
                    countOfGarbagePushing++;
                    if (countOfGarbagePushing == 2) {
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
