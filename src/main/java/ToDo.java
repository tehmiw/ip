public class ToDo extends ListItem {
    @Override
    public String getLine() {
        return "[T]" + super.getLine();
    }
    public ToDo(String desc) {
        super(desc);
    }
}
