package lenny.task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public TaskList(List<Task> initial) {
        this.list = new ArrayList<>(initial);
    }

    public ArrayList<Task> asList() {
        return list;
    }

    public int size() {
        return list.size();
    }

    public Task get(int oneBasedIndex) {
        return list.get(oneBasedIndex - 1);
    }

    public void add(Task task) {
        list.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + list.size() + " tasks in the list.");
    }

    public void delete(int oneBasedIndex) {
        Task removed = list.remove(oneBasedIndex - 1);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removed);
        System.out.println("Now you have " + list.size() + " tasks in the list.");
    }

    public void mark(int oneBasedIndex) {
        Task t = list.get(oneBasedIndex - 1);
        t.mark();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + t);
    }

    public void unmark(int oneBasedIndex) {
        Task t = list.get(oneBasedIndex - 1);
        t.unmark();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + t);
    }

    public void show() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}