package dao;

import control.ConexaoDB;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private static final Connection connection = ConexaoDB.getConexao();

    public static boolean inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO tb_usuarios (nome, email, senha, telefone, cpf, estado, cidade, cep, bairro, rua, n_casa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getCpf());
            stmt.setString(6, usuario.getEstado());
            stmt.setString(7, usuario.getCidade());
            stmt.setString(8, usuario.getCep());
            stmt.setString(9, usuario.getBairro());
            stmt.setString(10, usuario.getRua());
            stmt.setInt(11, usuario.getNumeroCasa());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM tb_usuarios";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("email"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getString("estado"),
                        rs.getString("cidade"),
                        rs.getString("cep"),
                        rs.getString("bairro"),
                        rs.getString("rua"),
                        rs.getInt("n_casa")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}

