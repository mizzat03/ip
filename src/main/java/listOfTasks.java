public class listOfTasks {
    Task[] list;
    int listSize;

    public listOfTasks() {
        list = new Task[100];
        listSize = 0;
    }

    public Task[] getList() {
        return list;
    }

    public int getListSize() {
        return listSize;
    }

    public void addTask(String task) {
        Task Task = new Task(task);
        list[listSize] = Task;
        listSize++;
        System.out.println("added: " + task);
    }

    public void markTask(int i) {
        list[i-1].markAsDone();
        System.out.println("Nice! I've marked this task as done:\n" + "  [X] " + list[i-1].taskName);
    }

    public void unmarkTask(int i) {
        list[i-1].unmarkAsDone();
        System.out.println("OK, I've marked this task as not done yet:\n" + "  [ ] " + list[i-1].taskName);
    }

    public void display() {
        System.out.println( "Here are the tasks in your list:\n");
        for (int i = 0; i < listSize; i++) {
            if (list[i].isDone) {
                System.out.println((i+1) +".[X] " + list[i].getTaskName());
            } else {
                System.out.println((i + 1) + ".[ ] " + list[i].getTaskName());
            }
        }
    }
}
