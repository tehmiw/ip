package listiepackage;

import java.time.LocalDate;

public class Deadline extends ListItem {
    private String by;
    private LocalDate byLocalDate;
    private String byDate;
    @Override
    public String getLine() {
        return "[D]" + super.getLine()
                + " (by: " + this.getBy() + ")";
    }
    @Override
    public char getType() {
        return 'd';
    }
    public String getBy() {
        return this.byDate;
    }
    public String getByFormatted() {
        return this.by;
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
