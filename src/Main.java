import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CadastroProdutos cadastro = new CadastroProdutos();
        int opcao;

        do {
            System.out.println("\n1 - Cadastrar produto");
            System.out.println("2 - Editar produto");
            System.out.println("3 - Excluir produto");
            System.out.println("4 - Listar produtos");
            System.out.println("5 - Vender");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastro.cadastrar(scan);
                    break;
                case 2:
                    cadastro.editar(scan);
                    break;
                case 3:
                    cadastro.excluir(scan);
                    break;
                case 4:
                    cadastro.listar();
                    break;
                case 5:
                    cadastro.vender(scan);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scan.close();
    }
}
