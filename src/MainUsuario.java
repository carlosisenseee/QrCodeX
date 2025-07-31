import dao.PedidoDao;
import java.util.Scanner;
import model.Pedido;
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

    public static void menu() {
        System.out.println("""
                Bem vindo ao QrCodeX
                1 - Cadastrar um produto
                2 - Cadastrar um usuario
                3 - Cadastrar um fornecedor
                1 - Gerar um QrCode
                2 - Ler um QrCode
                """);
    }
    public void cancelarPedido(Pedido pedido) {
        Pedido pedidoCancelar = new Pedido();
        System.out.println("Digite o id do pedido que deseja cancelar:");
         pedidoCancelar.setIdPedido(scan.nextInt());
         PedidoDao.cancelarPedido(pedidoCancelar);    
    }
}
