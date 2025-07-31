package dao;

import control.ConexaoDB;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class PedidoDao {

    private final Connection connection;

    public PedidoDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * Salva o pedido no banco e retorna o id gerado.
     * Retorna -1 se ocorrer erro.
     */
    public int salvar(Pedido pedido) {
        String sql = "INSERT INTO tb_pedidos (id_carrinho, data_pedido_feito, data_pedido_entregue, preco_total, status_pagamento) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pedido.getIdCarrinho());
            stmt.setDate(2, java.sql.Date.valueOf(pedido.getDataPedidoFeito()));

            if (pedido.getDataPedidoEntregue() != null) {
                stmt.setDate(3, java.sql.Date.valueOf(pedido.getDataPedidoEntregue()));
            } else {
                stmt.setNull(3, Types.DATE);
            }

            stmt.setDouble(4, pedido.getPrecoTotal());
            stmt.setString(5, pedido.getStatusPagamento());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * Lista todos os pedidos cadastrados no banco.
     */
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM tb_pedidos";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                LocalDate dataPedidoFeito = null;
                LocalDate dataPedidoEntregue = null;

                Date dataFeitoSql = rs.getDate("data_pedido_feito");
                if (dataFeitoSql != null) {
                    dataPedidoFeito = dataFeitoSql.toLocalDate();
                }

                Date dataEntregueSql = rs.getDate("data_pedido_entregue");
                if (dataEntregueSql != null) {
                    dataPedidoEntregue = dataEntregueSql.toLocalDate();
                }

                Pedido pedido = new Pedido(
                        rs.getInt("id_pedido"),
                        rs.getInt("id_carrinho"),
                        dataPedidoFeito,
                        dataPedidoEntregue,
                        rs.getDouble("preco_total"),
                        rs.getString("status_pagamento")
                );

                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }

    // Aqui você pode adicionar outros métodos como atualizar, deletar, buscar por id etc, se precisar.
      public static void cancelarPedido(Pedido Pedido){
        //Não vamos deletar o pedido, vamos apenas atualizar o status dele para cancelado
        //na tabela tb_pedidos e tb_estoque;
        String sql = "UPDATE tb_pedidos p JOIN tb_estoque e ON p.id_pedido = e.id_pedido SET p.status_pagamento = 'CANCELADO', e.status_ = 'CANCELADO' WHERE p.id_pedido = ?";
        Connection con = ConexaoDB.getConexao();
        try {
             PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, Pedido.getIdPedido());
            stmt.executeUpdate();
            System.out.println("Pedido cancelado com sucesso!");
         } catch (SQLException e) {
        e.printStackTrace();
        }
    }
}

