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

    public String readCommand() {
        return sc.nextLine();
    }

    public void showTaskAdded(ListItem task, int totalTasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.getLine());
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
    }

    public void showTaskDeleted(ListItem task, int totalTasks) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task.getLine());
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
    }

    public void showTaskMarked(ListItem task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task.getLine());
    }

    public void showTaskUnmarked(ListItem task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task.getLine());
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

    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}