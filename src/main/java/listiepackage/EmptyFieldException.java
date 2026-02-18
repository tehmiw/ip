package listiepackage;

/**
 * The `EmptyFieldException` class captures a exception caused by unspecified fields.
 */

public class EmptyFieldException extends Exception {
    /**
     * Constructor for empty field exception
     *
     * @param itemtype String that represents the type of item
     */
    public EmptyFieldException(String itemtype) {
        super("The field(s) of a " + itemtype + " cannot be empty.");
    }
}
