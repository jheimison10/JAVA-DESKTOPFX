package senac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
     public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = FXMLLoader.load(getClass().getResource("/interface.fxml"));

       Scene scene = new Scene(root, 300, 200);

        stage.setScene(scene);
        stage.setTitle("Exemplo javaFX");
        stage.show();
    }
}