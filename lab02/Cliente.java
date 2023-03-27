import java.beans.PropertyEditorManager;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;
    
    // Construtor
    
    public Cliente (String nome, String cpf, int idade, String dataNascimento, String endereco){
        this.nome = nome;
        setcpf(cpf);
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }
    
    // Getters e setters
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getcpf(){
        return cpf;
    }

    public void setcpf(String cpf){
        boolean valido = validarCPF(cpf);
        System.out.println(valido);
        if (valido){
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido");
        }
        
    }
    
    public String getdataNascimento(){
        return dataNascimento;
    }    
    
    public void setdataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    

    public int getidade(){
        return idade;
    }
    
    public void setidade(int idade){
        this.idade = idade;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    //Outros metodos

    public String toString() {
    //Controle de string
        return (getNome() + "\n" +
        getcpf() + "\n" +
        getdataNascimento() + "\n" +
        getidade() + "\n" +
        getEndereco() + "\n" );
    }
    

    private boolean validarCPF(String cpf){
    //Validador de cpf
        int pdig = 0, Sdig = 0;
        boolean igual = true;

        for (int i  = 0; i<cpf.length(); i++){
            char c = cpf.charAt(i);
            if ( !Character.isDigit(c)){
                cpf = cpf.replaceAll(Character.toString(c), "");
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
        System.out.println(pdig);

        if (pdig != cpf.charAt(9) - '0') {
            return false;
            
        }

        //Calcula o segundo dígito verificador

        for (int i = 0; i < (cpf.length() - 1); i++) {
            Sdig +=((cpf.charAt(i) - 48) * (11 - i));
        }
        Sdig = (Sdig * 10) % 11;
        if (Sdig>=10) {
            Sdig = 0;
        }

        if (Sdig != cpf.charAt(10) - '0') {
            return false;
            
        }

        return true;
    }
}