

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
        if (valido){
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido");
            this.cpf = "Não fornecido";
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
        return ("Nome: " + getNome() + "\n" +
                "CPF: " + getcpf() + "\n" +
                "Nascimento: " + getdataNascimento() + "\n" +
                "Idade: " + getidade() + "\n" +
                "Endereço: " + getEndereco() + "\n" );
    }
    

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
}