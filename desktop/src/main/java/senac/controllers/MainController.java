package senac.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label label;

    public void handleButtonClick(){
            label.setText("Botão clicado!");
    }
}
