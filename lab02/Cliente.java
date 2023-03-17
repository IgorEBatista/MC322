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
        this.cpf = cpf;
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
}