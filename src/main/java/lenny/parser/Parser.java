package lenny.parser;

import lenny.task.Deadline;
import lenny.task.Event;
import lenny.task.Todo;
import lenny.exception.LennyExceptions;

/**
 * Parses user input commands into Task objects or program actions.
 */
public class Parser {

    /**
     * Parses a command string to determine the type of task the user is inputting.
     *
     * @param input Full user input string
     * @return A string containing the description of the task.
     * */
    public static String command(String input) {
        String[] parts = input.trim().split("\\s+", 2);
        return parts[0].toLowerCase();
    }
    /**
     * Parses a command string for an integer index for either 'mark', 'unmark' or 'delete' actions.
     *
     * @param input Full user input string.
     * @return An integer index.
     * @throws LennyExceptions If index is missing or invalid.
     */
    public static int parseIndex(String input) throws LennyExceptions {
        String[] parts = input.trim().split("\\s+", 2);
        if (parts.length < 2) {
            throw new LennyExceptions("OOPS!!! Provide an index.");
        }
        try {
            return Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new LennyExceptions("OOPS!!! Index must be a number.");
        }
    }
    /**
     * Parses a todo command string into a Todo object.
     *
     * @param input Full user input string.
     * @return A Todo task.
     * @throws LennyExceptions If description is missing.
     */
    public static Todo parseTodo(String input) throws LennyExceptions {
        String[] parts = input.trim().split("\\s+", 2);
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new LennyExceptions("OOPS!!! The description of a todo cannot be empty.");
        }
        return new Todo(parts[1].trim(), false);
    }
    /**
     * Parses a deadline command string into a Deadline object.
     *
     * @param input Full user input string containing /by.
     * @return A Deadline task.
     * @throws LennyExceptions If description or /by part is missing.
     */
    public static Deadline parseDeadline(String input) throws LennyExceptions {
        String[] parts = input.trim().split("\\s+", 2);
        if (parts.length < 2 || !parts[1].contains("/by")) {
            throw new LennyExceptions("OOPS!!! The description of a deadline must include /by.");
        }
        String rhs = parts[1];
        int byIdx = rhs.indexOf("/by");
        if (byIdx < 0 || byIdx + 3 >= rhs.length()) {
            throw new LennyExceptions("OOPS!!! Provide a date/time after /by.");
        }
        String name = rhs.substring(0, byIdx).trim();
        String by = rhs.substring(byIdx + 3).trim();
        return new Deadline(name, by, false);
    }

    /**
     * Parses an event command string into an Event object.
     *
     * @param input Full user input string containing /from and /to.
     * @return An Event task.
     * @throws LennyExceptions If parts are missing.
     */
    public static Event parseEvent(String input) throws LennyExceptions {
        String[] parts = input.trim().split("\\s+", 2);
        if (parts.length < 2 || !parts[1].contains("/from") || !parts[1].contains("/to")) {
            throw new LennyExceptions("OOPS!!! The description of an event must include /from and /to.");
        }
        String rhs = parts[1];
        int fromIdx = rhs.indexOf("/from");
        int toIdx = rhs.indexOf("/to");
        if (fromIdx < 0 || toIdx < 0 || fromIdx >= toIdx) {
            throw new LennyExceptions("OOPS!!! Use: event NAME /from START /to END");
        }
        String name = rhs.substring(0, fromIdx).trim();
        String from = rhs.substring(fromIdx + 5, toIdx).trim();
        String to = rhs.substring(toIdx + 3).trim();
        return new Event(name, from, to, false);
    }
}