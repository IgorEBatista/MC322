import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class Seguro {
    private static int serie = 0;
    private final int id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private int valorMensal;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private boolean atualizado;
    
    //Construtor

    public Seguro(Seguradora seguradora) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dataAtual = formato.parse(LocalDate.now().toString());

        this.id = serie;
        this.dataInicio = dataAtual;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        //Valor será calculado posteriormente
        this.valorMensal = 0;
        //Apólices de seguro normalmente duram 1 ano.
        this.dataFim = dataAtual;
        this.dataFim.setYear(dataAtual.getYear() + 1);
        
        this.atualizado = false;
        serie++;
    }

    //Getters e Setters

    public int getId() {
        return id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public int getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public boolean getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(boolean atualizado) {
        this.atualizado = atualizado;
    }
    //Outros métodos

    public abstract boolean desautorizarCondutor();
    public abstract boolean autorizarCondutor();
    public abstract int calcularValor();
    public abstract Sinistro gerarSinistro();

    public void atualizarValor() {
        setValorMensal(calcularValor());
        this.atualizado = true;
    }
    public String toString() {
        
    }
}