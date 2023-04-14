import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> lista_Veiculos;
    
    // Construtor
    
    public Cliente (String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
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
    
    //Outros metodos

    public String toString() {
    //Controle de string
        return ("Nome: " + getNome() + "\nEndereço: " + getEndereco());
    }
    
}