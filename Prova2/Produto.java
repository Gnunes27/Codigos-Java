public class Produto {
    private String nome;
    private double preco;
    private int estoque;
    private String categoria;

    public Produto(String nome, double preco, int estoque, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public double vender(int quantidade) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
            return preco * quantidade;
        } else {
            System.out.println("Estoque insuficiente para o produto: " + nome);
            return 0;
        }
    }

    public double vender(int quantidade, double desconto) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
            double total = preco * quantidade;
            return total - (total * desconto / 100);
        } else {
            System.out.println("Estoque insuficiente para o produto: " + nome);
            return 0;
        }
    }

    public double comprar(int quantidade) {
        estoque += quantidade;
        return preco * quantidade;
    }

    public double comprar(int quantidade, double frete) {
        estoque += quantidade;
        double total = preco * quantidade;
        return total + frete;
    }

    public double valorEmEstoque() {
        return preco * estoque;
    }

    public double valorEmEstoque(double imposto) {
        double total = preco * estoque;
        return total + (total * imposto / 100);
    }

    public String exibirDetalhes(){
        return String.format("Produto: %s\nCategoria: %s\nPreço: R$ %.2f\n", 
                             nome, categoria, preco);
    }

    public String exibirDetalhes(boolean mostrarEstoque){
        String detalhes = String.format("Produto: %s\nCategoria: %s\nPreço: R$ %.2f\n", 
                                nome, categoria, preco);
        if (mostrarEstoque) {
            detalhes += String.format("Estoque: %d unidades\n", estoque);
        }
        return detalhes;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }


}