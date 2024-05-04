package InterfaceDesign;

public class ByeMessage 
{
    private String[] byeArt = {
        "     /$$$$$$  ",
        "    /$$__  $$ ",
        "   | $$  \\ $$ /$    $$  /$$$$$$ ",
        "   | $$$$$$$ |$$    $$ /$$__  $$",
        "   | $$__  $$|$$    $$| $$$$$$$$",
        "   | $$  \\ $$|$$    $$| $$_____/",
        "   |  $$$$$$ | $$$$$$$|  $$$$$$$",
        "    \\______/ \\_____ $$ \\_______/",
        "             /$$   \\$$",
        "             | $$$$$$/",
        "             \\______/"
    };

    public void sayBye() {
        for (String line : byeArt) {
            System.out.println(line);
        }
    }
}
