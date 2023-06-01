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

    //Outros métodos

    public boolean cadastrarFrota(String code) {
        boolean funcionou = false;
        Frota nFrota = null;
        if (enc_Frota(code) == null) {
            nFrota = new Frota(code);
            funcionou = this.listaFrota.add(nFrota);
        }
        return funcionou;
    }

    public Frota enc_Frota(String code) {
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
        boolean agiu = true;
        Frota frota = enc_Frota(code);

        if (modo == 1) {
            frota.addVeiculo(veic);
        } else if (modo == 2){
            agiu = frota.remVeiculo(veic);
        } else {
            System.out.println("Opção não encontrada");
            agiu = false;
        }
        this.setModificado(agiu);
        return agiu;
    }

    public ArrayList<Veiculo> getVeiculosPorFrota() {
        terminar
    }

    public double calculaScore() {
        return CalcSeguro.VALOR_BASE.getOperacao() * (1 + (num_funcionarios/100) * getLista_Veiculos().size());
    }

    public String toString() {
        return (super.toString() + 
                "\nCNPJ: " + CNPJ + 
                "\nData de Fundacao: " + dataFundacao +
                "\nNúmero de Funcionários: " + num_funcionarios);
    }
    
}
