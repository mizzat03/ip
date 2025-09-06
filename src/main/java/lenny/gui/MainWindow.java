package lenny.gui;

import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import lenny.logic.Lenny;

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

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(
                DialogBox.getLennyDialog("Hello! I'm Lenny. What can I do for you?", lennyImage)
        );
    }

    public void setLenny(Lenny l) {
        this.lenny = l;
    }

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        if (input == null || input.isBlank()) return;

        String response = lenny.getResponse(input);

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getLennyDialog(response, lennyImage)
        );

        userInput.clear();
    }
}