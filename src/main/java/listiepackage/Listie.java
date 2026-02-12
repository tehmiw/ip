/**
 * The `Listie` class represents and carries out the main functionality of the program.
 */
package listiepackage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Listie {
    public static void main(String[] args) {
        Storage storage = new Storage("./Listie.txt");
        TaskList listItems = new TaskList();
        Ui ui = new Ui();
        try {
            listItems = storage.loadItems();
            assert listItems != null : "Loaded TaskList should not be null";
        } catch (FileNotFoundException e) {

        }
        ui.showWelcome();
        while (true) {
            try {
                String userInput = ui.readCommand();
                String firstWord = Parser.getCommand(userInput);
                assert firstWord != null : "Parser.getCommand should not return null";
                switch (firstWord) {
                case "todo":
                    ToDo itemAddedT = new ToDo(Parser.getTodoDescription(userInput));
                    assert itemAddedT != null : "Created ToDo should not be null";
                    listItems.add(itemAddedT);
                    ui.showTaskAdded(itemAddedT, listItems.size());
                    break;
                case "deadline":
                    Deadline itemAddedD = Parser.parseDeadline(userInput);
                    assert itemAddedD != null : "Created Deadline should not be null";
                    listItems.add(itemAddedD);
                    ui.showTaskAdded(itemAddedD, listItems.size());
                    break;
                case "event":
                    Event itemAddedE = Parser.parseEvent(userInput);
                    assert itemAddedE != null : "Created Event should not be null";
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
                    assert markIndex >= 0 : "Index should be non-negative";
                    assert markIndex < listItems.size() : "Index should be within bounds";
                    listItems.mark(markIndex);
                    assert listItems.get(markIndex).isDone() : "Task should be marked";
                    ui.showTaskMarked(listItems.get(markIndex));
                    break;
                case "unmark":
                    int unmarkIndex = Parser.parseIndex(userInput);
                    assert unmarkIndex >= 0 : "Index should be non-negative";
                    assert unmarkIndex < listItems.size() : "Index should be within bounds";
                    listItems.unmark(unmarkIndex);
                    assert !listItems.get(unmarkIndex).isDone() : "Task should be unmarked";
                    ui.showTaskUnmarked(listItems.get(unmarkIndex));
                    break;
                case "bye":
                    ui.showExit();
                    storage.updateFile(listItems);
                    return;
                case "list":
                    ui.showList(listItems);
                    break;
                case "find":
                    String keyword = Parser.getKeyword(userInput);
                    ui.showFilteredList(keyword, listItems);
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
