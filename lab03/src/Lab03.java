import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab03 {

    public static void main(String[] args) throws ParseException {
        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        //Declaracao de datas
        Date data_fundacao = formato.parse("01/01/2000");
        Date data_carteira1 = formato.parse("20/04/2023");
        Date data_nasc1 = formato.parse("29/02/2000");
        Date data_carteira2 = formato.parse("20/04/2023");
        Date data_nasc2 = formato.parse("29/02/2000");
        Date data_acidente = formato.parse("21/04/2023");
            
        //Verificando CPF e CNPJ

        System.out.println(ClientePF.validarCPF("83371911047"));
        System.out.println(ClientePJ.validarCNPJ("86113575000136"));
            
        //Criando 3 Clientes.
        ClientePJ cliente_J1 = new ClientePJ("Lab's Corp", "Rua Roxo Moreira, nº42", "86113575000136", data_fundacao);
        ClientePF cliente_F1 = new ClientePF("Pedro","Rua Roxo Moreira, nº1042","83371911047", "Masculino", 
                                            data_carteira1, "Superior Incompleto", data_nasc1, "Media-Alta");

        ClientePF cliente_F2 = new ClientePF("Joana","Rua Roxo Moreira, nº3000","613.292.220-24", "Feminino", 
                                            data_carteira2, "Superior Completo", data_nasc2, "Alta");
            
            
        //Criando Veículos
        Veiculo veiculo0 = new Veiculo("LAB0O02", "MC", "322A", 2000);
        Veiculo veiculo1 = new Veiculo("LAB1O02", "MC", "322A", 2001);
        Veiculo veiculo2 = new Veiculo("LAB2O02", "MC", "322A", 2002);

            
        //Criando Seguradora
        Seguradora seguradora = new Seguradora("IC Seguros", "3521-5838", "ic_seguros@gmail.com", "Av. Albert Einstein, 1251");

        //Cadastrando Clientes na Seguradora

        seguradora.cadastrarCliente(cliente_J1);
        seguradora.cadastrarCliente(cliente_F1);
        seguradora.cadastrarCliente(cliente_F2);

        //Cadastrando Veículos
        cliente_J1.addVeiculo(veiculo0);
        cliente_F1.addVeiculo(veiculo1);
        cliente_F2.addVeiculo(veiculo2);        
            
        //Cadastrando Sinistros
        Sinistro sinistro = new Sinistro(data_acidente,"Rua da Reitoria, 109", seguradora, veiculo1, cliente_J1);

        seguradora.gerarSinistro(sinistro);
            
        //Removendo um Cliente

        seguradora.removerCliente("Pedro");

        //Visualizando Listas

        System.out.println("Listando Clientes Pessoa Juridica:\n");
        seguradora.listarClientes("ClientePJ");
        System.out.println("Listando Clientes Pessoa Fisica:\n");
        seguradora.listarClientes("ClientePF");
        System.out.println("Listando Todos os Sinistros:\n");
        seguradora.listarSinistros();
        System.out.println("Listando os sinistros envolvendo \"Joana\":\n");
        seguradora.visualizarSinistro("Joana");
        System.out.println("Listando os sinistros envolvendo \"Lab's Corp\":\n");
        seguradora.visualizarSinistro("Lab's Corp");
        
        
    leitor.close();
    } 
}
