public class Parser {

    public static String getCommand(String input) {
        return input.split(" ")[0];
    }

    public static String getTodoDescription(String input) throws EmptyFieldException {
        int firstSpace = input.indexOf(" ");
        if (firstSpace == -1) {
            throw new EmptyFieldException("todo");
        }
        return input.substring(firstSpace + 1).trim();
    }

    public static Deadline parseDeadline(String input) throws EmptyFieldException {
        int byPos = input.indexOf("/by ");
        int firstSpace = input.indexOf(" ");
        if (firstSpace == -1 || byPos == -1) {
            throw new EmptyFieldException("deadline");
        }
        String desc = input.substring(firstSpace + 1, byPos).trim();
        String by = input.substring(byPos + 4).trim();
        if (desc.isEmpty() || by.isEmpty()) {
            throw new EmptyFieldException("deadline");
        }
        return new Deadline(desc, by);
    }

    public static Event parseEvent(String input) throws EmptyFieldException {
        int fromPos = input.indexOf("/from ");
        int toPos = input.indexOf("/to ");
        int firstSpace = input.indexOf(" ");
        if (firstSpace == -1 || fromPos == -1 || toPos == -1) {
            throw new EmptyFieldException("event");
        }
        String desc = input.substring(firstSpace + 1, fromPos).trim();
        String from = input.substring(fromPos + 6, toPos).trim();
        String to = input.substring(toPos + 4).trim();
        if (desc.isEmpty() || from.isEmpty() || to.isEmpty()) {
            throw new EmptyFieldException("event");
        }
        return new Event(desc, from, to);
    }

    public static int parseIndex(String input) {
        return Integer.parseInt(input.split(" ")[1]) - 1;
    }

}