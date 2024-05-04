package AppLogic;
  
public class Description {
                // Complete Guide

    private String[] listOfCommands = { 
        "\n                                Commands",
        "   -------------------------------------------------------------",
        "    /create  | start a new project",
        "             | hire an employee",
        "             | assign an employee to a resource manager",
        "             | assign an employee to a project",
        "    ---------|-------------------------------------------------",
        "    /display | display information about projects and employees",
        "    ---------|-------------------------------------------------",
        "    /exit    | terminate the program",
        "    ---------|-------------------------------------------------",
        "    /help    | description of commands",
        "    ---------|-------------------------------------------------",
        "    /status  | fire an employee",
        "             | end a project",
        "             | remove an employee from a project",
        "             | know status of a project",
        "             | know status of a employee",
        "   -------------------------------------------------------------\n",
    };
    private String[] listOfExtensions = {
        "\n                                Extensions",
        "         --------------------------------------------------",
        "          /create  | -e, -p, rs -e, rs -p",
        "          ---------|--------------------------------------",
        "          /display | -e, -p, -e -p",
        "          ---------|--------------------------------------",
        "          /exit    | none",
        "          ---------|--------------------------------------",
        "          /help    | tutorial, extensions, commands",
        "          ---------|--------------------------------------",
        "          /status  | -e, -p, -e -p, rm -e, rm -p, rm -e -p",
        "         --------------------------------------------------\n"
    };
    private String[] tutorial = {
        "\n   Tutorial:",
        "",
        "\n"
    };
                // Notation
    
    // Functionality
    public void displayCommands() {
        for (String line : listOfCommands) {
            System.out.println("   " + line);
        }
    }
    public void displayExtensions() {
        for (String line : listOfExtensions) { 
            System.out.println("   " + line);
        }
    }
    public void displayTutorial() {
        for (String line : tutorial) {
            System.out.println("   " + line);
        }
    }
    public void displayManual() {
        for (String line : listOfCommands) {
            System.out.println("   " + line);
        }
        for (String line : listOfExtensions) { 
            System.out.println("   " + line);
        }
        for (String line : tutorial) {
            System.out.println("   " + line);
        }
    }

    // Description 
    public void separaterLine() {
        System.out.println("\n  ----------------------------------------------------------------------\n");
    }
    public void userNotation(int n) {
        switch (n) {
            case 1:
                System.out.println("\n     This CRM system helps you to manage human sources of your company,\n   and work easily keeping all under control.");
                System.out.println("\n     Enter command '/help' to get a complete guide to using the\n   CRM system.");
                break;
            case 2:
                System.out.println("\n   P.S. The World has ended. Beware of nuclear Fallout ;D\n");
        }
    }
}
