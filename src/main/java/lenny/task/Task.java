package lenny.task;

/**
 * Represents a generic task with a description and completion status.
 * This is the parent class for all specific task types such as {@link Todo}, {@link Deadline}, and {@link Event}.
 */

public class Task {
    String taskName;
    Boolean isDone;
    String taskType;

    /**
     * Creates a new Task.
     *
     * @param taskName The name of the task.
     */
    public Task(String taskName){
        this.taskName = taskName;
        isDone = false;
    }

    /**
     * Returns the type of the task as a string symbol.
     *
     * @return "T", "D", or "E" if the task type is Todo,Deadline or Event respectively.
     */
    public String getTaskType() {
        return taskType;
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
