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