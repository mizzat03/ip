public class Deadline extends Task {
    String deadline;


    public Deadline(String taskName, String deadline, Boolean isDone) {
        super(taskName);
        taskType = "D";
        this.deadline = deadline;
        this.isDone = isDone;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        String[] split = deadline.split(" ", 2);
        String day = split[1].trim();
        return "[D]" + (this.isDone ? "[X] " : "[ ] ") + this.getTaskName() + " (by: " + day + ")";
    }

}
