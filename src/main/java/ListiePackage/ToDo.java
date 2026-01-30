package ListiePackage;

public class ToDo extends ListItem {
    @Override
    public String getLine() {
        return "[T]" + super.getLine();
    }
    @Override
    public char getType() {
        return 't';
    }
    public ToDo(String desc) {
        super(desc);
    }
    public ToDo(String desc, boolean done) {
        super(desc, done);
    }
}
