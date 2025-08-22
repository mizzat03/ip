import java.util.ArrayList;
import java.util.Collections;

public class listOfTasks {
    ArrayList<Task> list;

    public listOfTasks() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public void addTask(Task task) {
        list.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.toString());
        System.out.println("Now you have " + list.size() + " tasks in the list.");
    }

    public void markTask(int i) {
        Task t = list.get(i - 1);
        t.mark();
        System.out.println("Nice! I've marked this task as done:\n" + list.get(i - 1).toString());
    }

    public void unmarkTask(int i) {
        Task t = list.get(i - 1);
        t.unmark();
        System.out.println("OK, I've marked this task as not done yet:\n" + list.get(i - 1).toString());
    }

    public void display() {
        System.out.println( "Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).toString());

        }
    }

    public void deleteTask(int i) {
        String deletedTask = list.get(i - 1).toString();
        list.remove(i-1);
        System.out.println("Noted. I've removed this task: \n" + "  " + deletedTask + "\n" +  "Now you have " +list.size()+ " tasks in the list.");
    }
}
