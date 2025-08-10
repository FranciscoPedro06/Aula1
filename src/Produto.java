public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private String caminhoImagem;

    public Produto(int codigo, String descricao, double preco, String caminhoImagem) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.caminhoImagem = caminhoImagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                "\nDescrição: " + descricao +
                "\nPreço: R$ " + String.format("%.2f", preco) +
                "\nImagem: " + caminhoImagem + "\n";
    }
}
