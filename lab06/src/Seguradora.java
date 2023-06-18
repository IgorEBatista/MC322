import java.util.ArrayList;
import java.util.Iterator;

public class Seguradora {
    private final String CNPJ;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Seguro> listaSeguros;


    // Construtor
    public Seguradora (String CNPJ, String nome, String telefone, String email, String endereco){
        this.CNPJ = Validacao.limpaNum(CNPJ);
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.listaClientes = new ArrayList<Cliente>();
        this.listaSeguros = new ArrayList<Seguro>();
    }

    // Getters e setters
    public String getCNPJ(){
        return this.CNPJ;
    }
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

    public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    //Outros Métodos
    public String toString() {
        //Controle de string
        String texto = "Nome: " + getNome();
        texto = texto.concat("\nCNPJ: " + getCNPJ());
        texto = texto.concat("\nTelefone: " + telefone);
        texto = texto.concat("\nEmail: " + email);
        texto = texto.concat("\nEndereço: " + endereco);
        texto = texto.concat("\nLista de Clientes:");
        for (Cliente cliente : listaClientes) {
            texto = texto.concat("\n" + cliente);
            texto = texto.concat("\nSeguros desse cliente:");
            for (Seguro seguro : getSegurosPorCliente(cliente)) {
                texto = texto.concat("\n" + seguro);
            }
        }
        texto = texto.concat("\nNumero total de seguros: " + listaSeguros.size());
        return texto;
        }
        
    public Cliente identClient(String cad){
        Iterator<Cliente> elem = this.listaClientes.iterator();
        Long cadL = Long.parseLong(cad); 
        if ( cadL.longValue() > (100000000000L)) {
            while (elem.hasNext()) {
                Cliente atual = elem.next();
                if (atual.getClass() == ClientePJ.class) {
                    if (((ClientePJ)atual).getCNPJ().equals(cad)) {
                        return atual;
                    }
                }
            }
        } else {
            while (elem.hasNext()) {
                ClientePF atual = (ClientePF)elem.next();
                if (atual.getClass() == ClientePF.class) {
                    if (((ClientePF)atual).getCPF().equals(cad)) {
                        return atual;
                    }
                }
            }
        }
        return null;
    }

    public boolean cadastrarCliente(Cliente cliente){
        return listaClientes.add(cliente);
    }

    public boolean removerCliente(String cad){
        Cliente alvo = identClient(cad);
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

    public Boolean gerarSeguro(ClientePJ cliente, Frota frota) {
        return listaSeguros.add(new SeguroPJ(this, frota, cliente));       
    }
        
    public Boolean gerarSeguro(ClientePF cliente, Veiculo veiculo) {
        return listaSeguros.add(new SeguroPF(this, veiculo, cliente));       
    }

    public Boolean cancelarSeguro(Seguro seguro) {
        return listaSeguros.remove(seguro);
    }

    public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente) {
        ArrayList<Seguro> lista_nova = new ArrayList<Seguro>();
        Iterator<Seguro> elem = this.listaSeguros.iterator();
        while (elem.hasNext()) {
            Seguro atual = (Seguro)elem.next();
            if (atual.getCliente() == cliente) {
                lista_nova.add(atual);
            }
        }
        return lista_nova;
    }

    public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente) {
        ArrayList<Sinistro> lista = new ArrayList<Sinistro>();
        
        for (Seguro seguro : this.listaSeguros) {
            if (seguro.getCliente() == cliente) {
                lista.addAll(seguro.getListaSinistros());
                for (Condutor condutor : seguro.getListaCondutores()) {
                    lista.addAll(condutor.getListaSinistros());
                }
            }
        }

        return lista;
    }

    public double calcularReceita(){
        int total = 0;
        Iterator<Seguro> elem = this.listaSeguros.iterator();
        while (elem.hasNext()) {
            Seguro atual = (Seguro)elem.next();
            if (atual.getCliente().isModificado() || !atual.getAtualizado()) {
                atual.atualizarValor();
            }
            total += atual.getValorMensal();
        }
        return total;
    }

    public static Seguradora ident_Seguradora(ArrayList<Seguradora> lista, String nome) {
        Iterator<Seguradora> elem = lista.iterator();
        while (elem.hasNext()) {
            Seguradora atual = (Seguradora)elem.next();
            if (atual.getNome().equals(nome)) {
                return atual;
            }
        }
        return null;        
    }

    public Seguro identSeguro(String placa) {
        for (Seguro seguro : listaSeguros) {
            if (seguro.getClass() == SeguroPF.class) {
                if (((SeguroPF)seguro).getVeiculo().getplaca().equals(placa)) {
                    return seguro;   
                }
            } else {
                for (Veiculo vei_atual : ((SeguroPJ)seguro).getFrota().getlistaVeiculos()) {
                    if (vei_atual.getplaca().equals(placa)) {
                        return seguro;
                    }
                }                
            }
        }
        return null;
    }

}