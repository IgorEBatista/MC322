import java.util.Date;

public class Sinistro {

    private static int serie;
    private final int id;
    private Date data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;

    //Construtor
    
    public Sinistro(Date data, String endereco,  Condutor condutor, Seguro seguro) {
        this.id = serie + 100000;
        this.data = data;
        this.endereco = endereco;
        this.seguro = seguro;
        this.condutor = condutor;
        serie++;
    }

    // Getters e setters
    public int getid (){
        return id;
    }

    public Date getdata (){
        return data;
    }

    public void setdata (Date data){
        this.data = data;
    }

    public String getendereco (){
        return endereco;
    }

    public void setendereco (String endereco){
        this.endereco = endereco;
    }

    public Seguro getseguro() {
        return seguro;
    }

    public void setseguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Condutor getcondutor() {
        return condutor;
    }

    public void setcondutor(Condutor condutor) {
        this.condutor = condutor;
    }
    
    //Outros Métodos

    public String toString(){
        //Controle de string
        String texto = "ID: " + getid(); 
        texto = texto.concat("\nData: " + getdata()); 
        texto = texto.concat("\nEndereço: " + getendereco());
        texto = texto.concat("\nSeguro: " + getseguro());
        if (condutor != null) {
            texto = texto.concat("\nCondutor: " + getcondutor().getNome());
        }
        
        return texto;
    }

}
