package senac.desktopfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Label label = new Label("Ola, javaFX no Mave!");
        StackPane stackpane = new StackPane(label);
        Scene scene = new Scene(stackpane, 400, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX + Maven + VS Code");
        stage.show();
    }
}