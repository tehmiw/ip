import java.time.LocalDate;

public class Event extends ListItem {
    private String from;
    private LocalDate fromLocalDate;
    private String fromDate;
    private String to;
    private LocalDate toLocalDate;
    private String toDate;
    @Override
    public String getLine() {
        return "[E]" + super.getLine()
                + " (from: " + this.getFrom()
                + " to: " + this.getTo() + ")";
    }
    @Override
    public char getType() {
        return 'e';
    }
    public String getFrom() {
        return this.fromDate;
    }
    public String getTo() {
        return this.toDate;
    }
    public String getFromFormatted() {
        return this.from;
    }
    public String getToFormatted() {
        return this.to;
    }
    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
        this.fromLocalDate = LocalDate.parse(this.from);
        this.toLocalDate = LocalDate.parse(this.to);
        LocalDate a = this.fromLocalDate;
        LocalDate b = this.toLocalDate;
        this.fromDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " " +  Integer.toString(a.getYear());
        this.toDate = b.getMonth().name() + " " + Integer.toString(b.getDayOfMonth()) + " " +  Integer.toString(b.getYear());
    }
    public Event(String desc, boolean done, String from, String to) {
        super(desc, done);
        this.from = from;
        this.to = to;
        this.fromLocalDate = LocalDate.parse(this.from);
        this.toLocalDate = LocalDate.parse(this.to);
        LocalDate a = this.fromLocalDate;
        LocalDate b = this.toLocalDate;
        this.fromDate = a.getMonth().name() + " " + Integer.toString(a.getDayOfMonth()) + " " +  Integer.toString(a.getYear());
        this.toDate = b.getMonth().name() + " " + Integer.toString(b.getDayOfMonth()) + " " +  Integer.toString(b.getYear());
    }

}
