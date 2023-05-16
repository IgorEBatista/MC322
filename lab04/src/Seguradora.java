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
            if (atual.getNome().equals(nome)) {
                return atual;
            }
        }
        return null;
    }
    public Cliente identClient(Long CPF){
        Iterator<Cliente> elem = this.listaClientes.iterator();
        if (CPF > (10^12)) {
            while (elem.hasNext()) {
                ClientePJ atual = (ClientePJ)elem.next();
                if (atual.getCNPJ().equals(String.valueOf(CPF)) ) {
                    return atual;
                }
            }
        } else {
            while (elem.hasNext()) {
                ClientePF atual = (ClientePF)elem.next();
                if (atual.getCPF().equals(String.valueOf(CPF)) ) {
                    return atual;
                }
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
        if(tipoCliente.equals("ClientePJ")){ tipo = 1;}
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
            if (atual.getCliente().getNome().equals(nome)) {
                achou = true;
                System.out.println(atual);
            }
        }
        return achou;
    }

    public ArrayList<Sinistro> listarSinistros(Cliente cliente) {
        Iterator<Sinistro> elem = this.listaSinistros.iterator();
        ArrayList<Sinistro> lista_nova = new ArrayList<Sinistro>();
        while (elem.hasNext()) {
            Sinistro atual = (Sinistro)elem.next();
            lista_nova.add(atual);
        }
        return lista_nova;
    }

    public boolean removerSinistro(Sinistro sinistro) {
        return this.listaSinistros.remove(sinistro);
    }

    public double calcularPrecoSeguroCliente(Cliente cliente){
        return (cliente.calculaScore() * (1 + listarSinistros(cliente).size()));
    }

    public double calcularReceita(){
        double total = 0.0;
        Iterator<Cliente> elem = this.listaClientes.iterator();
        while (elem.hasNext()) {
            Cliente atual = (Cliente)elem.next();
            if (atual.isModificado()) {
                atual.setPreco_seguro(calcularPrecoSeguroCliente(atual));
            }
            total += atual.getPreco_seguro();
        }
        return total;
    }

    public static Seguradora ident_Seguradora(LinkedList<Seguradora> lista, String nome) {
        Iterator<Seguradora> elem = lista.iterator();
        while (elem.hasNext()) {
            Seguradora atual = (Seguradora)elem.next();
            if (atual.getNome().equals(nome)) {
                return atual;
            }
        }
        return null;        
    }

}