import java.util.Scanner;

public class Listie {
    public static void main(String[] args) {
        String logo = "Hello! I'm Listie!" +
                "\nWhat can I do for you?";
        System.out.println(logo);
        //Solution below inspired by https://www.w3schools.com/java/java_user_input.asp
        while (true){
            String userinput = new Scanner(System.in).nextLine();
            System.out.println(userinput);
            if (userinput.equals("bye")) {
                break;
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
