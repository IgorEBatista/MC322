import java.util.Random;

public class Sinistro {

    private int id;
    private String data;
    private String endereco;

    //Construtor
    public Sinistro (String data, String endereco){
        this.id = gerarID();
        this.data = data;
        this.endereco = endereco;
    }
    // Getters e setters
    public int getid (){
        return id;
    }

    public void setid (int id){
        this.id = id;
    }

    public String getdata (){
        return data;
    }

    public void setdata (String data){
        this.data = data;
    }

    public String getendereco (){
        return endereco;
    }

    public void setendereco (String endereco){
        this.endereco = endereco;
    }
    
    //Outros Métodos

    public int gerarID(){
        //Gera um ID aleatório de 6 dígitos
        Random gerador = new Random();
        return gerador.nextInt(900000) + 100000;
    }

    public String toString(){
        //Controle de string
        return ("ID: " + getid() + "\n" +
                "Data: " + getdata() + "\n" +
                "Endereço: " + getendereco() + "\n" );
    }
}
