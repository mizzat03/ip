package lenny.gui;

import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import lenny.logic.Lenny;

/**
 * Controller for {@code MainWindow.fxml}.
 * <p>
 * Manages the main chat UI: reads user input, asks {@link lenny.logic.Lenny}
 * for a response, and appends {@link DialogBox} nodes for both user and bot
 * messages. Also keeps the scroll pane pinned to the latest message.
 * </p>
 */
public class MainWindow {

    @FXML private ScrollPane scrollPane;
    @FXML private VBox dialogContainer;
    @FXML private TextField userInput;
    @FXML private Button sendButton;

    private Lenny lenny;

    // preload avatars from resources
    private final Image userImage  =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/DaUser.png")));
    private final Image lennyImage =
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/DaLenny.png")));

    /**
     * Called automatically by the FXML loader after the view is constructed.
     * Binds the scroll position to the dialog container height and may add an
     * initial greeting message.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(
                DialogBox.getLennyDialog("Hello! I'm Lenny. What can I do for you?", lennyImage)
        );
    }

    /**
     * Injects the backend logic object that processes user input.
     *
     * @param l the {@link lenny.logic.Lenny} instance to use
     */

    public void setLenny(Lenny l) {
        this.lenny = l;
    }

    /**
     * Handles the Send button (and Enter key) action: reads the text field,
     * obtains a response from {@link lenny.logic.Lenny}, appends user and bot
     * dialog boxes to the conversation, and clears the input field.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        if (input == null || input.isBlank()) {
            return;
        }

        String response = lenny.getResponse(input);

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getLennyDialog(response, lennyImage)
        );

        userInput.clear();
    }
}
