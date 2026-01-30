package ListiePackage;

public class EmptyFieldException extends Exception {
    public EmptyFieldException(String itemtype) {
        super("The field(s) of a " + itemtype + " cannot be empty.");
    }
}
