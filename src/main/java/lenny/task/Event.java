package lenny.task;

import lenny.util.DateFormatter;

public class Event extends Task {
    String from;
    String to;

    public Event(String taskName, String fromRaw, String toRaw , Boolean isDone) {
        super(taskName);
        taskType = "E";
        this.from = DateFormatter.format(fromRaw);
        this.to   = DateFormatter.format(toRaw);
        this.isDone = isDone;
    }

    public String getDuration() {
        return from + " - " + to;
    }

    @Override
    public String toString() {
        return "[E]" + (isDone ? "[X] " : "[ ] ") + getTaskName() + " (from: " + from + " to: " + to + ")";
    }

}
