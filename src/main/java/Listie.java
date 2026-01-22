import java.util.ArrayList;
import java.util.Scanner;

public class Listie {
    public static void main(String[] args) {
        ArrayList<ListItem> listitems = new ArrayList<>();
        String logo = "Hello! I'm Listie!" +
                "\nWhat can I do for you?";
        System.out.println(logo);
        //Solution below inspired by https://www.w3schools.com/java/java_user_input.asp
        while (true){
            String userinput = new Scanner(System.in).nextLine();
            switch (userinput) {
                case "bye":
                    break;
                case "list":
                    for (int i = 0; i < listitems.size(); i++) {
                        System.out.println(String.format("%d. %s", i + 1, listitems.get(i).getDesc()));
                    }
                    break;
                default:
                    System.out.println(userinput);
                    listitems.add(new ListItem(userinput));
            }
            if (userinput.equals("bye")) {
                break;
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
