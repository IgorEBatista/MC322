import java.util.ArrayList;

public class Frota {
    
    private String code;
    private ArrayList<Veiculo> lista_veiculos;

    //Constructors
    public Frota(String code) {
        this.code = code;
        this.lista_veiculos = new ArrayList<Veiculo>();
    }

    public Frota(String code, ArrayList<Veiculo> veiculos) {
        this.code = code;
        this.lista_veiculos = veiculos;
    }
    
    
    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getLista_veiculos() {
        return lista_veiculos;
    }

    public void setLista_veiculos(ArrayList<Veiculo> veiculos) {
        this.lista_veiculos = veiculos;
    }

    // Outros métodos


    public void addVeiculo(Veiculo veiculo){
        lista_veiculos.add(veiculo);
    }

    public boolean remVeiculo(Veiculo veiculo){
        boolean mod = lista_veiculos.remove(veiculo);
        return mod;
    }    



    public String toString() {
        
    }
}
