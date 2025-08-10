import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroProdutos {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private static final String PASTA_IMAGENS = System.getProperty("user.home") + "/ProdutosImagens/";

    public void cadastrar(Scanner sc) {
        try {
            System.out.print("Qual o código do produto: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            System.out.print("Qual a descrição: ");
            String descricao = sc.nextLine();

            System.out.print("Qual o preço: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            System.out.print("Qual a imagem (caminho completo): ");
            String caminhoOrigem = sc.nextLine();

            File pasta = new File(PASTA_IMAGENS);
            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            File arquivoOrigem = new File(caminhoOrigem);
            Path destino = new File(PASTA_IMAGENS + arquivoOrigem.getName()).toPath();
            Files.copy(arquivoOrigem.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);

            produtos.add(new Produto(codigo, descricao, preco, destino.toString()));
            System.out.println("Produto cadastrado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao copiar imagem: " + e.getMessage());
        }
    }

    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    public void editar(Scanner sc) {
        System.out.print("Informe o código do produto que deseja editar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Produto produtoEncontrado = null;
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                produtoEncontrado = p;
                break;
            }
        }

        if (produtoEncontrado == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.println("Produto encontrado: ");
        System.out.println(produtoEncontrado);

        System.out.print("Nova descrição (enter para manter): ");
        String descricao = sc.nextLine();
        if (!descricao.isEmpty()) {
            produtoEncontrado.setDescricao(descricao);
        }

        System.out.print("Novo preço (digite -1 para manter): ");
        double preco = sc.nextDouble();
        sc.nextLine();
        if (preco >= 0) {
            produtoEncontrado.setPreco(preco);
        }

        System.out.print("Novo caminho da imagem (enter para manter): ");
        String caminhoImagem = sc.nextLine();
        if (!caminhoImagem.isEmpty()) {
            try {
                File pasta = new File(PASTA_IMAGENS);
                if (!pasta.exists()) {
                    pasta.mkdirs();
                }
                File arquivoOrigem = new File(caminhoImagem);
                Path destino = new File(PASTA_IMAGENS + arquivoOrigem.getName()).toPath();
                Files.copy(arquivoOrigem.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
                produtoEncontrado.setCaminhoImagem(destino.toString());
            } catch (IOException e) {
                System.out.println("Erro ao copiar nova imagem: " + e.getMessage());
            }
        }

        System.out.println("Produto atualizado com sucesso!");
    }

    public void excluir(Scanner sc) {
        System.out.print("Informe o código do produto que deseja excluir: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Produto produtoEncontrado = null;
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                produtoEncontrado = p;
                break;
            }
        }

        if (produtoEncontrado == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        produtos.remove(produtoEncontrado);
        System.out.println("Produto excluído com sucesso!");
    }

    public void vender(Scanner sc) {
        System.out.print("Informe o código do produto que deseja vender: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Produto produtoEncontrado = null;
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                produtoEncontrado = p;
                break;
            }
        }

        if (produtoEncontrado == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.println("Produto vendido: ");
        System.out.println(produtoEncontrado);

        produtos.remove(produtoEncontrado);
        System.out.println("Venda realizada com sucesso!");
    }
}
