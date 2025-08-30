package lenny.task;

import lenny.util.DateFormatter;

public class Deadline extends Task {
    String deadline;

    public Deadline(String taskName, String rawDeadline, Boolean isDone) {
        super(taskName);
        this.taskType = "D";
        this.deadline = DateFormatter.format(rawDeadline);
        this.isDone = isDone;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "[D]" + (this.isDone ? "[X] " : "[ ] ") + this.getTaskName() + " (by: " + this.deadline + ")";
    }
}


