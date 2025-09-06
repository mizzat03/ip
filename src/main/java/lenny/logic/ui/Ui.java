package lenny.logic.ui;

import java.util.Scanner;

/**
 * Handles all interactions with the user,
 * including displaying messages and reading input.
 */

public class Ui {
    private final Scanner in = new Scanner(System.in);

    /**
     * Displays the welcome message when the program starts.
     */
    public void showWelcome() {
        System.out.println("Hello! I'm Lenny!");
        System.out.println("What can I do for you?");
    }

    /**
     * Reads the next command from the user.
     *
     * @return The full user input as a string.
     */
    public String readCommand() {
        return in.nextLine();
    }

    /**
     * Displays an error message.
     *
     * @param message Error details to show.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Displays a command response
     */
    public void showResponse(String response) {
        System.out.println(response);
    }

    /**
     * Displays a bye message.
     */
    public void showBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
