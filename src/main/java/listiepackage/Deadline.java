/**
 * The `Deadline` class extends the ListItem class to capture a Deadline task.
 */
package listiepackage;

import java.time.LocalDate;

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
    public void updateBy(String by) {
        this.by = by;
        this.byLocalDate = LocalDate.parse(this.by);
        LocalDate a = this.byLocalDate;
        this.byDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " "
                +  Integer.toString(a.getYear());
    }
    public Deadline(String desc, String by) {
        super(desc);
        this.by = by;
        this.byLocalDate = LocalDate.parse(this.by);
        LocalDate a = this.byLocalDate;
        this.byDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " "
                +  Integer.toString(a.getYear());
    }
    public Deadline(String desc, boolean done, String by) {
        super(desc, done);
        this.by = by;
        this.byLocalDate = LocalDate.parse(this.by);
        LocalDate a = this.byLocalDate;
        this.byDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " "
                +  Integer.toString(a.getYear());
    }
}
