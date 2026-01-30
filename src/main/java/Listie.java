import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Listie {
    public static void main(String[] args) {
        Storage storage = new Storage("./Listie.txt");;
        TaskList listItems = new TaskList();
        Ui ui = new Ui();
        try {
            listItems = storage.loadItems();
        } catch (FileNotFoundException e) {

        }
        ui.showWelcome();
        while (true) {
            try {
                String userInput = ui.readCommand();
                String firstWord = Parser.getCommand(userInput);
                switch (firstWord) {
                case "todo":
                    ToDo itemAddedT = new ToDo(Parser.getTodoDescription(userInput));
                    listItems.add(itemAddedT);
                    ui.showTaskAdded(itemAddedT, listItems.size());
                    break;
                case "deadline":
                    Deadline itemAddedD = Parser.parseDeadline(userInput);
                    listItems.add(itemAddedD);
                    ui.showTaskAdded(itemAddedD, listItems.size());
                    break;
                case "event":
                    Event itemAddedE = Parser.parseEvent(userInput);
                    listItems.add(itemAddedE);
                    ui.showTaskAdded(itemAddedE, listItems.size());
                    break;
                case "delete":
                    int delIndex = Parser.parseIndex(userInput);
                    ListItem removed = listItems.remove(delIndex);
                    ui.showTaskDeleted(removed, listItems.size());
                    break;
                case "mark":
                    int markIndex = Parser.parseIndex(userInput);
                    listItems.mark(markIndex);
                    ui.showTaskMarked(listItems.get(markIndex));
                    break;
                case "unmark":
                    int unmarkIndex = Parser.parseIndex(userInput);
                    listItems.unmark(unmarkIndex);
                    ui.showTaskUnmarked(listItems.get(unmarkIndex));
                    break;
                case "bye":
                    ui.showExit();
                    storage.updateFile(listItems);
                    return;
                case "list":
                    ui.showList(listItems);
                    break;
                default:
                    throw new NoTypeException();
                }
            } catch (EmptyFieldException | NoTypeException e) {
                ui.showError(e.getMessage());
            } catch (IOException e) {
                System.out.println("Saving error.");
            } catch (Exception e) {
                System.out.println("Unexpected error");
            }

        }
    }
}
