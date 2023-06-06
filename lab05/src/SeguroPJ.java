import java.util.Date;
import java.util.Iterator;

public class SeguroPJ extends Seguro {

    private Frota frota;
    private ClientePJ cliente;

    //Construtor
    public SeguroPJ(Seguradora seguradora, Frota frota, ClientePJ cliente){
        super(seguradora);
        this.frota = frota;
        this.cliente = cliente;
        this.atualizarValor();
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

    public void setCliente(Cliente cliente) {
        this.cliente = (ClientePJ)cliente;
    }

    //Outros metodos
    public String toString() {
        String texto = "Cliente: " + cliente.getNome();
        texto = texto.concat("\nFrota: " + frota);
        texto = texto.concat("\n" + super.toString());
        return texto;
    }
    
    public double calcularValor() {
        Date agora = new Date();
        int tempo = agora.getYear() - this.cliente.getDataFundacao().getYear();
        int soma_SinCli = 0;
        int soma_SinCond = 0;
        double fator_qtdFun;
        double fator_tempo;
        double fator_qtdVei;
        double fator_sinCli;
        double fator_sinCond;

        //Calculando fator qtd funcionarios
        fator_qtdFun = (10 + this.cliente.getNum_funcionarios()/10);
        
        //Calculando fator qtd de veiculos
        fator_qtdVei = (1 + 1/(this.frota.getlistaVeiculos().size() + 2));
        
        //Calculando fator anos de existência
        fator_tempo = (1 + 1/(tempo + 2));
        
        //Calculando soma de sinistros do cliente e por condutor
        Iterator<Seguro> elem_seg = this.getSeguradora().getSegurosPorCliente(this.cliente).iterator();
        while (elem_seg.hasNext()) {
            Seguro seg_atual = (Seguro)elem_seg.next();
            soma_SinCli += seg_atual.getListaSinistros().size();
            Iterator<Condutor> elem_cond = seg_atual.getListaCondutores().iterator();
            while (elem_cond.hasNext()) {
                Condutor cond_atual = (Condutor)elem_cond.next();
                soma_SinCond += cond_atual.getListaSinistros().size();
            }
        }
        
        //Calculando o fator referente aos sinistros do cliente 
        fator_sinCli = (2 + (soma_SinCli/10));
        
        //Calculando o fator referente aos sinistros de cada condutor 
        fator_sinCond = (5 + (soma_SinCond/10));

        //Sinaliza que o valor está atualizado
        cliente.setModificado(false);

        return CalcSeguro.VALOR_BASE.getOperacao() * fator_qtdFun* fator_tempo * fator_qtdVei *
                                                     fator_sinCli * fator_sinCond;
    }
}
