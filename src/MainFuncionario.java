import dao.*;
import java.util.Scanner;
import model.*;

/*
Ler da tabela tb_qrcode, que guarda as informacoes do pedido e do fornecedor
e apartir dos dados que o qrcode retornar fazer a pesquisa, como por exemplo, o qrcode com o dados 1, 1
sao o pedido 1 e o fornecedor 1, e apartir disso realizar o pedido
 */

public class MainFuncionario {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            menu();
            int opc = scan.nextInt();

            switch (opc) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    cadastrarFornecedor();
                    break;
                case 4:

                case 10:
                    System.out.println("Saindo");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("""
                Bem vindo ao QrCodeX
                1 - Cadastrar um produto - ok
                2 - Cadastrar um usuario - ok
                3 - Cadastrar um fornecedor - ok
                4 - Alterar um produto -
                5 - Alterar um usuario -
                6 - Alterar um fornecedor -
                7 - Excluir um produto -
                8 - Excluir um usuario -
                9 - Excluir um fornecedor -
                1 - Gerar um QrCode
                2 - Ler um QrCode
                10 - Sair
                """);
        System.out.print("Informe sua opção: ");
    }

    public static void cadastrarProduto() {
        Scanner scan = new Scanner(System.in);
        Produto p = new Produto();
        System.out.println("- Cadastro de Produto -");
        System.out.println("Informe o nome do produto: ");
        p.setNome(scan.nextLine());
        System.out.println("Informe a descrição do produto: ");
        p.setDescricao(scan.nextLine());
        System.out.println("Informe a quantidade em estoque: ");
        p.setQuantidade(scan.nextInt());
        System.out.println("Informe o preço: ");
        p.setPreco(scan.nextDouble());

        ProdutoDao.inserirProduto(p);
    }

    public static void cadastrarUsuario() {
        Scanner scan = new Scanner(System.in);
        Usuario u = new Usuario();

        System.out.println("- Cadastro de Usuario -");
        System.out.println("Informe o nome do usuario: ");
        u.setNome(scan.nextLine());
        System.out.println("Informe o email do usuario: ");
        u.setEmail(scan.nextLine());
        System.out.println("Informe a senha do usuario: ");
        u.setSenha(scan.nextLine());
        System.out.println("Informe o telefone do usuario: ");
        u.setTelefone(scan.nextLine());
        System.out.println("Informe o CPF do usuario: ");
        u.setCpf(scan.nextLine());
        String[] estados = {
                "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
                "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
                "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        };
        System.out.println("Escolha o estado do usuario (digite o número correspondente):");
        for (int i = 0; i < estados.length; i++) {
            System.out.printf("%2d - %s\n", i + 1, estados[i]);
        }
        int opcaoEstado = scan.nextInt();
        scan.nextLine(); // Consumir quebra de linha após nextInt
        if (opcaoEstado >= 1 && opcaoEstado <= estados.length) {
            u.setEstado(estados[opcaoEstado - 1]);
        } else {
            System.out.println("Estado inválido! Definido como 'AC' por padrão.");
            u.setEstado("AC");
        }
        System.out.println("Informe a cidade do usuario: ");
        u.setCidade(scan.nextLine());
        System.out.println("Informe o CEP do usuario: ");
        u.setCep(scan.nextLine());
        System.out.println("Informe o bairro do usuario: ");
        u.setBairro(scan.nextLine());
        System.out.println("Informe a rua do usuario: ");
        u.setRua(scan.nextLine());
        System.out.println("Informe o número da casa: ");
        u.setNumeroCasa(scan.nextInt());

        UsuarioDao.inserirUsuario(u);
    }

    public static void cadastrarFornecedor() {
        Scanner scan = new Scanner(System.in);
        Fornecedor f = new Fornecedor();

        System.out.println("- Cadastro de Fornecedor -");

        System.out.println("Informe o nome do fornecedor: ");
        f.setNome(scan.nextLine());

        System.out.println("Informe o email do fornecedor: ");
        f.setEmail(scan.nextLine());

        System.out.println("Informe a senha do fornecedor: ");
        f.setSenha(scan.nextLine());

        System.out.println("Informe o telefone do fornecedor: ");
        f.setTelefone(scan.nextLine());

        System.out.println("Informe o CNPJ do fornecedor: ");
        f.setCnpj(scan.nextLine());

        String[] estados = {
                "AC","AL","AP","AM","BA","CE","DF","ES","GO",
                "MA","MT","MS","MG","PA","PB","PR","PE","PI",
                "RJ","RN","RS","RO","RR","SC","SP","SE","TO"
        };

        System.out.println("Escolha o estado do fornecedor (digite o número correspondente):");
        for (int i = 0; i < estados.length; i++) {
            System.out.printf("%2d - %s\n", i + 1, estados[i]);
        }
        int opcaoEstado = scan.nextInt();
        scan.nextLine();
        if (opcaoEstado >= 1 && opcaoEstado <= estados.length) {
            f.setEstado(estados[opcaoEstado - 1]);
        } else {
            System.out.println("Estado inválido! Definido como 'AC' por padrão.");
            f.setEstado("AC");
        }

        System.out.println("Informe a cidade do fornecedor: ");
        f.setCidade(scan.nextLine());

        System.out.println("Informe o CEP do fornecedor: ");
        f.setCep(scan.nextLine());

        System.out.println("Informe o bairro do fornecedor: ");
        f.setBairro(scan.nextLine());

        System.out.println("Informe a rua do fornecedor: ");
        f.setRua(scan.nextLine());

        System.out.println("Informe o número da casa: ");
        f.setNEmpresa(scan.nextInt());
        scan.nextLine();

        FornecedorDao.inserirFornecedor(f);
    }
}
