import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Veiculo> veiculos = new ArrayList<>(3);
       // Em vez do loop for:
       veiculos.add(new Veiculo("ABC1234", "Gol", "economico"));
       veiculos.add(new Veiculo("DEF5678", "Renegade", "suv", 5000));
       veiculos.add(new Veiculo("GHI9012", "BMW X6", "luxo"));

       exibirVeiculos(veiculos);

       while(true){
            System.out.print("Selecione o veículo pela placa (ou digite 'sair' para encerrar): ");
            String placaInput = scan.nextLine();
            if (placaInput.equalsIgnoreCase("sair")) {
                break;
            }

            Console.clear();

            Veiculo veiculoSelecionado = null;
            for (Veiculo v : veiculos) {
                if (v.getplaca().equalsIgnoreCase(placaInput)) {
                    veiculoSelecionado = v;
                    break;
                }
            }

            if (veiculoSelecionado == null) {
                System.out.println("Veículo não encontrado. Tente novamente.");
                Console.pause();
                continue;
            }
            

            boolean sairVeiculo = false;
            while (!sairVeiculo) {
                
            
                switch (menu(scan)) {
                    case 1:
                        System.out.print("Digite o número de dias para locação: ");
                        int dias = scan.nextInt();
                        double valorLocacao = veiculoSelecionado.locacao(dias);
                        System.out.printf("Valor da locação: R$ %.2f\n", valorLocacao);
                        break;
                    case 2:
                        System.out.print("Digite o número de dias para locação: ");
                        dias = scan.nextInt();
                        System.out.print("Digite o número de quilômetros previstos: ");
                        int km = scan.nextInt();
                        valorLocacao = veiculoSelecionado.locacao(dias, km);
                        System.out.printf("Valor da locação: R$ %.2f\n", valorLocacao);
                        break;
                    case 3:
                        System.out.print("Digite o número de dias para locação: ");
                        dias = scan.nextInt();
                        System.out.print("Digite o número de quilômetros previstos: ");
                        km = scan.nextInt();
                        System.out.print("Deseja incluir seguro? (true/false): ");
                        boolean seguro = scan.nextBoolean();
                        valorLocacao = veiculoSelecionado.locacao(dias, km, seguro);
                        System.out.printf("Valor da locação: R$ %.2f\n", valorLocacao);
                        break;
                    case 4:
                        System.out.println("Detalhes do veículo:");
                        System.out.println(veiculoSelecionado.detalhes());
                        break;
                    case 5:
                        Console.clear();
                        exibirVeiculos(veiculos);
                        sairVeiculo = true;
                        break;
                    case 0:
                        System.out.println("Encerrando o programa.");
                        return;
                    default:
                        break;
                }
            }
            scan.nextLine(); // Limpar o buffer do scanner

        }
      

    }

    static Veiculo cadastrarVeiculo(List<Veiculo> veiculos, Scanner scan){
         System.out.print("Digite a placa do veículo: ");
            String placa = scan.nextLine();
            System.out.print("Digite o modelo do veículo: ");
            String modelo = scan.nextLine();
            System.out.print("Digite o tipo do veículo (economico, suv, luxo): ");
            String tipo = scan.nextLine();
            System.out.print("Digite a quilometragem do veículo: (ou deixe vazio para 0) ");
            String quilometragemInput = scan.nextLine();
            if (quilometragemInput.isEmpty()) {
                Veiculo veiculo = new Veiculo(placa, modelo, tipo); // km = 0
                return veiculo;
            } else {
               Veiculo veiculo = new Veiculo(placa, modelo, tipo, Integer.parseInt(quilometragemInput));
               return veiculo;
            }
    }

    static void exibirVeiculos(List<Veiculo> veiculos){
        String tabela = String.format("%-10s %-15s %-10s %-15s\n",
        "Placa",
                "Modelo", 
                "Tipo", 
                "Quilometragem");
        for (Veiculo v : veiculos){
            tabela += String.format("%-10s %-15s %-10s %-15d\n",
            v.getplaca(),
            v.getModelo(),
            v.getTipo(),
            v.getQuilometragem());
        }
        System.out.println(tabela);
    }
      
    static int menu(Scanner scan){
        System.out.println("Menu de opções:");
        System.out.println("1. Locar veículo por dias");
        System.out.println("2. Locar veículo por dias e quilômetros");
        System.out.println("3. Locar veículo por dias, quilômetros e seguro");
        System.out.println("4. Exibir informações do veículo");
        System.out.println("5. Sair e selecionar outro veículo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scan.nextInt();
        return opcao;
    }


 }


