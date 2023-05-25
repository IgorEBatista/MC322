import java.util.ArrayList;

public class Frota {
    
    private String code;
    private ArrayList veiculos;

    //Constructors
    public Frota(String code) {
        this.code = code;
        this.veiculos = new ArrayList<Veiculo>();
    }

    public Frota(String code, ArrayList veiculos) {
        this.code = code;
        this.veiculos = veiculos;
    }
    
    
    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList veiculos) {
        this.veiculos = veiculos;
    }

    // Outros métodos
    public String toString() {
        
    }
}
