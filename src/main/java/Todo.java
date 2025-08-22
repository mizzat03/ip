public class Todo extends Task {

    public Todo(String taskName){
        super(taskName);
    }

    @Override
    public String toString() {
        return "[T]" + (this.isDone ? "[X] " : "[ ] ") + this.getTaskName();
    }


}
