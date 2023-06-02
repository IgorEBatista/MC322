import java.util.Iterator;
import java.util.LinkedList;

public abstract class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private boolean modificado;
    private double preco_seguro;
    
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

    
    public double getPreco_seguro() {
        return preco_seguro;
    }

    public void setPreco_seguro(double preco_seguro) {
        this.preco_seguro = preco_seguro;
        this.modificado = false;
    }

    //Outros metodos


    public abstract Veiculo ident_Veiculo(String placa) { //TODO alterar
        Iterator<Veiculo> elem = this.lista_Veiculos.iterator();
        while (elem.hasNext()) {
            Veiculo atual = (Veiculo)elem.next();
            if (atual.getplaca().equals(placa)) {
                return atual;
            }
        }
        return null;
    }

    public abstract double calculaScore();

    public String toString() {
    //Controle de string
        return ("Nome: " + getNome() + 
                "\nEndereço: " + getEndereco());
    }
    
}