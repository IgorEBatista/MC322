import java.util.ArrayList;

public class Frota {
    
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    //Constructors
    public Frota(String code, Veiculo veiculo) {
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>();
        listaVeiculos.add(veiculo);
    }

    public Frota(String code, ArrayList<Veiculo> veiculos) {
        this.code = code;
        this.listaVeiculos = veiculos;
    }
    
    
    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getlistaVeiculos() {
        return listaVeiculos;
    }

    public void setlistaVeiculos(ArrayList<Veiculo> veiculos) {
        this.listaVeiculos = veiculos;
    }

    // Outros métodos


    public void addVeiculo(Veiculo veiculo){
        listaVeiculos.add(veiculo);
    }

    public boolean remVeiculo(Veiculo veiculo){
        boolean mod = listaVeiculos.remove(veiculo);
        return mod;
    }    



    public String toString() {
        String texto = "Codigo da Frota: " +  this.code;
        texto = texto.concat("\nLista de veículos:");
        for (Veiculo veiculo : listaVeiculos) {
            texto = texto.concat("\n" + veiculo);
        }
        return texto;
    }
}
