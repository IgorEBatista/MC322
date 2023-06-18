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

    public Seguro(Seguradora seguradora){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dataAtual;
        try {
            dataAtual = formato.parse(LocalDate.now().toString());
        } catch (ParseException e) {
            dataAtual = new Date();
        }

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
        this.atualizado = false;
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
    public abstract Cliente getCliente();

    public abstract void setCliente(Cliente cliente);
    
    public boolean desautorizarCondutor(String CPF){
        Condutor condutor = Condutor.ident_Condutor(CPF, this.listaCondutores);
        if (condutor != null) {
            //Salva os sisnitros do condutor dentro da lista do cliente.
            this.listaSinistros.addAll(condutor.getListaSinistros());
            this.atualizado = false;
        }
        return this.listaCondutores.remove(condutor);
    }

    public boolean autorizarCondutor(Condutor condutor){
        return this.listaCondutores.add(condutor);

    }

    public Sinistro gerarSinistro(Date data, String endereco, Condutor condutor){
        Sinistro n_sin = new Sinistro(data, endereco, condutor, this);
        if (condutor != null) {
            condutor.adicionarSinistro(n_sin);
        } else {
            this.listaSinistros.add(n_sin);
        }
        return n_sin;
    }
    
    public abstract double calcularValor();

    public Condutor identCondutor(String CPF) {
        for (Condutor condutor : listaCondutores) {
            if (condutor.getCPF().equals(CPF)) {
                return condutor;
            }
        }
        return null;
    }

    public void atualizarValor() {
        setValorMensal((int)Math.round(calcularValor()));
        this.atualizado = true;
        getCliente().setModificado(false);
    }
    public String toString() {
        String texto = "ID: " + id;
        texto = texto.concat("\nSeguradora: " + seguradora.getNome());
        texto = texto.concat("\nData de vigencia: " + dataInicio + " até: " + dataFim);
        texto = texto.concat("\nValor mensal: " + valorMensal);
        texto = texto.concat("\nNúmero de Sinistros registrados: " + listaSinistros.size());
        texto = texto.concat("\nCondutores: ");
        for (Condutor condutor : listaCondutores) {
            texto = texto.concat("\n" + condutor.getNome() + " CPF: " + condutor.getCPF());
        }
        return texto;
    }
}