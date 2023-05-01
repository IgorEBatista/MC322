public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

   
    //Construtor
    public Veiculo (String placa, String marca, String modelo, int anoFabricacao){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }
    // Getters e setters
    public String getplaca (){
        return placa;
    }

    public void setplaca (String placa){
        this.placa = placa;
    }

    public String getmarca (){
        return marca;
    }

    public void setmarca (String marca){
        this.marca = marca;
    }

    public String getmodelo (){
        return modelo;
    }

    public void setmodelo (String modelo){
        this.modelo = modelo;
    }

    public int getanoFabricacao() {
        return anoFabricacao;
    }

    public void setanoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    //Outros metodos

    public String toString() {
    //Controle de string
    return ("Placa: " + getplaca() + "\n" +
            "Marca: " + getmarca() + "\n" +
            "Modelo: " + getmodelo() + "\n" +
            "Ano de Fabricação: " + getanoFabricacao());
    }
}
