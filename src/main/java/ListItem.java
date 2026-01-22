public class ListItem {
    private String desc;
    private boolean done;
    public ListItem(String desc){
        this.desc = desc;
        this.done = false;
    }
    public String getDesc() {
        return this.desc;
    }
    public void mark() {
        this.done = true;
    }
    public void unmark() {
        this.done = false;
    }
    public boolean isDone() {
        return this.done;
    }
    public String getLine() {
        return String.format("[%s] %s",
                this.isDone() ? "X" : " ",
                this.getDesc());
    }
}
