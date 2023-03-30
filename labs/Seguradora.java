import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;


    // Construtor
    public Seguradora (String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // Getters e setters
    public String getNome (){
        return nome;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public String getTelefone (){
        return telefone;
    }

    public void setTelefone (String telefone){
        this.telefone = telefone;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public String getEndereco (){
        return endereco;
    }

    public void setEndereco (String endereco){
        this.endereco = endereco;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    //Outros Métodos
    public String toString() {
        //Controle de string
            return ("Nome: " + getNome() + "\n" +
                    "Telefone: " + getTelefone() + "\n" +
                    "Email: " + getEmail() + "\n" +
                    "Endereço: " + getEndereco() + "\n" );
        }
    
    public boolean cadastrarCliente(Cliente cliente){
        return false;
    }

    public boolean removerCliente(String cliente){
        return false;
    }

    public ArrayList<Cliente> listarClientes(String tipoCliente){
        // Lista determinados clientes
        ArrayList<Cliente> a = new ArrayList<Cliente>();
        
        return a;
    }

    public boolean gerarSinistro() {
        return false;
    }

    public boolean visualizarSinistro(String cliente) {
        return false;
    }

    public ArrayList<Sinistro> listarSinistros() {
        ArrayList<Sinistro> a = new ArrayList<Sinistro>();
        return a;
    }



}