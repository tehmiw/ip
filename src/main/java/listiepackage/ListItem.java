package listiepackage;

/**
 * The `ListItem` class represents a Task.
 */

public class ListItem {
    private String desc;
    private boolean isDone;
    /**
     * Constructor for item object
     *
     * @param desc String representing description
     */
    public ListItem(String desc){
        this.desc = desc;
        this.isDone = false;
    }
    /**
     * Constructor for item object, used for loading file
     *
     * @param desc String representing description
     * @param isDone boolean representing whether task is marked
     */
    public ListItem(String desc, boolean isDone){
        this.desc = desc;
        this.isDone = isDone;
    }
    /**
     * Returns description of item object
     *
     * @return String representing description
     */
    public String getDesc() {
        return this.desc;
    }
    /**
     * Marks item object
     */
    public void mark() {
        this.isDone = true;
    }
    /**
     * Unmarks item object
     */
    public void unmark() {
        this.isDone = false;
    }
    /**
     * Returns whether task is marked
     *
     * @return boolean representing whether task is marked
     */
    public boolean isDone() {
        return this.isDone;
    }
    /**
     * Updates the description of the item object
     *
     * @param desc String representing the new description
     */
    public void updateDesc(String desc) {
        this.desc = desc;
    }
    /**
     * Returns printable String that has the details of the item
     *
     * @return String that has the details of the item
     */
    public String getLine() {
        return String.format("[%s] %s",
                this.isDone() ? "X" : " ",
                this.getDesc());
    }
    /**
     * Returns char representing type of item
     *
     * @return char representing type of item
     */
    public char getType() {
        return 'a';
    }
}
