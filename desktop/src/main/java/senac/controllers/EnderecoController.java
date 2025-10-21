package senac.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import java.util.regex.Pattern; // Import necessário para usar o Pattern
import java.io.IOException;
import java.util.regex.Matcher; // Import necessário para usar o Matcher

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class EnderecoController {

    @FXML private TextField logradouroField;
    @FXML private TextField numeroField;
    @FXML private TextField complementoField;
    @FXML private TextField bairroField;
    @FXML private TextField cidadeField;
    @FXML private TextField estadoField;
    @FXML private TextField cepField;

    @FXML
    private void handleSalvarEndereco() {
        String logradouro = logradouroField.getText();
        String numero = numeroField.getText();
        String complemento = complementoField.getText();
        String bairro = bairroField.getText();
        String cidade = cidadeField.getText();
        String estado = estadoField.getText();
        String cep = cepField.getText();

        if (logradouro.isEmpty() || numero.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || estado.isEmpty() || cep.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Campos obrigatórios", "Por favor, preencha todos os campos obrigatórios.");
            return;
        }

        showAlert(Alert.AlertType.INFORMATION,"Endereço Salvo", "Endereço cadastrado com sucesspo"); 

    }

    private void showAlert(Alert.AlertType type, String title, String message){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}