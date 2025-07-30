package dao;

import model.QRCodeInfo;
import control.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QRCodeDao {

    private final Connection connection;

    public QRCodeDao() {
        this.connection = ConexaoDB.getConexao();
    }

    // Buscar QRCode pelo id do produto
    public QRCodeInfo buscarQRCodePorIdProduto(int idProduto) {
        String sql = "SELECT * FROM tb_qrcodes WHERE id_produto = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new QRCodeInfo(
                        rs.getInt("id_produto"),
                        rs.getString("descricao"),
                        rs.getInt("id_pedido"),
                        rs.getInt("id_fornecedor"),
                        rs.getString("remetente"),
                        rs.getString("destino"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Inserir um QR Code no banco
    public boolean inserirQRCode(QRCodeInfo info) {
        String sql = "INSERT INTO tb_qrcodes (id_produto, descricao, id_pedido, id_fornecedor, remetente, destino) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, info.getIdProduto());
            stmt.setString(2, info.getDescricao());
            stmt.setInt(3, info.getIdPedido());
            stmt.setInt(4, info.getIdFornecedor());
            stmt.setString(5, info.getFornecedor());
            stmt.setString(6, info.getUsuario());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Novo método para listar dados necessários para gerar QR Codes
   public List<QRCodeInfo> listarDadosParaQRCode() {
    List<QRCodeInfo> lista = new ArrayList<>();

    String sql = "SELECT " +
            "p.id_pedido, " +
            "c.id_produto, " +
            "pr.descricao, " +
            "f.id_fornecedor, " +
            "f.nome AS nome_fornecedor, " +
            "u.nome AS nome_usuario, " +
            "u.rua, " +
            "u.bairro, " +
            "u.cidade, " +
            "u.cep " +
            "FROM tb_pedidos p " +
            "JOIN tb_carrinhos c ON c.id_carrinho = p.id_carrinho " +
            "JOIN tb_produtos pr ON pr.id_produto = c.id_produto " +
            "JOIN tb_fornecedores f ON f.id_fornecedor = pr.id_fornecedor " +
            "JOIN tb_usuarios u ON u.id_usuario = c.id_usuario";

    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            // Apenas para debug, confira no console os dados
            System.out.println("Fornecedor: " + rs.getString("nome_fornecedor"));
            System.out.println("Usuário: " + rs.getString("nome_usuario"));
            System.out.println("Rua: " + rs.getString("rua"));
            System.out.println("Bairro: " + rs.getString("bairro"));
            System.out.println("Cidade: " + rs.getString("cidade"));
            System.out.println("CEP: " + rs.getString("cep"));
            System.out.println("-------------------------------");

            QRCodeInfo info = new QRCodeInfo(
                    rs.getInt("id_produto"),
                    rs.getString("descricao"),
                    rs.getInt("id_pedido"),
                    rs.getInt("id_fornecedor"),
                    rs.getString("nome_fornecedor"),
                    rs.getString("nome_usuario"),
                    rs.getString("rua"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("cep")
            );
            lista.add(info);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}



}
