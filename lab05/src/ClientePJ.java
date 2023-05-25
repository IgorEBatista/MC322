import java.util.Date;

public class ClientePJ extends Cliente {
    private final String CNPJ; 
    private Date dataFundacao;
    private int num_funcionarios;
    
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


    //Outros métodos

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
