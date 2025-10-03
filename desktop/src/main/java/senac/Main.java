package senac;

import javafx.application.Application;
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
    public void start(Stage stage) {
        Label label = new Label("Digite seu nome");
        TextField textField = new TextField();

        Button botao = new Button("Mostrar Saudação");
        Label saudacao = new Label();

        botao.setOnAction(e -> {
            // 1. Obtém o texto do campo (por exemplo: "Maria")
            String nome = textField.getText();
            
            // 2. APLICAÇÃO DO toUpperCase()
            // Converte o nome para MAIÚSCULAS (por exemplo: "MARIA")
            String nomeMaiusculo = nome.toUpperCase();
            
            // 3. Usa a nova string em maiúsculas na saudação
            saudacao.setText("Olá, " + nomeMaiusculo + " ! Seja bem vindo(a).");
        });

        VBox vbox = new VBox(10);
        // Observação: Corrigi um erro de digitação no seu estilo: "-fx-akignment" -> "-fx-alignment"
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;"); 
        vbox.getChildren().addAll(label, textField, botao, saudacao);
        
        Scene scene = new Scene(vbox, 400, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX + input de Nome");
        stage.show();
    }
}