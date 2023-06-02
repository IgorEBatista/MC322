import java.util.ArrayList;
import java.util.Date;

public class Condutor {
    private final String CPF;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private Date dataNascimento;
    private ArrayList<Sinistro> listaSinistros;

    //Constructor

    public Condutor(String CPF, String nome, String endereco, String telefone, String email, Date dataNascimento) {
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = new ArrayList<Sinistro>();
    }

    //Getters e Setters

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    //Outros métodos

    public boolean adicionarSinistro(Sinistro sinistro) {
        return this.listaSinistros.add(sinistro);
    }

    public String toString() {
        
    }
}
