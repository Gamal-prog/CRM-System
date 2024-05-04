package AppLogic;
// Java's Packages
import java.util.Scanner;
// Custom Packages
//import CompanyStaff.*;

public class AppLogic {

    public static Scanner input = new Scanner(System.in);

    public void startApp() {
        String command;
        int countOfEnterPushing = 0;
        int countOfGarbagePushing = 0;
        
        // Manual 
        Description manual = new Description();

        boolean loop = true;
        do 
        {
            System.out.print("   ");
            command = input.nextLine();
            
            switch (command) {
                case "/create -e":
                    //Employee t = new Employee(input);
                    break;
                case "/create -p":
                   //Projects te = new Projects(input);
                    break;
                case "/create rs -e":
                    System.out.println("");
                    break;
                case "/create rs -p":
                    System.out.println("");
                    break;
                case "/display -e":
                    break;
                case "/display -p":
                    break;
                case "/display -e -p":
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
                    break;
                case "/status -p":
                    break;
                case "/status rm -e":
                    break;
                case "/status rm -p":
                    break;
                case "/status rm -e -p":
                    break;
                case "":
                    countOfEnterPushing++; 
                    if (countOfEnterPushing == 2) {
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
