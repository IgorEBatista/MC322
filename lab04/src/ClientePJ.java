import java.util.Date;

public class ClientePJ extends Cliente {
    private final String CNPJ; 
    private Date dataFundacao;
    
    public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao) {
        super(nome, endereco);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
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

    //Outros métodos

    


    public String toString() {
        return (super.toString() + 
                "\nCNPJ: " + CNPJ + 
                "\nData de Fundacao: " + dataFundacao + "\n");
    }
    
}
