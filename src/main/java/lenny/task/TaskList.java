package lenny.task;

import java.util.ArrayList;

/**
 * Represents a list of tasks with operations to add, remove, and modify tasks.
 */
public class TaskList {
    private final ArrayList<Task> list;

    /**
     * Creates an empty TaskList.
     */
    public TaskList() {
        this.list = new ArrayList<>();
    }

    /**
     * Creates a TaskList with existing tasks.
     *
     * @param initial Existing list of tasks.
     */
    public TaskList(ArrayList<Task> initial) {
        this.list = new ArrayList<>(initial);
    }

    /**
     * Returns the list of tasks.
     *
     * @return All tasks in this TaskList.
     */
    public ArrayList<Task> asList() {
        return list;
    }

    public int size() {
        return list.size();
    }

    /**
     * Retrieves the task at the given index (1-based).
     *
     * @param oneBasedIndex Index of the task to retrieve.
     * @return The task at the specified index.
     */
    public Task get(int oneBasedIndex) {
        return list.get(oneBasedIndex - 1);
    }

    /**
     * Adds a task to the list.
     *
     * @param task Task to be added.
     */
    public void add(Task task) {
        list.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + list.size() + " tasks in the list.");
    }

    /**
     * Deletes the task at the given index (1-based).
     *
     * @param oneBasedIndex Index of the task to remove (1-based).
     *
     */
    public void delete(int oneBasedIndex) {
        Task removed = list.remove(oneBasedIndex - 1);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removed);
        System.out.println("Now you have " + list.size() + " tasks in the list.");
    }

    /**
     * Marks the task at the given index (1-based).
     *
     * @param oneBasedIndex Index of the task to remove (1-based).
     *
     */
    public void mark(int oneBasedIndex) {
        Task t = list.get(oneBasedIndex - 1);
        t.mark();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + t);
    }

    /**
     * Unmarks the task at the given index (1-based).
     *
     * @param oneBasedIndex Index of the task to remove (1-based).
     *
     */
    public void unmark(int oneBasedIndex) {
        Task t = list.get(oneBasedIndex - 1);
        t.unmark();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + t);
    }

    /**
     * Prints the current tasks in the list.
     *
     */
    public void show() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}