package lenny.gui;

import java.net.URL;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

public class DialogBox extends HBox {

    @FXML private Label dialog;
    @FXML private ImageView displayPicture;

    private DialogBox(String text, Image img) {
        try {
            URL url = DialogBox.class.getResource("/view/DialogBox.fxml");
            Objects.requireNonNull(url, "DialogBox.fxml not found under /view");
            FXMLLoader fxml = new FXMLLoader(url);
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

            dialog.setText(text);
            if (img != null) {
                displayPicture.setImage(img);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** User message – avatar on the LEFT (ImageView first) */
    public static DialogBox getUserDialog(String text, Image userImg) {
        // FXML order is ImageView then Label → already correct for user
        DialogBox db = new DialogBox(text, userImg);
        db.setAlignment(Pos.TOP_LEFT);
        return db;
    }

    /** Lenny message – avatar on the RIGHT (Label first, then ImageView) */
    public static DialogBox getLennyDialog(String text, Image lennyImg) {
        DialogBox db = new DialogBox(text, lennyImg);
        // Safely move the first child to the end (no duplicates created)
        if (db.getChildren().size() >= 2) {
            Node first = db.getChildren().remove(0); // remove ImageView
            db.getChildren().add(first);             // append to end
        }
        db.setAlignment(Pos.TOP_RIGHT);
        return db;
    }
}

