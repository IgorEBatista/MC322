import java.text.ParseException;

public class SeguroPJ extends Seguro {

    private Frota frota;
    private ClientePJ cliente;

    //Construtor
    public SeguroPJ(Seguradora seguradora, Frota frota, ClientePJ cliente) throws ParseException {
        super(seguradora);
        this.frota = frota;
        this.cliente = cliente;
    }
    
    //Getters e Setters
    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    public String toString() {
        
    }

    @Override
    public boolean desautorizarCondutor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desautorizarCondutor'");
    }

    @Override
    public boolean autorizarCondutor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autorizarCondutor'");
    }

    @Override
    public int calcularValor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularValor'");
    }

    @Override
    public Sinistro gerarSinistro() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarSinistro'");
    }
}
