public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;
    
    // Construtor
    
    public Cliente (String nome, String cpf, int idade, String dataNascimento, String endereco){
        this.nome = nome;
        this.cpf = cpf;
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
    private boolean validarCPF(String cpf){
        int Pdig = 0, Sdig = 0;
        boolean igual = true;

        for (int i  = 0; i<cpf.length(); i++){
            char c = cpf.charAt(i);
            if ( Character.isDigit(c)){
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
        
        //Calcula dígitos verificadores

        for (int i = 0; i < (cpf.length() - 2); i++) {
            Pdig +=((int)(cpf.charAt(i)) * (10 - i));
        }
        Pdig /= 11;


        return true;
    }
}