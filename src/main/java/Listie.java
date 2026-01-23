import java.util.ArrayList;
import java.util.Scanner;

public class Listie {
    public static void main(String[] args) {
        ArrayList<ListItem> listitems = new ArrayList<>();
        String logo = "Hello! I'm Listie!\n" +
                "What can I do for you?";
        System.out.println(logo);
        //Solution below inspired by https://www.w3schools.com/java/java_user_input.asp
        Scanner sca = new Scanner(System.in);
        while (true) {
            try {
                String userinput = sca.nextLine();
                String firstword = userinput.split(" ")[0];
                switch (firstword) {
                    case "todo":
                        int firstspace = userinput.indexOf(" ");
                        if (firstspace == -1) {
                            throw new EmptyFieldException("todo");
                        }
                        String desc = userinput.substring(firstspace + 1);
                        if (desc.isEmpty()) {
                            throw new EmptyFieldException("todo");
                        }
                        ToDo itemaddedt = new ToDo(desc);
                        listitems.add(itemaddedt);
                        System.out.println("Got it. I've added this task:\n  "
                                + itemaddedt.getLine()
                                + String.format("\nNow you have %d tasks in the list.",
                                listitems.size()));
                        break;
                    case "deadline":
                        int firstspaced = userinput.indexOf(" ");
                        int bypos = userinput.indexOf("/by ");
                        if (firstspaced == -1 || bypos == -1) {
                            throw new EmptyFieldException("deadline");
                        }
                        String descd = userinput.substring(firstspaced + 1, bypos).trim();
                        String bydate = userinput.substring(bypos + 1 + 3).trim();
                        if (descd.isEmpty() || bydate.isEmpty()) {
                            throw new EmptyFieldException("deadline");
                        }
                        Deadline itemaddedd = new Deadline(descd, bydate);
                        listitems.add(itemaddedd);
                        System.out.println("Got it. I've added this task:\n  "
                                + itemaddedd.getLine()
                                + String.format("\nNow you have %d tasks in the list.",
                                listitems.size()));
                        break;
                    case "event":
                        int firstspacee = userinput.indexOf(" ");
                        int frompos = userinput.indexOf("/from ");
                        int topos = userinput.indexOf("/to ");
                        if (firstspacee == -1 || frompos == -1 || topos == -1) {
                            throw new EmptyFieldException("event");
                        }
                        String desce = userinput.substring(firstspacee + 1, frompos).trim();
                        String fromdate = userinput.substring(frompos + 1 + 5, topos).trim();
                        String todate = userinput.substring(topos + 1 + 3).trim();
                        if (desce.isEmpty() || fromdate.isEmpty() || todate.isEmpty()) {
                            throw new EmptyFieldException("event");
                        }
                        Event itemaddede = new Event(desce, fromdate, todate);
                        listitems.add(itemaddede);
                        System.out.println("Got it. I've added this task:\n  "
                                + itemaddede.getLine()
                                + String.format("\nNow you have %d tasks in the list.",
                                listitems.size()));
                        break;
                    case "delete":
                        int listindexd = Integer.parseInt(userinput.split(" ")[1]) - 1;
                        System.out.println("Noted. I've removed this task:\n  "
                                + listitems.get(listindexd).getLine()
                                + String.format("\nNow you have %d tasks in the list.",
                                listitems.size() - 1));
                        listitems.remove(listindexd);
                        break;
                    case "mark":
                        int listindexm = Integer.parseInt(userinput.split(" ")[1]) - 1;
                        listitems.get(listindexm).mark();
                        System.out.println("Nice! I've marked this task as done:\n  "
                                + listitems.get(listindexm).getLine());
                        break;
                    case "unmark":
                        int listindexu = Integer.parseInt(userinput.split(" ")[1]) - 1;
                        listitems.get(listindexu).unmark();
                        System.out.println("OK, I've marked this task as not done yet:\n  "
                                + listitems.get(listindexu).getLine());
                        break;
                    case "bye":
                        System.out.println("Bye. Hope to see you again soon!");
                        return;
                    case "list":
                        System.out.println("Here are the tasks in your list:");
                        for (int i = 0; i < listitems.size(); i++) {
                            System.out.println(String.format("%d.%s",
                                    i + 1,
                                    listitems.get(i).getLine()));
                        }
                        break;
                    default:
                        throw new NoTypeException();
                }
            } catch (EmptyFieldException e) {
                System.out.println(e.getMessage());
            } catch (NoTypeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error");
            }

        }
    }
}
