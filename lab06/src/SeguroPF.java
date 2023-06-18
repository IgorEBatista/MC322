import java.util.Date;
import java.util.Iterator;

public class SeguroPF extends Seguro {
    
    private Veiculo veiculo;
    private ClientePF cliente;

    
    //Construtor
    public SeguroPF(Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
        super(seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.atualizarValor();
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

    public void setCliente(Cliente cliente) {
        this.cliente = (ClientePF)cliente;
    }

    //Outros métodos

    public String toString() {
        String texto = "Cliente: " + cliente.getNome();
        texto = texto.concat("\nVeículo: " + veiculo);
        texto = texto.concat("\n" + super.toString());
        return texto;
    }

    public double calcularValor() {
        Date agora = new Date();
        int idade = agora.getYear() - this.cliente.getDataNascimento().getYear();
        int soma_SinCli = 0;
        int soma_SinCond = 0;
        double fator_idade;
        double fator_qtdVei;
        double fator_sinCli;
        double fator_sinCond;

        //Calculando fator idade
        if (18 <= idade && idade < 30) {
            fator_idade = CalcSeguro.FATOR_18_30.getOperacao();
        } else if (30 <= idade && idade <= 60) {
            fator_idade = CalcSeguro.FATOR_30_60.getOperacao();
        } else {
            fator_idade = CalcSeguro.FATOR_60_90.getOperacao();
        }
        
        //Calculando fator qtd de veiculos
        fator_qtdVei = (1 + 1/(this.cliente.getlistaVeiculos().size() + 2));
        
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

        return CalcSeguro.VALOR_BASE.getOperacao() * fator_idade * fator_qtdVei *
                                                     fator_sinCli * fator_sinCond;
    }
}
