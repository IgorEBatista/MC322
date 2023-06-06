import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    private boolean modificado;
    
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
    

    public boolean isModificado() {
        return modificado;
    }

    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }

    public abstract ArrayList<Veiculo> getlistaVeiculos();

    //Outros metodos


    public abstract Veiculo ident_Veiculo(String placa);

    public String toString() {
        //Controle de string
        String texto = "Nome: " + nome;
        texto = texto.concat("\nEndereço: " + endereco);
        texto = texto.concat("\nTelefone: " + telefone);
        texto = texto.concat("\nEmail: " + email);
        return texto;    
    
    }
}