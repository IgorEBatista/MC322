import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private LinkedList<Cliente> listaClientes;


    // Construtor
    public Seguradora (String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaClientes = new LinkedList<Cliente>();
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

    public LinkedList<Cliente> getListaClientes() {
        return listaClientes;
    }

    //Outros Métodos
    public String toString() {
        //Controle de string
            return ("Nome: " + getNome() +
                    "\nTelefone: " + getTelefone() +
                    "\nEmail: " + getEmail() +
                    "\nEndereço: " + getEndereco() + "\n" );
        }
        
    public Cliente identClient(String nome){
        Iterator<Cliente> elem = this.listaClientes.iterator();
        while (elem.hasNext()) {
            Cliente atual = (Cliente)elem.next();
            if (atual.getNome() == nome) {
                return atual;
            }
        }
        return null;
    }

    public boolean cadastrarCliente(Cliente cliente){
        return listaClientes.add(cliente);
    }

    public boolean removerCliente(String cliente){
        Cliente alvo = identClient(cliente);
        if(alvo == null) {System.out.println("Cliente não encontrado!");}
        return listaClientes.remove(alvo);
    }

    public void listarClientes(String tipoCliente){
        // Lista determinados clientes
        Iterator<Cliente> elem = this.listaClientes.iterator();
        int tipo = 0;
        if(tipoCliente == "ClientePJ"){ tipo = 1;}
        while (elem.hasNext()) {
            Cliente atual = (Cliente)elem.next();
            if ((tipo == 0 && atual instanceof ClientePF) || (tipo == 1 && atual instanceof ClientePJ)) {
                System.out.println(atual);
            }
        }
    }

    public boolean gerarSinistro(Sinistro sinistro) {
        return listaSinistros.add(sinistro);
    }

    public boolean visualizarSinistro(String nome) {
        boolean achou = false;
        Iterator<Sinistro> elem = this.listaSinistros.iterator();
        while (elem.hasNext()) {
            Sinistro atual = (Sinistro)elem.next();
            if (atual.getCliente().getNome() == nome) {
                achou = true;
                System.out.println(atual);
            }
        }
        return achou;
    }

    public void listarSinistros() {
        Iterator<Sinistro> elem = this.listaSinistros.iterator();
        
        if (listaSinistros.isEmpty()) {
            System.out.println("Não há nenehum sinistro cadastrado!");
        } else {
            while (elem.hasNext()) {
                Sinistro atual = (Sinistro)elem.next();
                System.out.println(atual);
            }
        }
    }

    public float calcularReceita(){return 1.01f;}

}