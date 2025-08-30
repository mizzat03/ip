package lenny.parser;

import lenny.task.Deadline;
import lenny.task.Event;
import lenny.task.Todo;
import lenny.exception.LennyExceptions;

public class Parser {

    public static String command(String input) {
        String[] parts = input.trim().split("\\s+", 2);
        return parts[0].toLowerCase();
    }

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

    public static Todo parseTodo(String input) throws LennyExceptions {
        String[] parts = input.trim().split("\\s+", 2);
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new LennyExceptions("OOPS!!! The description of a todo cannot be empty.");
        }
        return new Todo(parts[1].trim(), false);
    }

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

    public static String parseKeyword(String input) throws LennyExceptions {
        String[] parts = input.trim().split("\\s+", 2);
        if (parts.length < 2) {
            throw new LennyExceptions("OOPS!!! Provide a keyword.");
        }
        return parts[1];

    }
}