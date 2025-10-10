package senac.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idadeField;

    public void handleEnviar(ActionEvent actionEvent){
        String nome = nomeField.getText();
        String email = emailField.getText();
        String idade = idadeField.getText();
        
        if(idade == null || idade.trim().isEmpty()){
            showAlert("Idade e obrigatorio");
        }

        if(email == null || email.trim().isEmpty()){
            showAlert("Email e obrigatorio");
        }

        if ( nome == null || nome.trim().isEmpty()){
            showAlert("Nome e obrigatorio");
        }
            }

    public void showAlert(String alerta){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        alert.setTitle("Erro na Validação");
        alert.setHeaderText(null);
        alert.setContentText(alerta);
        alert.showAndWait();
    }
}
