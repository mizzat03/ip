import java.util.Scanner;



public class Lenny {
    public static void main (String[] args) throws LennyExceptions {
        Scanner myObj = new Scanner(System.in); //read input
        listOfTasks list = new listOfTasks(); //listOfTasks object to store the array of String tasks

        String terminatingCondition = "bye";
        String terminatingLine = "Bye. Hope to see you again soon!";



        String introline = "Hello! I'm Lenny!";
        String secondline = "What can I do for you?";


        System.out.println(introline + "\n" + secondline);

        String input = myObj.nextLine(); //asking for input

        while (!input.equals(terminatingCondition)) {
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            switch (command) {
                case "list":
                    list.display();
                    break;

                case "mark":
                    int i = Integer.parseInt(parts[1]);
                    list.markTask(i);
                    break;

                case "unmark":
                    int j = Integer.parseInt(parts[1]);
                    list.unmarkTask(j);
                    break;

                case "todo":
                    if (parts.length < 2 || parts[1].trim().isEmpty()) {
                        throw new LennyExceptions("OOPS!!! The description of a todo cannot be empty.");
                    }
                    Todo todoTask = new Todo(parts[1]);
                    list.addTask(todoTask);
                    break;

                case "deadline":
                    if (parts.length < 2 || !parts[1].contains("/by")) {
                        throw new LennyExceptions("OOPS!!! The description of a deadline must include /by.");
                    }

                    String[] split = parts[1].split("/", 2);
                    String deadlineName = split[0].trim();
                    String deadline = split[1].trim();
                    Deadline deadlineTask = new Deadline(deadlineName, deadline);
                    list.addTask(deadlineTask);
                    break;

                case "event":
                    if (parts.length < 2 || !parts[1].contains("/from") || !parts[1].contains("/to")) {
                        throw new LennyExceptions("OOPS!!! The description of an event must include /from and /to.");
                    }
                    String[] eventSplit = parts[1].split("/", 2);

                    String eventName = eventSplit[0].trim();
                    String duration = eventSplit[1].trim();
                    Event eventTask = new Event(eventName, duration);
                    list.addTask(eventTask);
                    break;


                default:
                    throw new LennyExceptions("OOPS!!! I'm sorry, but I don't know what that means :-(");

            }
            input = myObj.nextLine();
        }
        System.out.println(terminatingLine);
    }
}
