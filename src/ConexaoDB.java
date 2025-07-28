import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
   public static Connection getConexao() {
        String user = "carlos";
        String senha = "senha123";
        String url = "jdbc:mysql://10.10.29.73:3306/db_pi";
        try {
            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
   }
}
