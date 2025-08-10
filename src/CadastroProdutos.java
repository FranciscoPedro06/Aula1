import java.io.File;                          // Manipulação de arquivos e pastas
import java.io.IOException;                   // Tratamento de erros de entrada/saída
import java.nio.file.Files;                   // Cópia de arquivos
import java.nio.file.Path;                    // Representa o caminho do arquivo
import java.nio.file.StandardCopyOption;      // Opção de substituição de arquivo
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroProdutos {
    private ArrayList<Produto> produtos = new ArrayList<>();

    // Pasta de imagens criada automaticamente no usuário atual
    private static final String PASTA_IMAGENS = System.getProperty("user.home") + "/ProdutosImagens/";

    public void cadastrar(Scanner scan) {
        try {
            System.out.print("Qual o código do produto: ");
            int codigo = scan.nextInt();
            scan.nextLine();

            System.out.print("Qual a descrição: ");
            String descricao = scan.nextLine();

            System.out.print("Qual o preço: ");
            double preco = scan.nextDouble();
            scan.nextLine();

            System.out.print("Qual a imagem (caminho completo): ");
            String caminhoOrigem = scan.nextLine();
            // Exemplo: C:/Users/SeuUsuario/Downloads/imagem.png

            // cria a pasta destino se ela não existir
            File pasta = new File(PASTA_IMAGENS);
            if (!pasta.exists()) {
                pasta.mkdirs(); // cria a pasta
            }

            // copia a imagem para a pasta
            File arquivoOrigem = new File(caminhoOrigem); // Arquivo original informado pelo usuário
            Path destino = new File(PASTA_IMAGENS + arquivoOrigem.getName()).toPath();
            Files.copy(arquivoOrigem.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
            // Copia o arquivo para a pasta destino (substitui se já existir)

            // salva o produto na lista
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
}
