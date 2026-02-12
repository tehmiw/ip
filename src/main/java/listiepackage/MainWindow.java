package listiepackage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import javafx.application.Platform;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private ListieAgent listie;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image listieImage = new Image(this.getClass().getResourceAsStream("/images/DaListie.png"));

    private Storage storage = new Storage("./Listie.txt");
    private TaskList listItems = new TaskList();
    private Ui ui = new Ui();

    @FXML
    public void initialize() {
        try {
            listItems = storage.loadItems();
            assert listItems != null : "Loaded TaskList should not be null";
        } catch (FileNotFoundException e) {

        }
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getListieDialog("Hello! I'm Listie!\nWhat can I do for you?", listieImage)
        );
    }

    /** Injects the ListieAgent instance */
    public void setListie(ListieAgent l) {
        listie = l;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing ListieAgent's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = listie.getResponse(input, storage, listItems, ui);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getListieDialog(response, listieImage)
        );
        userInput.clear();
        if (input.equalsIgnoreCase("bye")) {
            Platform.exit();
        }
    }
}
