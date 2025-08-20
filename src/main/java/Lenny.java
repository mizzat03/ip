import java.util.Scanner;

public class Lenny {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); //read input

        String terminatingLine = "Bye. Hope to see you again soon!";
        String terminatingCondition = "bye";

        String firstline = "Hello! I'm Lenny!";
        String secondline = "What can I do for you?";

        System.out.println(firstline + "\n" + secondline);

        String input = myObj.nextLine();

        while (!input.equals(terminatingCondition)) {
            System.out.println(input);
            input = myObj.nextLine();
        }

        System.out.println(terminatingLine);
    }

}
