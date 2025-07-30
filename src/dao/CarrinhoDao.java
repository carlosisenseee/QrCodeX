package dao;

import model.Carrinho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDao {

    private final Connection connection;

    public CarrinhoDao(Connection connection) {
        this.connection = connection;
    }

    public boolean inserirCarrinho(Carrinho carrinho) {
        String sql = "INSERT INTO tb_carrinhos (id_usuario, id_produto, quantidade_produto, preco_produto) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, carrinho.getIdUsuario());
            stmt.setInt(2, carrinho.getIdProduto());
            stmt.setInt(3, carrinho.getQuantidadeProduto());
            stmt.setDouble(4, carrinho.getPrecoProduto());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Carrinho> listarCarrinhos() {
        List<Carrinho> carrinhos = new ArrayList<>();
        String sql = "SELECT * FROM tb_carrinhos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Carrinho carrinho = new Carrinho(
                        rs.getInt("id_carrinho"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_produto"),
                        rs.getInt("quantidade_produto"),
                        rs.getDouble("preco_produto")
                );
                carrinhos.add(carrinho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinhos;
    }
}

