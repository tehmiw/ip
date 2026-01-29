public class Deadline extends ListItem {
    private String by;
    @Override
    public String getLine() {
        return "[D]" + super.getLine()
                + " (by: " + this.by + ")";
    }
    @Override
    public char getType() {
        return 'd';
    }
    public String getBy() {
        return this.by;
    }
    public Deadline(String desc, String by) {
        super(desc);
        this.by = by;
    }
    public Deadline(String desc, boolean done, String by) {
        super(desc, done);
        this.by = by;
    }
}
