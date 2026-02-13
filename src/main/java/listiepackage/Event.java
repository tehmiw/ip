/**
 * The `Event` class extends the ListItem class to capture a Event task.
 */
package listiepackage;

import java.time.LocalDate;

public class Event extends ListItem {
    private String from;
    private LocalDate fromLocalDate;
    private String fromDate;
    private String to;
    private LocalDate toLocalDate;
    private String toDate;
    /**
     * Returns the line representing the Event task
     *
     * @return line representing the Event task
     */
    @Override
    public String getLine() {
        return "[E]" + super.getLine()
                + " (from: " + this.getFrom()
                + " to: " + this.getTo() + ")";
    }
    /**
     * Returns the char representing the Event task
     *
     * @return char representing the Event task
     */
    @Override
    public char getType() {
        return 'e';
    }
    /**
     * Returns the printable from date
     *
     * @return string representing printable from date
     */
    public String getFrom() {

        return this.fromDate;
    }
    /**
     * Returns the printable to date
     *
     * @return string representing printable to date
     */
    public String getTo() {
        return this.toDate;
    }
    /**
     * Returns the stored from date
     *
     * @return string representing stored from date
     */
    public String getFromFormatted() {

        return this.from;
    }
    /**
     * Returns the stored to date
     *
     * @return string representing stored to date
     */
    public String getToFormatted() {

        return this.to;
    }
    public void updateFrom(String from) {
        this.from = from;
        this.fromLocalDate = LocalDate.parse(this.from);
        LocalDate a = this.fromLocalDate;
        this.fromDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " "
                +  Integer.toString(a.getYear());
    }
    public void updateTo(String to) {
        this.to = to;
        this.toLocalDate = LocalDate.parse(this.to);
        LocalDate b = this.toLocalDate;
        this.toDate = b.getMonth().name() + " " + Integer.toString(b.getDayOfMonth()) + " "
                +  Integer.toString(b.getYear());
    }
    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
        this.fromLocalDate = LocalDate.parse(this.from);
        this.toLocalDate = LocalDate.parse(this.to);
        LocalDate a = this.fromLocalDate;
        LocalDate b = this.toLocalDate;
        this.fromDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " "
                +  Integer.toString(a.getYear());
        this.toDate = b.getMonth().name() + " " + Integer.toString(b.getDayOfMonth()) + " "
                +  Integer.toString(b.getYear());
    }
    public Event(String desc, boolean done, String from, String to) {
        super(desc, done);
        this.from = from;
        this.to = to;
        this.fromLocalDate = LocalDate.parse(this.from);
        this.toLocalDate = LocalDate.parse(this.to);
        LocalDate a = this.fromLocalDate;
        LocalDate b = this.toLocalDate;
        this.fromDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " "
                +  Integer.toString(a.getYear());
        this.toDate = b.getMonth().name() + " " + Integer.toString(b.getDayOfMonth()) + " "
                +  Integer.toString(b.getYear());
    }

}
