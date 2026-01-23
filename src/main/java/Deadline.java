public class Deadline extends ListItem {
    private String by;
    @Override
    public String getLine() {
        return "[D]" + super.getLine()
                + " (by: " + this.by + ")";
    }
    public Deadline(String desc, String by) {
        super(desc);
        this.by = by;
    }
}
