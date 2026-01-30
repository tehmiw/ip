import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Storage {
    private String filePath;
    private TaskList listItems = new TaskList();
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void updateFile(TaskList listItems) throws IOException {
        this.listItems = listItems;
        FileWriter fw = new FileWriter(filePath);
        String fileContent = "";
        for (int i = 0; i < this.listItems.size(); i++) {
            ListItem listItem = this.listItems.get(i);
            char taskType = listItem.getType();
            boolean taskDone = listItem.isDone();
            String taskDoneString = taskDone ? "1" : "0";
            String currentline = "";
            String desc = listItem.getDesc();
            switch (taskType) {
            case 't':
                currentline = "t" + taskDoneString + "|" + desc;
                break;
            case 'd':
                Deadline deadline = (Deadline) listItem;
                String by = deadline.getByFormatted();
                currentline = "d" + taskDoneString + "|" + desc + "|" + by;
                break;
            case 'e':
                Event event = (Event) listItem;
                String from = event.getFromFormatted();
                String to = event.getToFormatted();
                currentline = "e" + taskDoneString + "|" + desc + "|" + from + "|" + to;
                break;
            }
            if (i != listItems.size() - 1) {
                currentline += "\n";
            }
            fileContent += currentline;
        }
        fw.write(fileContent);
        fw.close();
    }

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
            boolean doneTask = done == '1' ? true : false;
            switch (taskType) {
            case 't':
                ToDo toDo = new ToDo(details, doneTask);
                this.listItems.add(toDo);
                break;
            case 'd':
                int nextLine = details.indexOf("|");
                String descD = details.substring(0, nextLine);
                String dateD = details.substring(nextLine + 1);
                Deadline deadline = new Deadline(descD, doneTask, dateD);
                this.listItems.add(deadline);
                break;
            case 'e':
                int nextLineE = details.indexOf("|");
                String descE = details.substring(0, nextLineE);
                String dates = details.substring(nextLineE + 1);
                int lastLine = dates.indexOf("|");
                String startDate = dates.substring(0, lastLine);
                String endDate = dates.substring(lastLine + 1);
                Event event = new Event(descE, doneTask, startDate, endDate);
                this.listItems.add(event);
                break;
            }
        }
        return this.listItems;
    }

}
