public class Task {
    String taskName;
    Boolean isDone;

    public Task(String taskName){
        this.taskName = taskName;
        isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void unmarkAsDone() {
        isDone = false;
    }
}
