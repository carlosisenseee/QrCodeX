package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDao {

    private final Connection connection;

    public ProdutoDao(Connection connection) {
        this.connection = connection;
    }

    // Create
    public static boolean inserirProduto(Produto produto) {
        String sql = "INSERT INTO tb_produtos (id_fornecedor, nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produto.getIdFornecedor());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setDouble(5, produto.getPreco());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto: " + e.getMessage());
            return false;
        }
    }

    // Read all (corrigido para listarTodos)
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id_produto, id_fornecedor, nome, descricao, quantidade, preco FROM tb_produtos";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("id_produto"));
                p.setIdFornecedor(rs.getInt("id_fornecedor"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPreco(rs.getDouble("preco"));
                produtos.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }

    // Read by ID
    public Produto buscarPorId(int idProduto) {
        String sql = "SELECT * FROM tb_produtos WHERE id_produto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto p = new Produto();
                    p.setIdProduto(rs.getInt("id_produto"));
                    p.setIdFornecedor(rs.getInt("id_fornecedor"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setQuantidade(rs.getInt("quantidade"));
                    p.setPreco(rs.getDouble("preco"));
                    return p;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto por ID: " + e.getMessage());
        }
        return null;
    }

    // Update
    public boolean atualizarProduto(Produto produto) {
        String sql = "UPDATE tb_produtos SET id_fornecedor = ?, nome = ?, descricao = ?, quantidade = ?, preco = ? WHERE id_produto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produto.getIdFornecedor());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setDouble(5, produto.getPreco());
            stmt.setInt(6, produto.getIdProduto());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
            return false;
        }
    }

    // Delete
    public boolean deletarProduto(int idProduto) {
        String sql = "DELETE FROM tb_produtos WHERE id_produto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar produto: " + e.getMessage());
            return false;
        }
    }
}
