import java.util.*;

public class Hotel{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Reserva r1 = new Reserva(01, "Pedro", 10);
        Reserva r2 = new Reserva(02, "Arthur", 5, true);
        Reserva n;
        double valor;
        while(true){
            
            switch(menu(scan)){
                case 1:
                    n = escolha(scan, r1, r2);
                    System.out.printf("Adicionar taxa? (s/n)");
                    char taxa = scan.next().toLowerCase().charAt(0);
                    if(taxa == 's'){
                        System.out.printf("valor da taxa? ");
                        double v = scan.nextDouble();
                        valor = n.calcularDiaria(v);
                    }else{
                        valor = n.calcularDiaria();
                    }
                    System.out.println("Valor: R$" + valor);
                    break;
                case 2: 
                    n = escolha(scan, r1, r2);
                    System.out.printf("Qual tipo de passeio? ");
                    String tipo = scan.nextLine();
                    System.out.printf("Quantidade? ");
                    int q = scan.nextInt();
                    if(q <= 1){
                        valor = n.adicionarPasseio(tipo);
                    }else{
                        valor = n.adicionarPasseio(tipo, q);
                    }
                     System.out.println("Valor: R$" + valor);
                    break;
                case 3: 
                    System.out.printf("Exibir Detalhes? s/n");
                    char d = scan.next().toLowerCase().charAt(0);
                    if(d == 's'){
                        System.out.println(r1.exibirReserva(true));
                        System.out.println(r2.exibirReserva(true));
                    }else{
                        System.out.println(r1.exibirReserva());
                        System.out.println(r2.exibirReserva());
                    }
                    break;
                case 0: return;


            }


        }

    }

    static int menu(Scanner scan){
        System.out.println("\t=Menu de opções=\n");
        System.out.println("1. Calcular Diaria");
        System.out.println("2. Adicionar Passeio");
        System.out.println("3. Ver Reservas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scan.nextInt();
        return opcao;
    }

    static Reserva escolha(Scanner scan, Reserva r1, Reserva r2){
        
        System.out.println(r1.getNome());
        System.out.println(r2.getNome());
        System.out.println("\nQuem?");
        scan.nextLine();
        String quem = scan.nextLine();
        
        Reserva a;
        if(quem == "pedro"){ //if(quem.equals("pedro"){ ou if(quem.equalsIgnoreCase("pedro"){
            a = r1;
        }else if(quem == "arthur"){
            a = r2;
        }else{
            a = null;
        }
        return a;
    }

}
