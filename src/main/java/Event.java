public class Event extends ListItem {
    private String from;
    private String to;
    @Override
    public String getLine() {
        return "[E]" + super.getLine()
                + " (from: " + this.from
                + " to: " + this.to + ")";
    }
    @Override
    public char getType() {
        return 'e';
    }
    public String getFrom() {
        return this.from;
    }
    public String getTo() {
        return this.to;
    }
    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }
    public Event(String desc, boolean done, String from, String to) {
        super(desc, done);
        this.from = from;
        this.to = to;
    }

}
