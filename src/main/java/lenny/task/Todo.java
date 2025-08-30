package lenny.task;


public class Todo extends Task {
    public Todo(String taskName, Boolean isDone){
        super(taskName);
        taskType = "T";
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "[T]" + (this.isDone ? "[X] " : "[ ] ") + this.getTaskName();
    }


}
