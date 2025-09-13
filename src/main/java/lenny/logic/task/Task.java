package lenny.logic.task;

/**
 * Represents a generic task with a description and completion status.
 * This is the parent class for all specific task types such as {@link Todo}, {@link Deadline}, and {@link Event}.
 */

public class Task {
    private String taskName;
    private Boolean isDone;

    /**
     * Creates a new Task.
     *
     * @param taskName The name of the task.
     */
    public Task(String taskName) {
        this.taskName = taskName;
        isDone = false;
    }
    public String getTaskType() {
        return "T";
    }
    /**
     * Returns whether this task is completed.
     *
     * @return {@code true} if the task is done, {@code false} otherwise.
     */
    public Boolean getIsDone() {
        return isDone;
    }

    /**
     * Returns the description of the task.
     *
     * @return A string representation of the task.
     */
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }


    /**
     * Marks this task as done.
     */
    public void mark() {
        isDone = true;
    }

    /**
     * Marks this task as undone.
     */
    public void unmark() {
        isDone = false;
    }
}
