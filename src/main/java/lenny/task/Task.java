package lenny.task;

public class Task {
    String taskName;
    Boolean isDone;
    String taskType;

    public Task(String taskName){
        this.taskName = taskName;
        isDone = false;
    }

    public String getTaskType() {
        return taskType;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public String getTaskName() {
        return taskName;
    }

    public void mark() {
        isDone = true;
    }

    public void unmark() {
        isDone = false;
    }
}
