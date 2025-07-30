package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
   public static Connection getConexao() {
        String user = "carlos";
        String senha = "senha123";
        String url = "jdbc:mysql://localhost:3306/db_pi";
        try {
            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
   }
}
