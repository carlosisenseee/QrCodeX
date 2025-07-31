
package dao;

import control.ConexaoDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

public class FornecedorDao {

    private static final Connection connection = ConexaoDB.getConexao();

    public static boolean inserirFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO tb_fornecedores (nome, cnpj) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

public static List<Fornecedor> listarFornecedores() {
    List<Fornecedor> fornecedores = new ArrayList<>();
    String sql = "SELECT * FROM tb_fornecedores";

    try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor(
                rs.getInt("id_fornecedor"),
                rs.getString("email"),
                rs.getString("nome"),
                rs.getString("senha"),
                rs.getString("telefone"),
                rs.getString("cnpj"),
                rs.getString("estado"),
                rs.getString("cidade"),
                rs.getString("cep"),
                rs.getString("bairro"),
                rs.getString("rua"),
                rs.getInt("n_empresa")
            );
            fornecedores.add(fornecedor);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return fornecedores;
}


}
