package lenny.logic.command;

import lenny.logic.storage.Storage;
import lenny.logic.task.TaskList;
import lenny.logic.ui.Ui;

/**
 * Represents a command that marks a task in the task list as done.
 * This command updates both the in-memory task list and the persistent storage.
 */
public class MarkCommand extends Command {
    private final int index;

    /**
     * Creates an UnmarkCommand with the specified task index.
     *
     * @param i The index of the task to be unmarked, based on the task list.
     */
    public MarkCommand(int i) {
        this.index = i;
    }

    /**
     * Executes the mark command by setting the specified task as done,
     * saving the updated task list to storage, and returning a confirmation message.
     *
     * @param tasks   The TaskList containing the tasks.
     * @param storage The Storage object responsible for saving the task list.
     * @param ui      The Ui component used for interactions (not directly used here).
     * @return A confirmation message indicating the task has been unmarked.
     */
    @Override
    public String execute(TaskList tasks, Storage storage, Ui ui) {
        tasks.mark(index);
        storage.save(tasks);
        return "Nice! I've marked this task as done:\n" + " " + tasks.get(index);
    }
}
