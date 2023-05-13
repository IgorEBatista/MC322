import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppMain {
    
    private static Scanner leitor = new Scanner(System.in);
    private static int escolha;
    private static String leitura;
    private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
        
        //Declaracao de datas
        Date data_fundacao = formato.parse("01/01/2000");
        Date data_carteira1 = formato.parse("20/04/2023");
        Date data_nasc1 = formato.parse("29/02/2000");
        Date data_acidente = formato.parse("21/04/2023");
            
        //Verificando CPF e CNPJ

        System.out.println(Validacao.validarCPF("83371911047"));
        System.out.println(Validacao.validarCNPJ("86113575000136"));
            
        //Criando 2 Clientes.
        ClientePJ cliente_J1 = new ClientePJ("Lab's Corp", "Rua Roxo Moreira, nº42", "86113575000136", data_fundacao);
        ClientePF cliente_F1 = new ClientePF("Joana","Rua Roxo Moreira, nº3000","613.292.220-24", "Feminino", 
                                            data_carteira1, "Superior Completo", data_nasc1, "Alta");
            
            
        //Criando Veículos
        Veiculo veiculo0 = new Veiculo("LAB0O02", "MC", "322A", 2000);
        Veiculo veiculo1 = new Veiculo("LAB1O02", "MC", "322A", 2001);

            
        //Criando Seguradora
        Seguradora seguradora = new Seguradora("IC Seguros", "3521-5838", "ic_seguros@gmail.com", "Av. Albert Einstein, 1251");

        //Cadastrando Clientes na Seguradora

        seguradora.cadastrarCliente(cliente_J1);
        seguradora.cadastrarCliente(cliente_F1);

        //Cadastrando Veículos
        cliente_J1.addVeiculo(veiculo0);
        cliente_F1.addVeiculo(veiculo1);
            
        //Cadastrando Sinistros
        Sinistro sinistro1 = new Sinistro(data_acidente,"Rua da Reitoria, 109", seguradora, veiculo0, cliente_J1);
        Sinistro sinistro2 = new Sinistro(data_acidente,"Rua da Reitoria, 110", seguradora, veiculo1, cliente_F1);

        
        seguradora.gerarSinistro(sinistro1);
        seguradora.gerarSinistro(sinistro2);

            
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
        System.out.println("A receita da seguradora \"IC Seguros\" é:" + seguradora.calcularReceita() + "\n");

        //Chamando o menu interativo

        menuPrin();

        leitor.close();
    } 

    private static void menuPrin(){
        
        do {
            // Lê escolha do usuário
            escolha = leitor.nextInt();
            // Determina operação
            if (escolha == MenuOperacoesPrin.CADASTRAR.getOperacao()){
                menuCad();
            }
            else if (escolha == MenuOperacoesPrin.LISTAR.getOperacao()){
                menuList();
            }
            else if (escolha == MenuOperacoesPrin.SINISTRAR.getOperacao()){
                Boolean em_opera;
                Sinistro novo_Sin;
                Date data;
                Seguradora seg;
                Veiculo vei;
                String end;

                System.out.println("Qual dia aconteceu o sinistro? (Digite a data no formato: \"dd/mm/yyyy\")\n");
                do{
                    try {
                        data = formato.parse(leitor.nextLine());
                        em_opera = false;
                    } catch (ParseException except) {
                        System.out.println("Data inválida!\nPor favor, digite a data no formato: \"dd/mm/yyyy\")\n");
                        em_opera = true;
                    }
                } while(em_opera);
            }
            else if (escolha == MenuOperacoesPrin.TRANSFERIR.getOperacao()){
                ;
            }
            else if (escolha == MenuOperacoesPrin.CALCULAR.getOperacao()){
                ;
            }
            else if (escolha == MenuOperacoesPrin.EXCLUIR.getOperacao()){
                menuExcl();
            }
            else if (escolha != MenuOperacoesPrin.SAIR.getOperacao()){
                System.out.println("Por favor, as opções válidas são apenas números de 0 a 6 (inclusos).");
            }
        } while (escolha == MenuOperacoesPrin.SAIR.getOperacao());
    }

    private static void menuCad() {
        do {
            // Lê escolha do usuário
            escolha = leitor.nextInt();
            // Determina operação
            if (escolha == MenuOperacoesCad.CLIENTE.getOperacao()){
                
            }
            else if (escolha == MenuOperacoesCad.VEICULO.getOperacao()){
                
            }
            else if (escolha == MenuOperacoesCad.SEGURADORA.getOperacao()){
                
            }
            else if (escolha != MenuOperacoesCad.VOLTAR.getOperacao()){
                System.out.println("Por favor, as opções válidas são apenas números de 0 a 3 (inclusos).");
            }
        } while (escolha != MenuOperacoesCad.VOLTAR.getOperacao());
    }

    private static void menuList() {
        do {
            // Lê escolha do usuário
            escolha = leitor.nextInt();
            // Determina operação
            if (escolha == MenuOperacoesList.CLI_SEG.getOperacao()){
                
            }
            else if (escolha == MenuOperacoesList.SIN_SEG.getOperacao()){
                
            }
            else if (escolha == MenuOperacoesList.SIN_CLI.getOperacao()){
                
            }
            else if (escolha == MenuOperacoesList.VEI_SEG.getOperacao()){
                
            }
            else if (escolha == MenuOperacoesList.VEI_CLI.getOperacao()){
                
            }
            else if (escolha != MenuOperacoesList.VOLTAR.getOperacao()){
                System.out.println("Por favor, as opções válidas são apenas números de 0 a 5 (inclusos).");
            }
        } while (escolha != MenuOperacoesList.VOLTAR.getOperacao());
    }

    private static void menuExcl() {
        do {
            // Lê escolha do usuário
            escolha = leitor.nextInt();
            // Determina operação
            if (escolha == MenuOperacoesExcl.CLIENTE.getOperacao()){
                ;
            }
            else if (escolha == MenuOperacoesExcl.VEICULO.getOperacao()){
                ;
            }
            else if (escolha == MenuOperacoesExcl.SINISTRO.getOperacao()){
                ;
            }
            else if (escolha != MenuOperacoesExcl.VOLTAR.getOperacao()){
                System.out.println("Por favor, as opções válidas são apenas números de 0 a 3 (inclusos).");
            }

        } while (escolha != MenuOperacoesExcl.VOLTAR.getOperacao());
    }
}