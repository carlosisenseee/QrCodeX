import dao.PedidoDao;
import dao.UsuarioDao;
import java.util.Scanner;
import model.Pedido;
import model.Usuario;
import util.*;

public class MainUsuario {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
        int opc = scan.nextInt();

        switch (opc) {
            case 1:
                System.out.println("Informe o ");
                Gerar.gerarQrCode(1, 1);
                break;
            case 2:
                Ler.lerQrCode();
                break;
        }
    }



    /* Rapazes tive uma ideia, que tal separar o menu em partes tipo{
    1 - Cadastrar-
    2 - Fazer login
    3 - Ver produtos
    4 - Carrinho ai abre uma parte onde o usuario pode 
    adicionar itens ao carrinho, excluir carrinho, ver carrinhos criados
    o mesmo com pedidos, onde o usuario pode fazer pedido, cancelar pedido, ver pedidos
    e afins, o que acham?
        */

    public static void menu() {
       /*  System.out.println("""
                Bem vindo ao QrCodeX
                1 - Cadastrar-se 
                2- Fazer login
                3 - Ver produtos
                4 - Adiconar itens carrinho
                3 - Fazer pedido
                4 - Cancelar pedido
                """);*/
                inserirUsuario();
    }

    public static void inserirUsuario() {
        Usuario usuario = new Usuario();
        System.out.print("Digite seu nome: ");
        usuario.setNome(scan.nextLine());
        System.out.print("Digite seu email: ");
        usuario.setEmail(scan.nextLine());
        System.out.print("Digite sua senha: ");
        usuario.setSenha(scan.nextLine());
        System.out.print("Digite seu telefone: ");
        usuario.setTelefone(scan.nextLine());
        System.out.print("Digite seu cpf: ");  
        usuario.setCpf(scan.nextLine());
        System.out.print("Digite seu estado: ");
        usuario.setEstado(scan.nextLine());
        System.out.print("Digite sua cidade: ");
        usuario.setCidade(scan.nextLine());
        System.out.print("Digite seu cep: ");
        usuario.setCep(scan.nextLine());
        System.out.print("Digite seu bairro: ");
        usuario.setBairro(scan.nextLine());
        System.out.print("Digite sua rua: ");
        usuario.setRua(scan.nextLine());
        System.out.print("Digite o numero da sua casa: ");
        usuario.setNumeroCasa(scan.nextInt());
        UsuarioDao.inserirUsuario(usuario);
    }


    public void cancelarPedido(Pedido pedido) {
        Pedido pedidoCancelar = new Pedido();
        System.out.println("Digite o id do pedido que deseja cancelar:");
         pedidoCancelar.setIdPedido(scan.nextInt());
         PedidoDao.cancelarPedido(pedidoCancelar);    
    }
}
