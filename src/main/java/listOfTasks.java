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

    public void addTask(Task task) {
        list[listSize] = task;
        listSize++;
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.toString());
        System.out.println("Now you have " + listSize + " tasks in the list.");
    }

    public void markTask(int i) {
        list[i-1].mark();
        System.out.println("Nice! I've marked this task as done:\n" + list[i-1].toString());
    }

    public void unmarkTask(int i) {
        list[i-1].unmark();
        System.out.println("OK, I've marked this task as not done yet:\n" + "  [ ] " + list[i-1].getTaskName());
    }

    public void display() {
        System.out.println( "Here are the tasks in your list:\n");
        for (int i = 0; i < listSize; i++) {
            System.out.println((i + 1) + ". " + list[i].toString());

        }
    }
}
