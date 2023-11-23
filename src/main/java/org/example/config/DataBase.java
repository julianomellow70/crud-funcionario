package org.example.config;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBase {
    public Connection conectarBancoDados() {
        String nomeBanco = "loja";
        String porta = "3306";
        String host = "localhost";
        String url = "jdbc:mysql://" + host + ":" + porta + "/" + nomeBanco;
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao banco de dados");
            return connection;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados: " + e.getMessage());
        }
        return null;
    }


}




