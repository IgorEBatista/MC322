public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;

    //Construtor
    public Veiculo (String placa, String marca, String modelo){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
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

    //Outros metodos

    public String toString() {
    //Controle de string
    return ("Placa: " + getplaca() + "\n" +
            "Marca: " + getmarca() + "\n" +
            "Modelo: " + getmodelo() + "\n");
    }
}
