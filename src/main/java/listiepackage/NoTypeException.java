package listiepackage;

public class NoTypeException extends Exception{
    public NoTypeException () {
        super("You need to specify a type of task to add.");
    }
}
