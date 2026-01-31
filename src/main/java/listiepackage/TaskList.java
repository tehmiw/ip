/**
 * The `TaskList` class helps manage the list of Tasks.
 */
package listiepackage;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<ListItem> tasks;

    public TaskList(ArrayList<ListItem> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<ListItem>();
    }

    public void add(ListItem task) {
        this.tasks.add(task);
    }

    public ListItem remove(int index) {
        return this.tasks.remove(index);
    }

    public void mark(int index) {
        this.tasks.get(index).mark();
    }

    public void unmark(int index) {
        this.tasks.get(index).unmark();
    }

    public void clear() {
        this.tasks.clear();
    }

    public ListItem get(int index) {
        return this.tasks.get(index);
    }

    public int size() {
        return this.tasks.size();
    }

}