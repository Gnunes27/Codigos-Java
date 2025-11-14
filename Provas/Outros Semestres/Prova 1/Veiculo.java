public class Veiculo{
    private String placa;
    private String modelo;
    private String tipo;
    private int quilometragem;

    public Veiculo(String placa, String modelo, String tipo){
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.quilometragem = 0;
    }

    public Veiculo(String placa, String modelo, String tipo, int quilometragem){
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.quilometragem = quilometragem;
    }

    private double getValorDiariaBase() {
        switch (this.tipo) {
            case "economico":
                return 100.0;
            case "suv":
                return 150.0;
            case "luxo":
                return 250.0; 
            default:
                return 0.0; 
        }
    }

    public double locacao(int dias){
        double valorDiaria = getValorDiariaBase(); 
        double kms = dias * 100; // Quilometragem padrão por dia
        double loc;

        loc = (dias * valorDiaria) + (kms * 0.10);
        
        this.quilometragem += kms;
        return loc;
    }

    public double locacao(int dias, int km){
        double valorDiaria = getValorDiariaBase();
        double kms = km < 0 ? 0 : km * dias;
        double loc;

        loc = (dias * valorDiaria) + (kms * 0.10);

        this.quilometragem += kms;
        return loc;
    }

    public double locacao(int dias, int km, boolean seguro){
        double loc;
        double valorDiaria = getValorDiariaBase();
        double kms = km < 0 ? 0 : km * dias;

        if (seguro){
            valorDiaria += 50; // Adiciona o custo do seguro por dia
        }
        
        loc = (dias * valorDiaria) + (kms * 0.10);

        this.quilometragem += kms;
        return loc;
    }
    
    public String getplaca(){
        return this.placa;
    }
    public String getModelo(){
        return this.modelo;
    }
    public String getTipo(){
        return this.tipo;
    }
    public int getQuilometragem(){
        return this.quilometragem;
    }

    public double valorLocacao(){
        if(this.tipo.equals("economico")){
            return 100;
        } else if (this.tipo.equals("suv")){
            return 150;
        } else if (this.tipo.equals("luxo")){
            return 250;
        } else {
            return 0; // Tipo desconhecido
        }
    }

    public String detalhes(){
        return String.format("Placa: %s\n Modelo: %s\n Tipo: %s\n Quilometragem: %d\nValor da Locação por dia: %.2f\n",
            this.placa, 
            this.modelo, 
            this.tipo, 
            this.quilometragem,
            this.valorLocacao()
        );
    }

}