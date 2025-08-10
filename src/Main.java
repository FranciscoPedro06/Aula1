import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastro.cadastrar(sc);
                    break;
                case 2:
                    cadastro.editar(sc);
                    break;
                case 3:
                    cadastro.excluir(sc);
                    break;
                case 4:
                    cadastro.listar();
                    break;
                case 5:
                    cadastro.vender(sc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
