import java.util.Scanner;

/*
Ler da tabela tb_qrcode, que guarda as informacoes do pedido e do fornecedor
e apartir dos dados que o qrcode retornar fazer a pesquisa, como por exemplo, o qrcode com o dados 1, 1
sao o pedido 1 e o fornecedor 1, e apartir disso realizar o pedido
 */

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
        int opc = scan.nextInt();

        switch (opc) {
            case 1:
                System.out.println("Informe o");
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
                1 - Gerar um QrCode
                2 - Ler um QrCode
                """);
    }
}