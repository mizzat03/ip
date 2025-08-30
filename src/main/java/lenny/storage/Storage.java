package lenny.storage;

import lenny.task.Todo;
import lenny.task.Deadline;
import lenny.task.Event;
import lenny.task.Task;
import lenny.task.TaskList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Handles reading and writing tasks to storage.
 */
public class Storage {
    private final Path file;

    /**
     * Creates a Storage object with the given file path.
     *
     * @param filePath String representation of the path to the data file.
     */
    public Storage(String filePath) {
        this.file = Path.of(filePath);
    }

    /**
     * Ensures that the data file and its directories exist.
     */
    public void ensureFile() {
        try {
            Path dir = file.getParent();
            if (dir != null) {
                Files.createDirectories(dir);
            }
            try {
                Files.createFile(file);
                System.out.println("Created the data file!");
            } catch (FileAlreadyExistsException ignored) {
                System.out.println("Data file already exists!");
            }
        } catch (IOException e) {
            throw new RuntimeException("Problem preparing data storage", e);
        }
    }

    /**
     * Loads tasks from the data file into a TaskList.
     *
     * @return A ArrayList containing tasks read from storage.
     */
    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        File data = file.toFile();

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                String t = line.trim();
                if (t.isEmpty() || t.startsWith("#")) continue;

                String[] parts = t.split("\\s*\\|\\s*", -1);
                if (parts.length < 3) continue;

                String type = parts[0];
                boolean done;
                try {
                    done = Integer.parseInt(parts[1]) == 1;
                } catch (NumberFormatException nfe) {
                    continue;
                }
                String desc = parts[2];

                switch (type) {
                    case "T":
                        tasks.add(new Todo(desc, done));
                        break;
                    case "D":
                        if (parts.length >= 4) {
                            String by = parts[3];
                            tasks.add(new Deadline(desc, by, done));
                        }
                        break;
                    case "E":
                        if (parts.length >= 5) {
                            String from = parts[3];
                            String to = parts[4];
                            tasks.add(new Event(desc, from, to, done));
                        }
                        break;
                    default:
                        // ignore unknown lines
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read " + data + ": " + e.getMessage());
        }
        return tasks;
    }

    /**
     * Saves the given TaskList to the data file.
     *
     * @param tasks TaskList to save.
     */
    public void save(TaskList tasks) {
        try (BufferedWriter writer = Files.newBufferedWriter(
                file,
                StandardCharsets.UTF_8)) {
            for (Task t : tasks.asList()) {
                writer.write(formatTaskLine(t));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to write tasks to " + file, e);
        }
    }

    /**
     * Formats the given task to the correct format to be saved in data file.
     *
     * @param t Task to be formatted before being saved in the data file.
     */
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
                String duration = ((Event) t).getDuration();
                return String.format("%s | %s | %s | %s", type, done, desc, duration);
            default:
                return "# Unknown task: " + type;
        }
    }
}
