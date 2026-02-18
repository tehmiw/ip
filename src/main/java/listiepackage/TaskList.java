package listiepackage;

import java.util.ArrayList;

/**
 * The `TaskList` class helps manage the list of Tasks.
 */

public class TaskList {
    private ArrayList<ListItem> tasks;

    /**
     * Constructor for list of items
     *
     * @param tasks ArrayList of tasks
     */
    public TaskList(ArrayList<ListItem> tasks) {
        this.tasks = tasks;
    }

    /**
     * Constructor for empty list of items
     */
    public TaskList() {
        this.tasks = new ArrayList<ListItem>();
    }

    /**
     * Adds task to list of items
     *
     * @param task item to be added
     */
    public void add(ListItem task) {
        this.tasks.add(task);
    }

    /**
     * Removes task from list of items and returns item removed
     *
     * @param index index of item to be removed
     * @return item object removed
     */
    public ListItem remove(int index) {
        return this.tasks.remove(index);
    }

    /**
     * Marks task with index
     *
     * @param index index of item to be marked
     */
    public void mark(int index) {
        this.tasks.get(index).mark();
    }

    /**
     * Unmarks task with index
     *
     * @param index index of item to be unmarked
     */
    public void unmark(int index) {
        this.tasks.get(index).unmark();
    }

    /**
     * Clears list of items of all items
     */
    public void clear() {
        this.tasks.clear();
    }

    /**
     * Returns item with index from list
     *
     * @param index index of item to be gotten
     * @return item object with corresponding index
     */
    public ListItem get(int index) {
        return this.tasks.get(index);
    }

    /**
     * Returns size of list
     *
     * @return size of list
     */
    public int size() {
        return this.tasks.size();
    }

}