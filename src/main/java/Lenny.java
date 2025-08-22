import java.util.Scanner;


public class Lenny {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); //read input
        listOfTasks list = new listOfTasks(); //listOfTasks object to store the array of String tasks

        String terminatingCondition = "bye";
        String terminatingLine = "Bye. Hope to see you again soon!";


        String conditionOne = "list";
        String conditionTwo = "mark";
        String conditionThree = "unmark";

        String introline = "Hello! I'm Lenny!";
        String secondline = "What can I do for you?";



        System.out.println(introline + "\n" + secondline);

        String input = myObj.nextLine(); //asking for input

        while (!input.equals(terminatingCondition)) {
            if (input.startsWith(conditionOne)) {
                list.display();
            } else if (input.startsWith(conditionTwo)) {
                String[] parts = input.split(" ");
                int i = Integer.parseInt(parts[1]);
                list.markTask(i);


            } else if (input.startsWith(conditionThree)) {
                String[] parts = input.split(" ");
                int i = Integer.parseInt(parts[1]);
                list.unmarkTask(i);

            } else {
                list.addTask(input);
            }
            input = myObj.nextLine();
        }

        System.out.println(terminatingLine);
    }

}
