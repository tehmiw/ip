public class EmptyFieldException extends Exception {
    public EmptyFieldExceptionException(String itemtype) {
        super("The field(s) of a " + itemtype + "cannot be empty.");
    }
}
