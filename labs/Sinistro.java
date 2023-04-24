import java.util.Date;

public class Sinistro {

    private static int serie;
    private final int id;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    //Construtor
    
    public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.id = serie + 100000;
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        serie++;
    }

    // Getters e setters
    public int getid (){
        return id;
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

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
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

    public String toString(){
        //Controle de string
        return ("ID: " + getid() + 
                "\nData: " + getdata() + 
                "\nEndereço: " + getendereco() + 
                "\nSeguradora: " + getSeguradora() + 
                "\nVeículo: " + getVeiculo() + 
                "\nCliente: " + getCliente().getNome() + "\n");
    }
}
