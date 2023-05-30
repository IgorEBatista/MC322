import java.util.Date;
import java.util.LinkedList;

public class ClientePF extends Cliente{
    private final String CPF;
    private String genero; 
    private Date dataLicenca; 
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;
    private LinkedList<Veiculo> lista_Veiculos;

    //Contrutor

    public ClientePF(String nome, String endereco, String cpf, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica){        
        super(nome, endereco);
        this.CPF = cpf.replaceAll("\\D", "");
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }

    //Getters e Setters

    public String getCPF() {
        return CPF;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }


    //Outros métodos


    public void cadastrarVeiculo(Veiculo veiculo){
        lista_Veiculos.add(veiculo);
        this.setModificado(true);
    }

    public boolean removerVeiculo(Veiculo veiculo){
        boolean mod = lista_Veiculos.remove(veiculo);
        if (mod) this.setModificado(true);
        return mod;
    }    


    public String toString() {
        return (super.toString() + 
                "\nCPF: " + CPF + 
                "\nGenero: " + genero + 
                "\nData da Licenca: " + dataLicenca + 
                "\nNível de Educacao: " + educacao + 
                "\nData de Nascimento: " + dataNascimento + 
                "\nClasse Economica: " + classeEconomica);
    }

    public double calculaScore(){
        Date agora = new Date();
        int idade = agora.getYear() - dataNascimento.getYear();
        double fator;

        if (18 <= idade && idade < 30) {
            fator = CalcSeguro.FATOR_18_30.getOperacao();
        } else if (30 <= idade && idade <= 60) {
            fator = CalcSeguro.FATOR_30_60.getOperacao();
        } else {
            fator = CalcSeguro.FATOR_60_90.getOperacao();
        }
        
        return CalcSeguro.VALOR_BASE.getOperacao() * fator * this.getLista_Veiculos().size();
    }
}