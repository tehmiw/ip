package listiepackage;

/**
 * The `ToDo` class extends the ListItem class to capture a ToDo task.
 */

public class ToDo extends ListItem {
    /**
     * Returns the line representing the ToDo task
     *
     * @return line representing the ToDo task
     */
    @Override
    public String getLine() {
        return "[T]" + super.getLine();
    }
    /**
     * Returns the char representing the ToDo task
     *
     * @return char representing the ToDo task
     */
    @Override
    public char getType() {
        return 't';
    }
    public ToDo(String desc) {
        super(desc);
    }
    public ToDo(String desc, boolean isDone) {
        super(desc, isDone);
    }
}
