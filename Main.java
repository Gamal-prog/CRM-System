// Custom Packages
import InterfaceDesign.*;
import AppLogic.*;

public class Main 
{
    public static void main(String[] args) {
        // Welcome 
		WelcomeMessage startMessage = new WelcomeMessage();
        startMessage.sayHi();

        // Instructions
        Description details = new Description();
        details.userNotation(1);
        details.separaterLine();

        // App Logic
        AppLogic test = new AppLogic();
        test.startApp();

        // Bye
        details.separaterLine();
        ByeMessage stopMessage = new ByeMessage();
        stopMessage.sayBye();

        // Reference
        details.userNotation(2);
	}    
}



