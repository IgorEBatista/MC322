import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;

public class ClientePF extends Cliente{
    private final String CPF;
    private String genero; 
    private Date dataLicenca; 
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;
    private ArrayList<Veiculo> listaVeiculos;

    //Contrutor
    
    public ClientePF(String nome, String endereco, String cpf, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica){        
        super(nome, endereco);
        this.CPF = cpf.replaceAll("\\D", "");
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
        this.listaVeiculos = new ArrayList<Veiculo>();
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

    public ArrayList<Veiculo> getlistaVeiculos() {
        return listaVeiculos;
    }

    public void setlistaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }


    //Outros métodos


    public void cadastrarVeiculo(Veiculo veiculo){
        listaVeiculos.add(veiculo);
        this.setModificado(true);
    }

    public boolean removerVeiculo(Veiculo veiculo){
        boolean mod = listaVeiculos.remove(veiculo);
        if (mod) this.setModificado(true);
        return mod;
    }    


    public String toString() {
        String texto = super.toString();
        texto = texto.concat("\nCPF: " + CPF); 
        texto = texto.concat("\nGenero: " + genero);
        texto = texto.concat("\nData da Licenca: " + dataLicenca);
        texto = texto.concat("\nNível de Educacao: " + educacao);
        texto = texto.concat("\nData de Nascimento: " + dataNascimento);
        texto = texto.concat("\nClasse Economica: " + classeEconomica);
        return texto;
    }

    public Veiculo ident_Veiculo(String placa) {
        Iterator<Veiculo> elem = this.listaVeiculos.iterator();
        while (elem.hasNext()) {
            Veiculo atual = (Veiculo)elem.next();
            if (atual.getplaca().equals(placa)) {
                return atual;
            }
        }
        return null;
        
    }
}