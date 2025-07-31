package dao;

import control.ConexaoDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDao {

    private static final Connection connection = ConexaoDB.getConexao();
    public static int idUsuario = 0;

    public static boolean inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO tb_usuarios (nome, email, senha, telefone, cpf, estado, cidade, cep, bairro, rua, n_casa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlIdUsuario = "select id_usuario from tb_usuarios where cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql);  PreparedStatement stmtIdUsuario = connection.prepareStatement(sqlIdUsuario)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getCpf());
            stmtIdUsuario.setString(1, usuario.getCpf());
            ResultSet rs = stmtIdUsuario.executeQuery();
            if(rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                usuario.setIdUsuario(idUsuario);
            }

            stmt.setString(6, usuario.getEstado());
            stmt.setString(7, usuario.getCidade());
            stmt.setString(8, usuario.getCep());
            stmt.setString(9, usuario.getBairro());
            stmt.setString(10, usuario.getRua());
            stmt.setInt(11, usuario.getNumeroCasa());
        System.out.println("Usuario cadastrado com sucesso!");
        return stmt.executeUpdate() > 0;
           
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginUsuario(Usuario usuario) {
        String sql = "SELECT * FROM tb_usuarios WHERE email = ? AND senha = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha()); 
            ResultSet rs = stmt.executeQuery();
            int rowsAffected = rs.getRow();  
            if (rowsAffected > 0) {
                System.out.println("Login realizado com sucesso!");
                return true;
            } else {
                System.out.println("Email ou senha incorretos.");
                return false;
               }
        }catch (SQLException e){
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

