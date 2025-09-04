package lenny.task;

import lenny.util.DateFormatter;


/**
 * Represents an event task that has a start and end time.
 */
public class Event extends Task {
    private String from;
    private String to;

    /**
     * Creates a new Event task.
     *
     * @param taskName Description of the event task.
     * @param fromRaw The start date/time of the event.
     * @param toRaw The end date/time of the event.
     * @param isDone True if the event task is already completed, otherwise false.
     */
    public Event(String taskName, String fromRaw, String toRaw , Boolean isDone) {
        super(taskName);
        taskType = "E";
        this.from = DateFormatter.format(fromRaw);
        this.to = DateFormatter.format(toRaw);
        this.isDone = isDone;
    }

    /**
     * Returns the duration of the event as a formatted string.
     *
     * @return A string containing start and end times of the event.
     */
    public String getDuration() {
        return from + " - " + to;
    }

    @Override
    public String toString() {
        return "[E]" + (isDone ? "[X] " : "[ ] ") + getTaskName() + " (from: " + from + " to: " + to + ")";
    }

}
