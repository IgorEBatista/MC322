import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ClientePJ extends Cliente {
    private final String CNPJ; 
    private Date dataFundacao;
    private int num_funcionarios;
    private ArrayList<Frota> listaFrota;

    //Construtor
    public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao, int num_funcionarios) {
        super(nome, endereco);
        this.CNPJ = CNPJ.replaceAll("\\D", "");
        this.dataFundacao = dataFundacao;
        this.num_funcionarios = num_funcionarios;
        this.listaFrota = new ArrayList<Frota>();
    }    
    //Getters e Setters
    
    public String getCNPJ() {
        return CNPJ;
    }
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    public int getNum_funcionarios() {
        return num_funcionarios;
    }

    public void setNum_funcionarios(int num_funcionarios) {
        this.num_funcionarios = num_funcionarios;
    }
        
    public ArrayList<Frota> getListaFrota() {
        return listaFrota;
    }

    public void setListaFrota(ArrayList<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    public ArrayList<Veiculo> getlistaVeiculos(){
        ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
        for (Frota frota : getListaFrota()) {
            lista.addAll(frota.getlistaVeiculos());
        }   
        return lista;
    }

    //Outros métodos

    public boolean cadastrarFrota(Frota frota) {
        boolean funcionou = false;    
        funcionou = this.listaFrota.add(frota);
        return funcionou;
    }

    public Frota identFrota(String code) {
        Iterator<Frota> elem = this.listaFrota.iterator();
        while (elem.hasNext()) {
            Frota atual = (Frota)elem.next();
            if (atual.getCode().equals(code)) {
                return atual;
            }
        }
        return null;
    }

    public boolean atualizarFrota(String code, Veiculo veic, int modo){
        /**Modos de uso:
         * Modo 1 = Adicionar veículos
         * Modo 2 = Remover veiculos
         * Modo 3 = Apagar Frota
         */
        boolean agiu = true;
        Frota frota = identFrota(code);
        if (frota == null) {
            return false;
        }

        if (modo == 1) {
            frota.addVeiculo(veic);
        } else if (modo == 2){
            agiu = frota.remVeiculo(veic);
        } else if (modo == 3){
            agiu = listaFrota.remove(frota);
        } else {
            agiu = false;
        }
        this.setModificado(agiu);
        return agiu;
    }

    public ArrayList<Veiculo> getVeiculosPorFrota(String code) {
        Frota frota = identFrota(code);
        if (frota != null) {
            return frota.getlistaVeiculos();
        }
        return null;
    }

    public String toString() {
        String texto = super.toString();
                texto = texto.concat("\nCNPJ: " + CNPJ);
                texto = texto.concat("\nData de Fundacao: " + dataFundacao);
                texto = texto.concat("\nNúmero de Funcionários: " + num_funcionarios);
        return texto; 
    }

    public Veiculo ident_Veiculo(String placa) {
        for (Frota frota : listaFrota) {
            for (Veiculo veiculo : frota.getlistaVeiculos()) {
                if (veiculo.getplaca().equals(placa)) {
                    return veiculo;
                }
            }
        }
        return null;
    }
    
}
