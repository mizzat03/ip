import java.io.File;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class listOfTasks {
    ArrayList<Task> list;

    public listOfTasks() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public void addTask(Task task) {
        list.add(task);


        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.toString());
        System.out.println("Now you have " + list.size() + " tasks in the list.");
    }


    public void markTask(int i) {
        Task t = list.get(i - 1);
        t.mark();
        System.out.println("Nice! I've marked this task as done:\n" + list.get(i - 1).toString());
    }

    public void unmarkTask(int i) {
        Task t = list.get(i - 1);
        t.unmark();
        System.out.println("OK, I've marked this task as not done yet:\n" + list.get(i - 1).toString());
    }

    public void display() {
        System.out.println( "Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).toString());

        }
    }

    public void deleteTask(int i) {
        String deletedTask = list.get(i - 1).toString();
        list.remove(i-1);
        System.out.println("Noted. I've removed this task: \n" + "  " + deletedTask + "\n" +  "Now you have " +list.size()+ " tasks in the list.");
    }

    public static listOfTasks parseFile(File data) {
        listOfTasks tasks = new listOfTasks();

        try (BufferedReader br = Files.newBufferedReader(data.toPath(), StandardCharsets.UTF_8)) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // Skip blanks and comment lines
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                // Split on '|' with optional spaces around it
                String[] parts = line.split("\\s*\\|\\s*", -1);

                if (parts.length < 3) {
                    continue;
                }

                String type = parts[0];

                boolean doneFlag; //true if 1 and false otherwise
                try {
                    doneFlag = Integer.parseInt(parts[1]) == 1;
                } catch (NumberFormatException nfe) {
                    // Bad done flag; skip
                    continue;
                }
                String desc = parts[2];

                switch (type) {
                    case "T":
                        tasks.addTask(new Todo(desc, doneFlag));
                        break;

                    case "D":
                        if (parts.length >= 4) {
                            String by = parts[3];
                            tasks.addTask(new Deadline(desc, by, doneFlag));
                        }
                        break;

                    case "E":
                        if (parts.length >= 5) {
                            String from = parts[3];
                            String to   = parts[4];
                            tasks.addTask(new Event(desc, from, to, doneFlag));
                        }
                        break;

                    default:
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read " + data + ": " + e.getMessage());
        }
        return tasks;
    }

    public static void writeToFile(File data, listOfTasks tasks) {
        Path file = data.toPath();
        try {
            Path parent = file.getParent();
            if (parent != null) Files.createDirectories(parent);

            // Overwrite (not append)
            try (BufferedWriter writer = Files.newBufferedWriter(
                    file,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING)) {

                for (Task t : tasks.getList()) {
                    writer.write(formatTaskLine(t));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to write tasks to " + file, e);
        }
    }

    private static String formatTaskLine(Task t) {
        String type = t.getTaskType();
        String done = t.getIsDone() ? "1" : "0";
        String desc = t.getTaskName();

        switch (type) {
            case "T":
                return String.format("%s | %s | %s", type, done, desc);
            case "D":
                String by = ((Deadline) t).getDeadline();
                return String.format("%s | %s | %s | %s", type, done, desc, by);
            case "E":
                String at = ((Event) t).getDuration();
                return String.format("%s | %s | %s | %s", type, done, desc, at);
            default:
                return "# Unknown task: " + type;
        }
    }
}
