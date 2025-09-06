package lenny.gui;

import java.net.URL;
import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lenny.logic.Lenny;

public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = Gui.class.getResource("/view/MainWindow.fxml");
        Objects.requireNonNull(url, "MainWindow.fxml not found under /view");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        MainWindow controller = loader.getController();
        controller.setLenny(new Lenny("data/LennyData.txt"));

        stage.setTitle("Lenny");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
