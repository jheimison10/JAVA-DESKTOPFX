package senac.services.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/gestao_pessoas";
    private static final String USUARIO = "gestor";
    private static final String SENHA = "senhaSeguraAqui!";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectado ao MySQL com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao MySQL: " + e.getMessage());
            return null;
         }
       }
    }