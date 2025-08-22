public class Event extends Task {
    String duration;

    public Event(String taskName, String duration) {
        super(taskName);
        this.duration = duration;
    }

    @Override
    public String toString() {
        String[] split = duration.split("/", 2);
        String start = split[0].replaceFirst("from", "").trim();
        String end   = split[1].replaceFirst("to", "").trim();
        return "[D]" + (this.isDone ? "[X] " : "[ ] ") + this.getTaskName() + " (from: " + start + " to: " + end + ")" ;
    }

}
