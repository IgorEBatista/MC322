import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class AppMain {
    
    private static Scanner leitor = new Scanner(System.in);
    private static int escolha;
    private static String leitura;
    private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private static LinkedList<Seguradora> empresas = new LinkedList<Seguradora>();

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
        empresas.add(seguradora);
        //Cadastrando Clientes na Seguradora

        seguradora.cadastrarCliente(cliente_J1);
        seguradora.cadastrarCliente(cliente_F1);

        //Cadastrando Veículos
        cliente_J1.addVeiculo(veiculo0);
        cliente_F1.addVeiculo(veiculo1);
            
        //Cadastrando Sinistros
        Sinistro sinistro1 = new Sinistro(data_acidente,"Rua da Reitoria, 109", seguradora, cliente_J1, veiculo0);
        Sinistro sinistro2 = new Sinistro(data_acidente,"Rua da Reitoria, 110", seguradora, cliente_F1, veiculo1);

        
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
        ArrayList<Sinistro> list_Sin = seguradora.getListaSinistros();
        for(Sinistro i : list_Sin){
            System.out.println(i.toString());
        }
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
            System.out.println("Pressione a opção correspondente:\n"+"1-Cadastrar"+
                                "\n2-Listar\n3-Excluir\n4-Gerar Sinistro\n"+
                                "5-Transferir Seguro\n6-Calcular Receita da Seguradora\n0-Sair");
            // Lê escolha do usuário
            escolha = Integer.parseInt(leitor.nextLine());
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
                Date data = null;
                Seguradora seg;
                Cliente cli;
                Veiculo vei;
                String end;
                //Obtem a data do ocorrido
                System.out.println("Qual dia aconteceu o sinistro? (Digite a data no formato: \"dd/mm/yyyy\")");
                do{
                    try {
                        data = formato.parse(leitor.nextLine());
                        em_opera = false;
                    } catch (ParseException except) {
                        System.out.println("Data inválida!\nPor favor, digite a data no formato: \"dd/mm/yyyy\")\n");
                        em_opera = true;
                    }
                } while(em_opera);
                //Obtem o local do ocorrido
                System.out.println("Qual endereço de onde aconteceu o sinistro?");
                end = leitor.nextLine();
                //Obtem a seguradora responsavel
                System.out.println("Digite o nome da seguradora na foi feito o contrato:");
                do{
                    seg = Seguradora.ident_Seguradora(empresas, leitor.nextLine());
                    if (seg == null) {
                        System.out.println("Seguradora não encontrada, por favor, digite o nome corretamente:");
                        em_opera = true;
                    } else {
                        em_opera = false;
                    }
                } while(em_opera);
                //Obtem o cliente envolvido
                System.out.println("Digite o CPF/CNPJ do cliente envolvido:");
                do{
                    cli = seg.identClient(Long.parseLong(leitor.nextLine().replaceAll("\\D", "")));
                    if (cli == null) {
                        System.out.println("Cliente não encontrado, por favor, digite o CPF/CNPJ corretamente:");
                        em_opera = true;
                    } else {
                        em_opera = false;
                    }
                } while(em_opera);
                //Obtem o veículo envolvido
                System.out.println("Digite a PLACA do Veículo envolvido:");
                do{
                    vei = cli.ident_Veiculo(leitor.nextLine());
                    if (vei == null) {
                        System.out.println( cli.getNome() + " não possui esse veículo, por favor, verifique a placa digitada");
                        em_opera = true;
                    } else {
                        em_opera = false;
                    }
                } while(em_opera);

                //Gera o sinistro e cadastra na seguradora correspondente.
                novo_Sin = new Sinistro(data, end, seg, cli, vei);
                if(seg.gerarSinistro(novo_Sin)){
                    System.out.println("O Sinistro foi cadastrado com sucesso! Confira os detalhes:\n" + novo_Sin.toString());
                }
            }
            else if (escolha == MenuOperacoesPrin.TRANSFERIR.getOperacao()){
                int i = 0;
                Boolean achou = false;
                Cliente cli_Ant = null, cli_Nov = null;
                //Encontra o primeiro cliente
                System.out.println("Digite o CPF/CNPJ do ANTIGO proprietário");
                do{    
                    leitura = leitor.nextLine();
                    Iterator<Seguradora> segur = empresas.iterator();
                    while (segur.hasNext() && !achou) {
                        Seguradora atual = (Seguradora)segur.next();
                        cli_Ant = atual.identClient(Long.parseLong(leitura.replaceAll("\\D", "")));
                        if(cli_Ant != null){
                            achou = true;
                        }
                    }
                    if (!achou) {
                        System.out.println("Nenhuma Seguradora possui esse cliente cadastrado, por favor, verifique os dados");
                    }
                }while(!achou);
                achou = false;
                //Encontra o segundo cliente
                System.out.println("Digite o CPF/CNPJ do NOVO proprietário");
                do{    
                    leitura = leitor.nextLine();
                    Iterator<Seguradora> segur = empresas.iterator();
                    while (segur.hasNext() && !achou) {
                        Seguradora atual = (Seguradora)segur.next();
                        cli_Nov = atual.identClient(Long.parseLong(leitura.replaceAll("\\D", "")));
                        if(cli_Nov != null){
                            achou = true;
                        }
                    }
                    if (!achou) {
                        System.out.println("Nenhuma Seguradora possui esse cliente cadastrado, por favor, verifique os dados");
                    }
                }while(!achou);

                //Realiza a transferência dos veiculos
                Iterator<Veiculo> lista_Orig = cli_Ant.getLista_Veiculos().iterator();
                while (lista_Orig.hasNext()) {
                    Veiculo atual = (Veiculo)lista_Orig.next();
                    cli_Nov.addVeiculo(atual);
                    cli_Ant.remVeiculo(atual);
                    i++;
                }
                System.out.println("Foram transferidos " + i + " veículos com sucesso!");
            }
            else if (escolha == MenuOperacoesPrin.CALCULAR.getOperacao()){
                Boolean em_opera;
                Seguradora seg;
                double renda;
                //Identifica a seguradora pretendida
                System.out.println("Digite o nome da Seguradora");
                do{
                    seg = Seguradora.ident_Seguradora(empresas, leitor.nextLine());
                    if (seg == null) {
                        System.out.println("Seguradora não encontrada, por favor, digite o nome corretamente:\nOpções:");
                        for (Seguradora i: empresas){
                            System.out.println(i.getNome());
                        }
                        em_opera = true;
                    } else {
                        em_opera = false;
                    }
                } while(em_opera);
                //Mostra o valor requerido
                renda = seg.calcularReceita();
                System.out.println("A Seguradora " + seg.getNome() + " tem uma receita de: R$" + renda);
            }
            else if (escolha == MenuOperacoesPrin.EXCLUIR.getOperacao()){
                menuExcl();
            }
            else if (escolha != MenuOperacoesPrin.SAIR.getOperacao()){
                System.out.println("Por favor, as opções válidas são apenas números de 0 a 6 (inclusos).");
            }
        }while (escolha != MenuOperacoesPrin.SAIR.getOperacao());
    }

    private static void menuCad() {
        do {
            // Lê escolha do usuário
            escolha = leitor.nextInt();
            // Determina operação
            if (escolha == MenuOperacoesCad.CLIENTE.getOperacao()){
                ArrayList<String> infos = new ArrayList<String>();
                ArrayList<Date> dias = new ArrayList<Date>();
                //As listas acima foram criadas para facilitar a aquisição das informações sem um excesso de variáveis
                
                Boolean pf = false, pj = false, nome_ok, data_ok;
                //Obtendo CPF/CNPJ
                System.out.println("Digite o CPF/CNPJ do cliente a ser cadastrado:");
                do{   
                    infos.set(0, leitor.nextLine());
                    pf = Validacao.validarCPF(infos.get(0));
                    if (pf) {
                        //Obtendo o nome do cliente
                        System.out.println("Digite o nome do cliente a ser cadastrado:");
                        do {
                            infos.set(1, leitor.nextLine());
                            nome_ok = Validacao.validaNome(infos.get(1));
                            if (!nome_ok) {
                                System.out.println("Por favor, digite um nome válido:");
                            }
                        } while (!nome_ok);
                        //Obtendo o endereço
                        System.out.println("Digite o endereço do cliente a ser cadastrado:");
                        infos.set(2, leitor.nextLine());
                        //Obtendo o Gênero
                        System.out.println("Digite o gênero do cliente a ser cadastrado:");
                        infos.set(3, leitor.nextLine());
                        //Obtendo o nível de educação
                        System.out.println("Digite o nível acadêmico do cliente a ser cadastrado:");
                        infos.set(4, leitor.nextLine());
                        //Obtendo a classe econômica
                        System.out.println("Digite a classe econômica do cliente a ser cadastrado:");
                        infos.set(5, leitor.nextLine());
                        //Obtem a data de nascimento
                        System.out.println("Qual a data de nascimento do cliente? (Digite a data no formato: \"dd/mm/yyyy\")");
                        do{
                            try {
                                dias.set(0, formato.parse(leitor.nextLine()));
                                data_ok = true;
                            } catch (ParseException except) {
                                System.out.println("Data inválida!\nPor favor, digite a data no formato: \"dd/mm/yyyy\")\n");
                                data_ok = false;
                            }
                        } while(!data_ok);
                        //Obtem a data de expedição da carteira
                        System.out.println("Qual a data de expedição da carteira do cliente? (Digite a data no formato: \"dd/mm/yyyy\")");
                        do{
                            try {
                                dias.set(1, formato.parse(leitor.nextLine()));
                                data_ok = true;
                            } catch (ParseException except) {
                                System.out.println("Data inválida!\nPor favor, digite a data no formato: \"dd/mm/yyyy\")\n");
                                data_ok = false;
                            }
                        } while(!data_ok);

                        //Falta terminar os menus

                    } else {
                        pj = Validacao.validarCNPJ(infos.get(0));
                        if (pj) {
                            
                        } else {
                            System.out.println("O CPF/CNPJ não é válido! Por favor, verifique o número digitado:");
                        }
                    }
                } while(!pf && !pj);
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