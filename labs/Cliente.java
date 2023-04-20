import java.util.LinkedList;

public class Cliente {
    private String nome;
    private String endereco;
    private LinkedList<Veiculo> lista_Veiculos;
    
    // Construtor

    public Cliente (String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.lista_Veiculos = new LinkedList<Veiculo>();
    }
    
    // Getters e setters
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public LinkedList<Veiculo> getLista_Veiculos() {
        return lista_Veiculos;
    }

    //Outros metodos

    public void addVeiculo(Veiculo veiculo){
        lista_Veiculos.add(veiculo);
    }

    public boolean remVeiculo(Veiculo veiculo){
        return lista_Veiculos.remove(veiculo);
    }    

    public String toString() {
    //Controle de string
        return ("Nome: " + getNome() + "\nEndereço: " + getEndereco());
    }
    
}