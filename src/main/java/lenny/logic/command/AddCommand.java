package lenny.logic.command;

import lenny.logic.storage.Storage;
import lenny.logic.task.Task;
import lenny.logic.task.TaskList;
import lenny.logic.ui.Ui;

/**
 * Represents a command that adds a new task to the task list.
 * When executed, this command appends the given task, updates
 * the persistent storage, and returns a confirmation message.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Creates an {@code AddCommand} with the specified task.
     *
     * @param task The task to be added to the task list.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the add command by appending the task to the task list,
     * saving the updated task list to storage, and returning a confirmation
     * message that includes the added task and the updated task count.
     *
     * @param tasks   The TaskList where the task will be added.
     * @param storage The Storage responsible for persisting changes.
     * @param ui      The  Ui component for user interactions
     * @return A confirmation message showing the added task and the updated
     *         number of tasks in the list.
     */
    @Override
    public String execute(TaskList tasks, Storage storage, Ui ui) {
        tasks.add(task);
        storage.save(tasks);
        return "Got it. I've added this task:\n" + task + "\n" + "Now you have " + tasks.size() + " tasks in the list.";
    }
}
