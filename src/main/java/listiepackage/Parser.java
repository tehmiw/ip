package listiepackage;

/**
 * The `Parser` class helps parse user inputs.
 */

public class Parser {

    /**
     * Returns command in user input
     *
     * @param input User input
     * @return command in user input
     */
    public static String getCommand(String input) {
        return input.split(" ")[0];
    }

    /**
     * Returns description of ToDo
     * If the no whitespace, EmptyFieldException is thrown
     *
     * @param input User input
     * @return description of ToDo
     * @throws EmptyFieldException If no whitespace.
     */
    public static String getTodoDescription(String input) throws EmptyFieldException {
        int firstSpace = input.indexOf(" ");
        if (firstSpace == -1) {
            throw new EmptyFieldException("todo");
        }
        return input.substring(firstSpace + 1).trim();
    }

    /**
     * Returns details of update command
     * If the no whitespace, EmptyFieldException is thrown
     *
     * @param input User input
     * @return details of update command
     * @throws EmptyFieldException If no whitespace.
     */
    public static String getUpdateDetails(String input) throws EmptyFieldException {
        int firstSpace = input.indexOf(" ");
        if (firstSpace == -1) {
            throw new EmptyFieldException("update");
        }
        String intermediateString = input.substring(firstSpace + 1).trim();
        int nextSpace = intermediateString.indexOf(" ");
        if (nextSpace == -1) {
            throw new EmptyFieldException("update");
        }
        String details = intermediateString.substring(nextSpace + 1).trim();
        return details;
    }

    /**
     * Returns Deadline object
     * If the no whitespace, EmptyFieldException is thrown
     *
     * @param input User input
     * @return Deadline object
     * @throws EmptyFieldException If no whitespace.
     */
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

    /**
     * Returns Event object
     * If the no whitespace, EmptyFieldException is thrown
     *
     * @param input User input
     * @return Event object
     * @throws EmptyFieldException If no whitespace.
     */
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

    /**
     * Returns keyword of command
     * If the no whitespace, EmptyFieldException is thrown
     *
     * @param input User input
     * @return keyword of command
     * @throws EmptyFieldException If no whitespace.
     */
    public static String getKeyword(String input) throws EmptyFieldException {
        int firstSpace = input.indexOf(" ");
        if (firstSpace == -1) {
            throw new EmptyFieldException("find");
        }
        return input.substring(firstSpace + 1).trim();
    }

    /**
     * Returns index of command adjusted to start counting from 1 instead of 0
     *
     * @param input User input
     * @return index of command
     */
    public static int parseIndex(String input) {
        return Integer.parseInt(input.split(" ")[1]) - 1;
    }

}