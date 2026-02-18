package listiepackage;

import java.time.LocalDate;

/**
 * The `Deadline` class extends the ListItem class to capture a Deadline task.
 */

public class Deadline extends ListItem {
    private String by;
    private LocalDate byLocalDate;
    private String byDate;
    /**
     * Returns the line representing the Deadline task
     *
     * @return line representing the Deadline task
     */
    @Override
    public String getLine() {
        return "[D]" + super.getLine()
                + " (by: " + this.getBy() + ")";
    }
    /**
     * Returns the char representing the Deadline task
     *
     * @return char representing the Deadline task
     */
    @Override
    public char getType() {
        return 'd';
    }
    /**
     * Returns the printable by date
     *
     * @return string representing printable by date
     */
    public String getBy() {
        return this.byDate;
    }
    /**
     * Returns the stored by date
     *
     * @return string representing stored by date
     */
    public String getByFormatted() {
        return this.by;
    }
    /**
     * Updates the stored by date
     *
     * @param by String representing by date
     */
    public void updateBy(String by) {
        this.by = by;
        this.byLocalDate = LocalDate.parse(this.by);
        LocalDate a = this.byLocalDate;
        this.byDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " "
                +  Integer.toString(a.getYear());
    }
    /**
     * Constructor for Deadline object
     *
     * @param desc String representing description
     * @param by String representing by date
     */
    public Deadline(String desc, String by) {
        super(desc);
        this.by = by;
        this.byLocalDate = LocalDate.parse(this.by);
        LocalDate a = this.byLocalDate;
        this.byDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " "
                +  Integer.toString(a.getYear());
    }
    /**
     * Constructor for Deadline object, used for loading file
     *
     * @param desc String representing description
     * @param done boolean representing whether task is marked
     * @param by String representing by date
     */
    public Deadline(String desc, boolean done, String by) {
        super(desc, done);
        this.by = by;
        this.byLocalDate = LocalDate.parse(this.by);
        LocalDate a = this.byLocalDate;
        this.byDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " "
                +  Integer.toString(a.getYear());
    }
}
