import java.util.*;

public class Lanchonete {
   public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
       List<Produto> produtos = new ArrayList<>();
       
       produtos.add(new Produto("Hambúrguer", 15.00, 50, "Comida"));
       produtos.add(new Produto("Refrigerante", 5.00, 100, "Bebida"));
       produtos.add(new Produto("Batata Frita", 10.00, 75, "Acompanhamento"));
       
       
       Produto produtoSelecionado;
       while(true){
            switch (exibirMenu(scan)) {
                case 1:
                    produtoSelecionado = selecionarProduto(scan, produtos);
                    System.out.print("Quantidade a vender: ");
                    int quantidade = scan.nextInt();
                    System.out.print("Aplicar desconto? (s/n): ");
                    char aplicarDesconto = scan.next().toLowerCase().charAt(0);

                    if (aplicarDesconto == 's') {
                        System.out.print("Informe o percentual de desconto: ");
                        double desconto = scan.nextDouble();
                        double totalComDesconto = produtoSelecionado.vender(quantidade, desconto);
                        if (totalComDesconto > 0) {
                            System.out.printf("Venda realizada com desconto: R$ %.2f\n", totalComDesconto);
                        }
                    } else {
                        double total = produtoSelecionado.vender(quantidade);
                        if (total > 0) {
                            System.out.printf("Venda realizada: R$ %.2f\n", total);
                        }
                    }
                    Console.pause();
                    break;
                case 2:
                    produtoSelecionado = selecionarProduto(scan, produtos);
                    System.out.print("Quantidade a comprar: ");
                    quantidade = scan.nextInt();
                    System.out.print("Incluir frete? (s/n): ");
                    char incluirFrete = scan.next().toLowerCase().charAt(0);
                    if (incluirFrete == 'n') {
                        double totalCompra = produtoSelecionado.comprar(quantidade);
                        if (totalCompra > 0) {
                            System.out.printf("Compra realizada: R$ %.2f\n", totalCompra);
                        }
                        Console.pause();
                        break;
                    }
                    double valorFrete = 0;
                    if (incluirFrete == 's') {
                        System.out.print("Valor do frete: ");
                        valorFrete = scan.nextDouble();
                    }
                    double totalCompra = produtoSelecionado.comprar(quantidade, valorFrete);
                    if (totalCompra > 0) {
                        System.out.printf("Compra realizada: R$ %.2f\n", totalCompra);
                    }
                    Console.pause();
                    break;
                case 3:
                    produtoSelecionado = selecionarProduto(scan, produtos);
                    System.out.print("Incluir imposto? (s/n): ");
                    char incluirImposto = scan.next().toLowerCase().charAt(0);
                    if (incluirImposto == 's') {
                        System.out.print("Percentual do imposto: ");
                        double imposto = scan.nextDouble();
                        double valorEstoque = produtoSelecionado.valorEmEstoque(imposto);
                        System.out.printf("Valor total em estoque de %s com imposto: R$ %.2f\n", produtoSelecionado.getNome(), valorEstoque);
                        Console.pause();
                        break;
                    }
                    double valorEstoque = produtoSelecionado.valorEmEstoque();
                    System.out.printf("Valor total em estoque de %s: R$ %.2f\n", produtoSelecionado.getNome(), valorEstoque);
                    Console.pause();
                    break;
                case 4:
                    produtoSelecionado = selecionarProduto(scan, produtos);
                    System.out.print("Mostrar estoque? (s/n): ");
                    char mostrarEstoque = scan.next().toLowerCase().charAt(0);
                    if (mostrarEstoque == 's') {
                        System.out.println(produtoSelecionado.exibirDetalhes(true));
                    } else {
                        System.out.println(produtoSelecionado.exibirDetalhes());
                    }
                    Console.pause();
                    break;
                case 0:
                    System.out.println("Encerrando o programa!");
                    scan.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    Console.pause();
                    break;
            }
       }

      

   }

   public static int exibirMenu(Scanner scan){
        Console.clear();
        System.out.println("\t\t=== Menu da Lanchonete ===\n");
        System.out.println("1. Vender Produto");
        System.out.println("2. Comprar Produto");
        System.out.println("3. Calcular Valor em Estoque");
        System.out.println("4. Exibir Detalhes do Produto");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return scan.nextInt();
   }

   public static Produto selecionarProduto(Scanner scan, List<Produto> produtos){
        System.out.println("\nProdutos Disponíveis:");
        for(int i = 0; i < produtos.size(); i++){
            System.out.printf("%d) %s\n", i + 1, produtos.get(i).getNome());
        }
        System.out.print("Selecione o produto pelo número: ");
        int escolha = scan.nextInt();
        System.out.println("Produto selecionado: " + produtos.get(escolha - 1).getNome()
        + ", Valor: R$ " + produtos.get(escolha - 1).getPreco());
        return produtos.get(escolha - 1);
   }




}
