public class Reserva{
    private int codigo;
    private String nomeHospede;
    private int diaria; //diarias
    private boolean incluirRefeição; // incluiRefeicoes;

    public Reserva(int codigo, String nome, int diaria){
        this.codigo = codigo;
        this.nomeHospede = nome;
        this.diaria = diaria;
        this.incluirRefeição = false;
    }

    public Reserva(int codigo, String nome, int diaria, boolean incluirRefeição){
        this.codigo = codigo;
        this.nomeHospede = nome;
        this.diaria = diaria;
        this.incluirRefeição = incluirRefeição;
    }

    public Double calcularDiaria(){
        Double valor = 200 * (double)this.diaria;
        if(incluirRefeição)
            valor += 50 * this.diaria;
        return valor;
    }

    public Double calcularDiaria(double taxa){
        Double valor = 200 * (double)this.diaria;
        if(incluirRefeição)
            valor += 50 * this.diaria;
        return valor + taxa;
    }
	
	public String getNome(){
		return this.nomeHospede;
	}

    public Double adicionarPasseio(String tipo){
        switch (tipo) {
            case "CAVALGADA", "cavalgada":
                return 80.0;
            case "trilha", "TRILHA":
                return 60.0;
            case "pesca", "PESCA":
                return 70.0; 
            default:
                return 0.0; 
        }

    }
   
    public Double adicionarPasseio(String tipo, int qtde){
        switch (tipo) {
            case "cavalgada", "CAVALGADA":
                return 80.0 * qtde;
            case "trilha", "TRILHA":
                return 60.0 * qtde;
            case "pesca", "PESCA":
                return 70.0 * qtde; 
            default:
                return 0.0; 
                
        }

    }
   
    public String exibirReserva(){
        return String.format("Reserva: %d\nHospede: %s\nDiárias: %d\n",
            this.codigo,
            this.nomeHospede,
            this.diaria
        );
        
    }

   
    public String exibirReserva(boolean comDetalhes){
        String texto = String.format("Reserva: %d\nHospede: %s\nDiárias: %d\n",
            this.codigo,
            this.nomeHospede,
            this.diaria
        );
        if(comDetalhes){
            if(incluirRefeição){
                texto += "Refeições inclusas: Sim";
            }else{
                texto += "Refeições inclusas: Não";
            }
        }
        return texto;
    }
    


} //Faltam getters e setters
