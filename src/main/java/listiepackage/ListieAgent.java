package listiepackage;

import java.io.IOException;

public class ListieAgent {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }
    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String userInput, Storage storage, TaskList listItems, Ui ui) {
        String response = "";
        try {
            String firstWord = Parser.getCommand(userInput);
            assert firstWord != null : "Parser.getCommand should not return null";
            switch (firstWord) {
            case "todo":
                ToDo itemAddedT = new ToDo(Parser.getTodoDescription(userInput));
                assert itemAddedT != null : "Created ToDo should not be null";
                listItems.add(itemAddedT);
                response += ui.getTaskAdded(itemAddedT, listItems.size());
                break;
            case "deadline":
                Deadline itemAddedD = Parser.parseDeadline(userInput);
                assert itemAddedD != null : "Created Deadline should not be null";
                listItems.add(itemAddedD);
                response += ui.getTaskAdded(itemAddedD, listItems.size());
                break;
            case "event":
                Event itemAddedE = Parser.parseEvent(userInput);
                assert itemAddedE != null : "Created Event should not be null";
                listItems.add(itemAddedE);
                response += ui.getTaskAdded(itemAddedE, listItems.size());
                break;
            case "delete":
                int delIndex = Parser.parseIndex(userInput);
                ListItem removed = listItems.remove(delIndex);
                response += ui.getTaskDeleted(removed, listItems.size());
                break;
            case "mark":
                int markIndex = Parser.parseIndex(userInput);
                assert markIndex >= 0 : "Index should be non-negative";
                assert markIndex < listItems.size() : "Index should be within bounds";
                listItems.mark(markIndex);
                assert listItems.get(markIndex).isDone() : "Task should be marked";
                response += ui.getTaskMarked(listItems.get(markIndex));
                break;
            case "unmark":
                int unmarkIndex = Parser.parseIndex(userInput);
                assert unmarkIndex >= 0 : "Index should be non-negative";
                assert unmarkIndex < listItems.size() : "Index should be within bounds";
                listItems.unmark(unmarkIndex);
                assert !listItems.get(unmarkIndex).isDone() : "Task should be unmarked";
                response += ui.getTaskUnmarked(listItems.get(unmarkIndex));
                break;
            case "bye":
                response += ui.getExit();
                storage.updateFile(listItems);
            case "list":
                response += ui.getList(listItems);
                break;
            case "find":
                String keyword = Parser.getKeyword(userInput);
                response += ui.getFilteredList(keyword, listItems);
                break;
            default:
                throw new NoTypeException();
            }
        } catch (EmptyFieldException | NoTypeException e) {
            response += ui.getError(e.getMessage());
        } catch (IOException e) {
            response += "Saving error.";
        } catch (Exception e) {
            response += "Unexpected error";
        }
        return response;
    }


}

