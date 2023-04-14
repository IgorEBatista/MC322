import java.util.Date;

public class ClientePF extends Cliente{
    private final String CPF;
    private String genero; 
    private Date dataLicenca; 
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;

    //Contrutor

    public ClientePF(String nome, String endereco, String cpf, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica){        
        super(nome, endereco);
        CPF = cpf;
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

    public static boolean validarCPF(String cpf){
        //Validador de cpf
        int pdig = 0, sdig = 0;
        boolean igual = true;
            
    
        for (int i  = 0; i<cpf.length(); i++){
            char c = cpf.charAt(i);
            if ( !Character.isDigit(c)){
                cpf = cpf.replaceAll("\\D", "");
            }
        }        
        //Conta digitos
        if (cpf.length() != 11) {
            return false;
        }

        //Verifica igualdade
        for (int i  = 1; i<cpf.length() && igual ; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                igual = false;
            }
        }
        if (igual){
            return false;
        }
        
        //Calcula o primeiro dígito verificador

        for (int i = 0; i < (cpf.length() - 2); i++) {
            pdig +=((cpf.charAt(i))- 48) * (10 - i);
        }
        pdig = (pdig * 10) % 11;
        if (pdig>=10) {
            pdig = 0;
        }

        if (pdig != cpf.charAt(9) - '0') {
            return false;
            
        }
    
        //Calcula o segundo dígito verificador

        for (int i = 0; i < (cpf.length() - 1); i++) {
            sdig +=((cpf.charAt(i) - 48) * (11 - i));
        }
        sdig = (sdig * 10) % 11;
        if (sdig>=10) {
            sdig = 0;
        }

        if (sdig != cpf.charAt(10) - '0') {
            return false;
            
        }

        return true;
    }

    public String toString() {
        return (super.toString() + "\nCPF: " + CPF + "\nGenero: " + genero + "\nData da Licenca: " + dataLicenca + "\nNível de Educacao: "
                + educacao + "\nData de Nascimento: " + dataNascimento + "\nClasse Economica: " + classeEconomica);
    }
}