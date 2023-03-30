import java.util.Date;
import java.util.Random;

public class Sinistro {

    private int id;
    private Date data;
    private String endereco;
    private Veiculo veiculo;
    private Cliente cliente;

    //Construtor
    
    

    public Sinistro(int id, Date data, String endereco, Veiculo veiculo, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.endereco = endereco;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    // Getters e setters
    public int getid (){
        return id;
    }

    public void setid (int id){
        this.id = id;
    }

    public Date getdata (){
        return data;
    }

    public void setdata (Date data){
        this.data = data;
    }

    public String getendereco (){
        return endereco;
    }

    public void setendereco (String endereco){
        this.endereco = endereco;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    //Outros Métodos

    public int gerarID(){
        //Gera um ID aleatório de 6 dígitos
        Random gerador = new Random();
        return gerador.nextInt(900000) + 100000;
    }

    public String toString(){
        //Controle de string
        return ("ID: " + getid() + "\n" +
                "Data: " + getdata() + "\n" +
                "Endereço: " + getendereco() + "\n" );
    }
}
