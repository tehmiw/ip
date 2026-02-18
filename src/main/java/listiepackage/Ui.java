/**
 * The `Ui` class helps manage user input and output.
 */
package listiepackage;

import java.util.Scanner;

public class Ui {
    //Solution below inspired by https://www.w3schools.com/java/java_user_input.asp
    private final Scanner sc = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Hello! I'm Listie!");
        System.out.println("What can I do for you?");
    }

    public String getWelcome() {
        return "Hello! I'm Listie!\nWhat can I do for you?";
    }
    public String readCommand() {
        return sc.nextLine();
    }

    public String getHelpMessage() {
        // long string used AI (chatGPT) for reformatting to limit line width
        return "Here is a list of sample commands that you can use! "
                + "The colon and everything after describes what it represents.\n"
                + "\n"
                + "- todo read book: adds a todo item with description "
                + "'read book'\n"
                + "- deadline return book /by 2025-10-15: adds a deadline item "
                + "with description 'return book' and due date on 15 Oct 2025\n"
                + "- event project meeting /from 2025-10-15 /to 2025-10-16: "
                + "adds a event item with description 'project meeting' "
                + "and start date 15 Oct 2025 and end date 16 Oct 2025\n"
                + "- list: returns a list of your items so far\n"
                + "- mark 1: marks the first item in your list "
                + "(we start counting from 1)\n"
                + "- unmark 2: unmarks the second item in your list\n"
                + "- delete 5: deletes the fifth item in your list\n"
                + "- find book: returns a list of items with descriptions "
                + "that contain 'book' in them\n"
                + "- bye: exits the chatbot\n"
                + "\n"
                + "For convenience, you can update the details of your items too! "
                + "Here are a list of commands that allows you to amend "
                + "the various fields of your items.\n"
                + "- updateDesc 1 write summary: changes the description "
                + "of the first item in your list to 'write summary'\n"
                + "- updateBy 1 2025-10-14: changes the due date of the first item "
                + "(that is assumed to be a deadline item) to 14 Oct 2025\n"
                + "- updateFrom 1 2025-10-14: changes the start date of the first item "
                + "(that is assumed to be a event item) to 14 Oct 2025\n"
                + "- updateTo 1 2025-10-14: changes the end date of the first item "
                + "(that is assumed to be a event item) to 14 Oct 2025";
    }


    public void showTaskAdded(ListItem task, int totalTasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.getLine());
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
    }

    public String getTaskAdded(ListItem task, int totalTasks) {
        return "Got it. I've added this task:"
                + "\n  " + task.getLine()
                + "\nNow you have " + totalTasks + " tasks in the list.";
    }

    public void showTaskDeleted(ListItem task, int totalTasks) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task.getLine());
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
    }

    public String getTaskDeleted(ListItem task, int totalTasks) {
        return "Noted. I've removed this task:"
                + "\n  " + task.getLine()
                + "\nNow you have " + totalTasks + " tasks in the list.";
    }

    public String getTaskUpdated(ListItem task) {
        return "Cool! I've updated this task:"
                + "\n  " + task.getLine();
    }

    public void showTaskMarked(ListItem task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task.getLine());
    }

    public String getTaskMarked(ListItem task) {
        return "Nice! I've marked this task as done:"
                + "\n  " + task.getLine();
    }

    public void showTaskUnmarked(ListItem task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task.getLine());
    }

    public String getTaskUnmarked(ListItem task) {
        return "OK, I've marked this task as not done yet:"
                + "\n  " + task.getLine();
    }
    public String getFilteredList(String keyword, TaskList taskList) {
        TaskList filteredList = new TaskList();
        for (int i = 0; i < taskList.size(); i++) {
            ListItem current = taskList.get(i);
            if (current.getDesc().contains(keyword)) {
                filteredList.add(current);
            }
        }
        return getList(filteredList);
    }

    public String getList(TaskList taskList) {
        String listString = "Here are the tasks in your list:\n";
        for (int i = 0; i < taskList.size(); i++) {
            listString += (i + 1) + "." + taskList.get(i).getLine() + "\n";
        }
        return listString;
    }

    public void showFilteredList(String keyword, TaskList taskList) {
        TaskList filteredList = new TaskList();
        for (int i = 0; i < taskList.size(); i++) {
            ListItem current = taskList.get(i);
            if (current.getDesc().contains(keyword)) {
                filteredList.add(current);
            }
        }
        showList(filteredList);
    }

    public void showList(TaskList taskList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + "." + taskList.get(i).getLine());
        }
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public String getError(String message) {
        return message;
    }

    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public String getExit() {
        return "Bye. Hope to see you again soon!";
    }
}