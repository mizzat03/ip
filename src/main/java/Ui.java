import java.util.Scanner;

public class Ui {
    private final Scanner in = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Hello! I'm Lenny!");
        System.out.println("What can I do for you?");
    }

    public String readCommand() {
        return in.nextLine();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showLoadingError() {
        System.out.println("OOPS!!! Problem preparing data storage.");
    }

    public void showBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}