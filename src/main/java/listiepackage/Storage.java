package listiepackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 * The `Storage` class helps manage local storage of data.
 */

public class Storage {
    private String filePath;
    private TaskList listItems = new TaskList();
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Updates the file acting as local storage
     * If saving or file error, IOException is thrown
     *
     * @param listItems list of items
     * @throws IOException If saving or file error.
     */
    public void updateFile(TaskList listItems) throws IOException {
        this.listItems = listItems;
        FileWriter fw = new FileWriter(filePath);
        String fileContent = "";
        for (int i = 0; i < this.listItems.size(); i++) {
            ListItem listItem = this.listItems.get(i);
            char taskType = listItem.getType();
            boolean isTaskDone = listItem.isDone();
            String taskDoneString = isTaskDone ? "1" : "0";
            String currentLine = "";
            String desc = listItem.getDesc();
            switch (taskType) {
            case 't':
                currentLine = "t" + taskDoneString + "|" + desc;
                break;
            case 'd':
                Deadline deadline = (Deadline) listItem;
                String by = deadline.getByFormatted();
                currentLine = "d" + taskDoneString + "|" + desc + "|" + by;
                break;
            case 'e':
                Event event = (Event) listItem;
                String from = event.getFromFormatted();
                String to = event.getToFormatted();
                currentLine = "e" + taskDoneString + "|" + desc + "|" + from + "|" + to;
                break;
            }
            if (i != listItems.size() - 1) {
                currentLine += "\n";
            }
            fileContent += currentLine;
        }
        fw.write(fileContent);
        fw.close();
    }

    /**
     * Returns list of items from local storage
     * If file loading error, FileNotFoundException is thrown
     *
     * @return list of items
     * @throws FileNotFoundException If file loading error
     */
    public TaskList loadItems() throws FileNotFoundException{
        this.listItems.clear();
        File f = new File(this.filePath);
        if (!f.exists()) {
            return new TaskList();
        }
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String toBeAdded = s.nextLine();
            int firstLine = toBeAdded.indexOf("|");
            String details = toBeAdded.substring(firstLine + 1);
            char taskType = toBeAdded.charAt(0);
            char done = toBeAdded.charAt(1);
            boolean isTaskDone = done == '1' ? true : false;
            switch (taskType) {
            case 't':
                ToDo toDo = new ToDo(details, isTaskDone);
                this.listItems.add(toDo);
                break;
            case 'd':
                Deadline deadline = processDeadline(details, isTaskDone);
                this.listItems.add(deadline);
                break;
            case 'e':
                Event event = processEvent(details, isTaskDone);
                this.listItems.add(event);
                break;
            }
        }
        return this.listItems;
    }

    public Deadline processDeadline(String details, boolean isTaskDone) {
        int nextLine = details.indexOf("|");
        String descD = details.substring(0, nextLine);
        String dateD = details.substring(nextLine + 1);
        Deadline deadline = new Deadline(descD, isTaskDone, dateD);
        return deadline;
    }

    public Event processEvent(String details, boolean isTaskDone) {
        int nextLineE = details.indexOf("|");
        String descE = details.substring(0, nextLineE);
        String dates = details.substring(nextLineE + 1);
        int lastLine = dates.indexOf("|");
        String startDate = dates.substring(0, lastLine);
        String endDate = dates.substring(lastLine + 1);
        Event event = new Event(descE, isTaskDone, startDate, endDate);
        return event;
    }

}
