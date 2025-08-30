package lenny.task;

import lenny.util.DateFormatter;

/**
 * Represents a task with a deadline.
 * A Deadline task has a description and a specific due date/time.
 */
public class Deadline extends Task {
    String deadline;

    /**
     * Creates a new Deadline task.
     *
     * @param taskName Description of the deadline task.
     * @param rawDeadline The due date/time of the task as a string.
     * @param isDone True if the task is already completed, otherwise false.
     */
    public Deadline(String taskName, String rawDeadline, Boolean isDone) {
        super(taskName);
        this.taskType = "D";
        this.deadline = DateFormatter.format(rawDeadline);
        this.isDone = isDone;
    }

    /**
     * Returns the deadline string.
     *
     * @return The due date/time of this deadline task.
     */
    public String getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "[D]" + (this.isDone ? "[X] " : "[ ] ") + this.getTaskName() + " (by: " + this.deadline + ")";
    }
}


