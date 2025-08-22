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
        String conditionFour = "todo";
        String conditionFive = "deadline";
        String conditionSix = "event";

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

            } else if (input.startsWith(conditionFour)) {
                String[] parts = input.split(" ",2);
                Todo tobeAdded = new Todo(parts[1]);
                list.addTask(tobeAdded);

            } else if (input.startsWith(conditionFive)) {
                String[] firstSplit = input.split(" ", 2);

                String[] parts = firstSplit[1].split("/", 2);

                String task = parts[0].trim();
                String deadline = parts[1].trim();
                Deadline tobeAdded = new Deadline(task,deadline);
                list.addTask(tobeAdded);

            } else if (input.startsWith(conditionSix)) {
                String[] firstSplit = input.split(" ", 2);

                String[] parts = firstSplit[1].split("/", 2);

                String task = parts[0].trim();
                String duration = parts[1].trim();
                Event tobeAdded = new Event(task,duration);
                list.addTask(tobeAdded);

            }


            input = myObj.nextLine();
        }

        System.out.println(terminatingLine);
    }

}
