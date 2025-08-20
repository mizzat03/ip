public class listOfTasks {
    String[] list;
    int listSize;

    public listOfTasks() {
        list = new String[100];
        listSize = 0;
    }

    public String[] getList() {
        return list;
    }

    public int getListSize() {
        return listSize;
    }

    public void addTask(String task) {
        list[listSize] = task;
        listSize++;
        System.out.println("added: " + task);
    }

    public void display() {
        for (int i = 0; i < listSize; i++) {
            System.out.println( i+1 +". " + list[i]);
        }
    }
}
