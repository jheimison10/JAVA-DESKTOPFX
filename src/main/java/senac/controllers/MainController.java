package senac.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
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

public class MainController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idadeField;

    @FXML
    private ListView<String> listaPessoas;

    private ObservableList<String> pessoas = FXCollections.observableArrayList();

    @FXML
    public void handleNovo(ActionEvent event) {
        nomeField.clear();
        emailField.clear();
        idadeField.clear();
    }

    @FXML
    public void handleSair(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void handleSobre(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sobre");
        alert.setHeaderText("Sistema de Cadastro");
        alert.setContentText("Aplicativo desenvolvido em JavaFX para fins educacionais");
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        if (listaPessoas != null) {
            listaPessoas.setItems(pessoas);
        } else {
            System.out.println("Erro: listaPessoas é null!");
        }
    }

    public void handleEnviar(ActionEvent actionEvent) {
        // Recupera os dados dos campos
        String nome = nomeField.getText();
        String email = emailField.getText();
        String idade = idadeField.getText();

        // Validação para o campo Nome
        if (nome == null || nome.trim().isEmpty()) {
            // Verifica se o nome está vazio
            showAlert("Nome é obrigatório");
            return;
        }
        if (!nome.matches("^[a-zA-ZÀ-ú\\s]+$")) { // Regex para nome: permite letras e espaços
            // Verifica se o nome contém apenas letras (incluindo acentuadas) e espaços
            showAlert("Nome inválido. Apenas letras e espaços são permitidos");
            return;
        }

        // Validação para o campo Email
        if (email == null || email.trim().isEmpty()) {
            // Verifica se o email está vazio
            showAlert("Email é obrigatório");
            return;
        }
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + // Regex para email
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            // Verifica se o email segue um formato válido de email (exemplo:
            // exemplo@dominio.com)
            showAlert("Email inválido");
            return;
        }

        // Validação para o campo Idade
        if (idade == null || idade.trim().isEmpty()) {
            // Verifica se a idade está vazia
            showAlert("Idade é obrigatória");
            return;
        }
        if (!idade.matches("^\\d{1,3}$")) { // Regex para idade: apenas números, até 3 dígitos
            // Verifica se a idade contém apenas números, e até 3 dígitos
            showAlert("Idade inválida. Apenas números são permitidos");
            return;
        }

        // Adiciona o novo registro à lista de pessoas
        pessoas.add(nome + " - " + email + " - " + idade);

        // Mostra uma mensagem de sucesso com os dados inseridos
        showInfo("✅ Pessoa adicionada com sucesso:\n\nNome: " + nome + "\nEmail: " + email + "\nIdade: " + idade);

        // Limpa os campos após a adição
        nomeField.clear();
        emailField.clear();
        idadeField.clear();
    }

    // Método para exibir um alerta de erro
    private void showAlert(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro na Validação");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // Método para exibir uma mensagem de sucesso
    private void showInfo(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pessoa Adicionada");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
    // Método para chamar uma nova aba Cadastro de Endereço
     public void handleNovoEndereco(ActionEvent event) {
        try {
            Parent endereco = FXMLLoader.load(getClass().getResource("/EnderecoCadastro.fxml"));

            Stage stage = new Stage();
            stage.setTitle("Cadastro de Endereço");
            stage.setScene(new Scene(endereco));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}