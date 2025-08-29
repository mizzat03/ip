import java.nio.file.Path;

public class Lenny {
    private final Storage storage;
    private listOfTasks tasks;
    private final Ui ui;

    public Lenny(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            storage.ensureFile();
            tasks = new listOfTasks(storage.load());
        } catch (RuntimeException e) {
            ui.showLoadingError();
            tasks = new listOfTasks();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String input = ui.readCommand();
                String cmd = Parser.command(input);

                switch (cmd) {
                    case "list":
                        tasks.show();
                        break;

                    case "mark":
                        tasks.mark(Parser.parseIndex(input));
                        storage.save(tasks);
                        break;

                    case "unmark":
                        tasks.unmark(Parser.parseIndex(input));
                        storage.save(tasks);
                        break;

                    case "todo":
                        tasks.add(Parser.parseTodo(input));
                        storage.save(tasks);
                        break;

                    case "deadline":
                        tasks.add(Parser.parseDeadline(input));
                        storage.save(tasks);
                        break;

                    case "event":
                        tasks.add(Parser.parseEvent(input));
                        storage.save(tasks);
                        break;

                    case "delete":
                        tasks.delete(Parser.parseIndex(input));
                        storage.save(tasks);
                        break;

                    case "bye":
                        isExit = true;
                        break;

                    default:
                        throw new LennyExceptions("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (LennyExceptions e) {
                ui.showError(e.getMessage());
            }
        }

        ui.showBye();
        storage.save(tasks);
    }

    public static void main(String[] args) {
        new Lenny("data/LennyData.txt").run();
    }
}