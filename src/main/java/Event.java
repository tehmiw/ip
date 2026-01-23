public class Event extends ListItem {
    private String from;
    private String to;
    @Override
    public String getLine() {
        return "[E]" + super.getLine()
                + " (from: " + this.from
                + " to: " + this.to + ")";
    }
    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }

}
