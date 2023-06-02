import java.text.ParseException;

public class SeguroPF extends Seguro {
    
    private Veiculo veiculo;
    private ClientePF cliente;

    
    //Construtor
    public SeguroPF(Seguradora seguradora, Veiculo veiculo, ClientePF cliente) throws ParseException {
        super(seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }
    
    //Getters e Setters
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    //Outros métodos

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
