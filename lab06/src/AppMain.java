import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class AppMain {
    
    private static Scanner leitor = new Scanner(System.in);
    private static int escolha;
    private static String leitura;
    private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private static ArrayList<Seguradora> empresas = new ArrayList<Seguradora>();

    public static void main(String[] args) throws ParseException {
        
        //Declaracao de datas
        Date data_fundacao = formato.parse("01/01/2000");
        Date data_carteira1 = formato.parse("20/06/2023");
        Date data_nasc1 = formato.parse("29/02/2000");
        Date data_nasc2 = formato.parse("23/01/2001");
        Date data_acidente = formato.parse("21/06/2023");
            
        //Verificando CPF e CNPJ
        System.out.println("Validando o CPF: 833.719.110-47");
        System.out.println(Validacao.validarCPF("83371911047"));
        System.out.println("Validando o CNPJ: 86.113.575/0001-36");
        System.out.println(Validacao.validarCNPJ("86113575000136"));
        
        //Criando Seguradora
        Seguradora seguradora1 = new Seguradora("44620903000140","IC Seguros", "3521-5838", "ic_seguros@gmail.com", "Av. Albert Einstein, 1251");
        empresas.add(seguradora1);
        System.out.println();
        System.out.println("Criando nova Seguradora: " + seguradora1.toString());
        Seguradora seguradora2 = new Seguradora("18108138000174","IC2 Seguros", "3521-5839", "ic2_seguros@gmail.com", "Av. Albert Einstein, 1252");
        empresas.add(seguradora2);
        
        //Criando 2 Clientes.
        ClientePJ cliente_J1 = new ClientePJ("Lab's Corp", "Rua Roxo Moreira, nº42", "86113575000136", data_fundacao, 10);
        ClientePF cliente_F1 = new ClientePF("Joana","Rua Roxo Moreira, nº3000","613.292.220-24", "Feminino", 
        data_carteira1, "Superior Completo", data_nasc1, "Alta");
        
        //Cadastrando Clientes na Seguradora
        seguradora1.cadastrarCliente(cliente_J1);
        System.out.println();
        System.out.println("Cadastrando novo cliente na seguradora: " + seguradora1.getListaClientes().get(0));
        seguradora1.cadastrarCliente(cliente_F1);
        
        //Criando Veículos
        Veiculo veiculo0 = new Veiculo("LAB0O02", "MC", "322A", 2000);
        System.out.println();
        System.out.println("Criando novo veículo: " + veiculo0);
        Veiculo veiculo1 = new Veiculo("LAB1O02", "MC", "322A", 2001);
        Veiculo veiculo2 = new Veiculo("LAB4O03", "MC", "322A", 2004);
        Veiculo veiculo3 = new Veiculo("LAB5O03", "MC", "322A", 2005);
        
        //Cadastrando Veículo PF
        cliente_F1.cadastrarVeiculo(veiculo0);
        cliente_F1.cadastrarVeiculo(veiculo1);
        
        //Criando Frota
        Frota frota0 = new Frota("frota0", veiculo2);
        cliente_J1.cadastrarFrota(frota0);
        System.out.println();
        System.out.println("Criando nova frota: " + frota0);
        //Adicionando veículo à frota existente:
        cliente_J1.atualizarFrota("frota0", veiculo3, 1 );
        
        //Criando seguros PF:
        seguradora1.gerarSeguro(cliente_F1, veiculo1);
        seguradora1.gerarSeguro(cliente_F1, veiculo0);
        
        //Criando seguros PJ:
        seguradora1.gerarSeguro(cliente_J1, frota0);
        System.out.println();
        System.out.println("Criando seguro PJ: " + seguradora1.getListaSeguros().get(2));
        
        //Adicionando um condutor ao Cliente PF
        Condutor condutor0 = new Condutor("36954878448","Alícia Assis", "Rua Raimundo de Oliveira, 510", "8427459617", "alicia-assis78@mpcnet.com.br", data_nasc2);
        seguradora1.getListaSeguros().get(0).autorizarCondutor(condutor0);
        System.out.println();
        System.out.println("Novo condutor autorizado: " + condutor0);
        
        //Cadastrando Sinistros        
        seguradora1.getListaSeguros().get(0).gerarSinistro(data_acidente, "Rua da Reitoria, 109", condutor0);
        seguradora1.getListaSeguros().get(2).gerarSinistro(data_acidente, "Rua da Reitoria, 110", null);
        
        //Visualizando Listas
        
        System.out.println("Listando Clientes Pessoa Juridica:\n");
        seguradora1.listarClientes("ClientePJ");
        System.out.println("Listando Clientes Pessoa Fisica:\n");
        seguradora1.listarClientes("ClientePF");
        System.out.println("Listando Todos os Sinistros:\n");
        ArrayList<Sinistro> list_Sin = new ArrayList<Sinistro>();
        for (Cliente cliente : seguradora1.getListaClientes()) {
            list_Sin.addAll(seguradora1.getSinistrosPorCliente(cliente));
        }
        for(Sinistro i : list_Sin){
            System.out.println(i);
        }
        System.out.println();
        System.out.println("A receita da seguradora \"IC Seguros\" é:" + seguradora1.calcularReceita() + "\n");

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
            try {
                escolha = Integer.parseInt(leitor.nextLine());    
            } catch (Exception e) {
                escolha = -1;
            }
            
            // Determina operação
            if (escolha == MenuOperacoesPrin.CADASTRAR.getOperacao()){
                System.out.println("Pressione a opção correspondente:\n"+"1-Cliente"+
                                "\n2-Veiculo\n3-Seguradora\n0-Sair");
                menuCad();
            }
            else if (escolha == MenuOperacoesPrin.LISTAR.getOperacao()){
                System.out.println("Pressione a opção correspondente:\n"+"1-Clientes por Seguradora"+
                                "\n2-Sinistros por Seguradora\n3-Sinistros por Cliente\n4-Veículos por seguradora\n"+
                                "5-Veículos por cliente\n0-Sair");
                menuList();
            }
            else if (escolha == MenuOperacoesPrin.SINISTRAR.getOperacao()){
                Boolean em_opera;
                Date data = null;
                Seguradora seguradora;
                Condutor cond;
                Seguro seguro;
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
                System.out.println("Digite o nome da seguradora na qual foi feito o contrato:");
                do{
                    seguradora = Seguradora.ident_Seguradora(empresas, leitor.nextLine());
                    if (seguradora == null) {
                        System.out.println("Seguradora não encontrada, por favor, digite o nome corretamente:");
                        em_opera = true;
                    } else {
                        em_opera = false;
                    }
                } while(em_opera);
                
                //Obtem o seguro do veículo envolvido
                System.out.println("Digite a PLACA do Veículo envolvido:");
                do{
                    seguro = seguradora.identSeguro(leitor.nextLine());
                    if (seguro == null) {
                        System.out.println( "Esse veículo não foi encontrado, por favor, verifique a placa digitada");
                        em_opera = true;
                    } else {
                        em_opera = false;
                    }
                } while(em_opera);
                
                //Obtem o condutor relacionado
                System.out.println("Digite o CPF do condutor envolvido: (Digote 0 caso não haja.)");
                do{
                    String leitura = leitor.nextLine();
                    cond = seguro.identCondutor(Validacao.limpaNum(leitura));
                    
                    if (cond == null && leitura != "0" ) {
                        System.out.println("Condutor não encontrado, por favor, digite o CPF corretamente:");
                        em_opera = true;
                    } else {
                        em_opera = false;
                    }
                } while(em_opera);
                

                //Gera o sinistro e cadastra na seguradora correspondente.
                seguro.gerarSinistro(data, end, cond);
                System.out.println("O Sinistro foi cadastrado com sucesso! Confira os detalhes:\n" + seguro.getListaSinistros().get(seguro.getListaSinistros().size() - 1));
            }

            else if (escolha == MenuOperacoesPrin.TRANSFERIR.getOperacao()){
                Boolean achou = false;
                Cliente cli_Ant = null, cli_Nov = null;
                Seguradora seguradora1 = null;
                //Encontra o primeiro cliente
                System.out.println("Digite o CPF/CNPJ do ANTIGO segurado");
                do{    
                    leitura = leitor.nextLine();
                    Iterator<Seguradora> segur = empresas.iterator();
                    while (segur.hasNext() && !achou) {
                        Seguradora atual = (Seguradora)segur.next();
                        cli_Ant = atual.identClient(leitura.replaceAll("\\D", ""));
                        if(cli_Ant != null){
                            achou = true;
                            seguradora1 = atual;
                        }
                    }
                    if (!achou) {
                        System.out.println("Nenhuma Seguradora possui esse cliente cadastrado, por favor, verifique os dados");
                    }
                }while(!achou);
                achou = false;
                //Encontra o segundo cliente
                System.out.println("Digite o CPF/CNPJ do NOVO segurado");
                do{    
                    leitura = leitor.nextLine();
                    Iterator<Seguradora> segur = empresas.iterator();
                    while (segur.hasNext() && !achou) {
                        Seguradora atual = (Seguradora)segur.next();
                        cli_Nov = atual.identClient(leitura.replaceAll("\\D", ""));
                        if(cli_Nov != null){
                            achou = true;
                        }
                    }
                    if (!achou) {
                        System.out.println("Nenhuma Seguradora possui esse cliente cadastrado, por favor, verifique os dados");
                    }
                }while(!achou);

                //Realiza a transferência dos seguros
                for (Seguro seguro : seguradora1.getListaSeguros()) {
                    if (seguro.getCliente().equals(cli_Ant)) {
                        seguro.setCliente(cli_Nov);
                    }
                }
                System.out.println("Foram transferidos " + " veículos com sucesso!");
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
                System.out.println("Pressione a opção correspondente:\n"+"1-Cliente"+
                                "\n2-Veiculo\n0-Sair");
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
            try {
                escolha = Integer.parseInt(leitor.nextLine());
            } catch (Exception e) {
                escolha = -1;
            }
            // Determina operação
            if (escolha == MenuOperacoesCad.CLIENTE.getOperacao()){
                ArrayList<String> infos = new ArrayList<String>();
                ArrayList<Date> dias = new ArrayList<Date>();
                //As listas acima foram criadas para facilitar a aquisição das informações sem um excesso de variáveis
                Cliente novo_Cli;
                Seguradora seg;
                Boolean pf = false, pj = false, nome_ok, data_ok, seg_encontrada;
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
                    } else {
                        pj = Validacao.validarCNPJ(infos.get(0));
                        if (pj) {
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
                            //Obtem a data de nascimento
                            System.out.println("Qual a data de fundacao da empresa cliente? (Digite a data no formato: \"dd/mm/yyyy\")");
                            do{
                                try {
                                    dias.set(0, formato.parse(leitor.nextLine()));
                                    data_ok = true;
                                } catch (ParseException except) {
                                    System.out.println("Data inválida!\nPor favor, digite a data no formato: \"dd/mm/yyyy\")\n");
                                    data_ok = false;
                                }
                            } while(!data_ok);
                            //Obtendo o número de funcionários
                            System.out.println("Digite o número de funcionários da empresa:");
                            do{
                                infos.set(3, leitor.nextLine());
                                if (Integer.parseInt(infos.get(3)) <= 0) {
                                    System.out.println("Por favor, digite um número válido de funcionários: (Inteiro e positivo)");
                                }
                            }while (Integer.parseInt(infos.get(3)) <= 0);
                        } else {
                            System.out.println("O CPF/CNPJ não é válido! Por favor, verifique o número digitado:");
                        }
                    }
                } while(!pf && !pj);
                //Instanciando o cliente do tipo respectivo
                if (pf) {
                    novo_Cli = new ClientePF(infos.get(1),infos.get(2),infos.get(0),infos.get(3),dias.get(0),infos.get(4),dias.get(1),infos.get(5));
                } else {
                    novo_Cli = new ClientePJ(infos.get(1), infos.get(2), infos.get(0), dias.get(0), Integer.parseInt(infos.get(3)));
                }
                //Descobrindo a seguradora na qual o cliente será cadastrado.
                System.out.println("Digite o nome da Seguradora na qual o cliente será cadastrado:");
                do{
                    seg = Seguradora.ident_Seguradora(empresas, leitor.nextLine());
                    if (seg == null) {
                        System.out.println("Seguradora não encontrada, por favor, digite o nome corretamente:\nOpções:");
                        for (Seguradora i: empresas){
                            System.out.println(i.getNome());
                        }
                        seg_encontrada = false;
                    } else {
                        seg_encontrada = true;
                    }
                } while(!seg_encontrada);
                seg.cadastrarCliente(novo_Cli);
                System.out.println("Foi adicionado à seguradora " + seg.getNome() + " o seguinte cliente:\n" + novo_Cli.toString());
            }
            else if (escolha == MenuOperacoesCad.VEICULO.getOperacao()){
                Boolean achou = false;
                Cliente cli = null;
                Veiculo vei;
                ArrayList<String> infos = new ArrayList<String>(); 
                //Encontra o cliente que receberá o veículo
                System.out.println("Digite o CPF/CNPJ do Cliente no qual o novo veículo será adicionado");
                do{    
                    leitura = leitor.nextLine();
                    Iterator<Seguradora> segur = empresas.iterator();
                    while (segur.hasNext() && !achou) {
                        Seguradora atual = (Seguradora)segur.next();
                        cli = atual.identClient(leitura.replaceAll("\\D", ""));
                        if(cli != null){
                            achou = true;
                        }
                    }
                    if (!achou) {
                        System.out.println("Nenhuma Seguradora possui esse cliente cadastrado, por favor, verifique os dados");
                    }
                }while(!achou);
                //Obtem as outras informações do veículo
                System.out.println("Digite a Placa do novo veículo");
                infos.set(0, leitor.nextLine());
                System.out.println("Digite a Marca do novo veículo");
                infos.set(1, leitor.nextLine());
                System.out.println("Digite o Modelo do novo veículo");
                infos.set(2, leitor.nextLine());
                System.out.println("Digite o Ano de Fabricação do novo veículo");
                infos.set(3, leitor.nextLine());
                //Instancia o veículo
                vei = new Veiculo(infos.get(0), infos.get(1), infos.get(2), Integer.parseInt(infos.get(3)));
                //Cadastrando o veiculo
                if (cli.getClass().equals(ClientePF.class)) {
                    ((ClientePF)cli).cadastrarVeiculo(vei);
                } else {
                    ((ClientePJ)cli).atualizarFrota(((ClientePJ)cli).getListaFrota().get(((ClientePJ)cli).getListaFrota().size()-1).getCode(), vei, 1); 
                }
                System.out.println("O veículo de placa: " + vei.getplaca() + " foi adicionado ao cliente " + cli.getNome() + " com sucesso!");
            }
            else if (escolha == MenuOperacoesCad.SEGURADORA.getOperacao()){
                Boolean nome_ok, num_ok,cnpj_ok;
                Seguradora nova_seg;
                ArrayList<String> infos = new ArrayList<String>();
                for (int i = 0; i < 5; i++) {
                    infos.add("a");
                } 
                //Obtendo o nome da nova Seguradora
                System.out.println("Digite o nome da Seguradora a ser cadastrada:");
                do {
                    infos.set(0, leitor.nextLine());
                    nome_ok = Validacao.validaNome(infos.get(0));
                    if (!nome_ok) {
                        System.out.println("Por favor, digite um nome válido: (Apenas letras são suportadas)");
                    }
                } while (!nome_ok);
                //Obtendo o telefone da nova Seguradora
                System.out.println("Digite o número de telefone da nova seguradora:");
                do {
                    infos.set(1, leitor.nextLine().replaceAll("\\D", ""));
                    num_ok = Validacao.validaTelef(infos.get(1));
                    if (!num_ok) {
                        System.out.println("Por favor, digite um número válido: (Telefones devem possuir no mínimo 8 dígitos numéricos)");
                    }
                } while (!num_ok);
                //Obtendo os outros dados
                System.out.println("Digite o email da nova seguradora");
                infos.set(2, leitor.nextLine());
                System.out.println("Digite o endereço da nova seguradora");
                infos.set(3, leitor.nextLine());
                System.out.println("Digite o número de telefone da nova seguradora:");
                do {
                    infos.set(4, leitor.nextLine().replaceAll("\\D", ""));
                    cnpj_ok = Validacao.validarCNPJ(infos.get(4));
                    if (!cnpj_ok) {
                        System.out.println("Por favor, digite um CNPJ válido:");
                    }
                } while (!cnpj_ok);
                //Instanciando e relacionando a seguradora
                nova_seg = new Seguradora(infos.get(4), infos.get(0), infos.get(1), infos.get(2), infos.get(3));
                empresas.add(nova_seg);
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
                for (Seguradora atual : empresas) {
                    System.out.println("Listando os Clientes da Seguradora " + atual.getNome());
                    System.out.println("Clientes do tipo \"Pessoa Física\" :");
                    atual.listarClientes("ClientePF");
                    System.out.println("Clientes do tipo \"Pessoa Jurídica\" :");
                    atual.listarClientes("ClientePJ");
                    System.out.println("");
                }
            }
            else if (escolha == MenuOperacoesList.SIN_SEG.getOperacao()){
                for (Seguradora seg_atual : empresas) {
                    System.out.println("Listando os Sinistros da Seguradora " + seg_atual.getNome());
                    ArrayList<Sinistro> lista_sin = new ArrayList<Sinistro>();
                    for (Cliente cli_atual : seg_atual.getListaClientes()) {
                        lista_sin.addAll(seg_atual.getSinistrosPorCliente(cli_atual));
                    }
                    for (Sinistro sinistro : lista_sin) {
                        System.out.println(sinistro);
                }
                }
            }
            else if (escolha == MenuOperacoesList.SIN_CLI.getOperacao()){
                for (Seguradora seg_atual : empresas) {
                    for (Cliente cli_atual : seg_atual.getListaClientes()) {
                        System.out.println("Listando os Sinistros relacionados ao Cliente " + cli_atual.getNome());
                        for (Sinistro sinistro : seg_atual.getSinistrosPorCliente(cli_atual)) {
                            System.out.println(sinistro);
                        }
                    }
                }   
            }
            else if (escolha == MenuOperacoesList.VEI_SEG.getOperacao()){
                for (Seguradora seg_atual : empresas) {
                    System.out.println("Listando os Veiculos relacionados a Seguradora " + seg_atual.getNome());
                    for (Cliente cli_atual : seg_atual.getListaClientes()) {
                        for (Veiculo vei_atual : cli_atual.getlistaVeiculos()){
                            System.out.println(vei_atual.toString());
                        }
                    }
                }
            }
            else if (escolha == MenuOperacoesList.VEI_CLI.getOperacao()){
                for (Seguradora seg_atual : empresas) {
                    for (Cliente cli_atual : seg_atual.getListaClientes()) {
                        System.out.println("Listando os Veiculos relacionados ao Cliente " + cli_atual.getNome());
                        for (Veiculo vei_atual : cli_atual.getlistaVeiculos()){
                            System.out.println(vei_atual.toString());
                        }
                    }
                }
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
                Cliente cli = null;
                Seguradora seg = null;
                Boolean  achou = false;
                //Encontra o cliente que será excluído
                System.out.println("Digite o CPF/CNPJ do Cliente que será excluído");
                do{    
                    leitura = leitor.nextLine();
                    Iterator<Seguradora> segur = empresas.iterator();
                    while (segur.hasNext() && !achou) {
                        Seguradora atual = (Seguradora)segur.next();
                        cli = atual.identClient(leitura.replaceAll("\\D", ""));
                        if(cli != null){
                            achou = true;
                            seg = atual;
                        }
                    }
                    if (!achou) {
                        System.out.println("Nenhuma Seguradora possui esse cliente cadastrado, por favor, verifique os dados");
                    }
                }while(!achou);
                seg.removerCliente(cli.getNome());
                System.out.println("O cliente foi removido com sucesso!");
            }
            else if (escolha == MenuOperacoesExcl.VEICULO.getOperacao()){
                Veiculo vei = null;
                Cliente cli = null;
                Boolean  achou = false;
                //Encontra o veiculo que será excluído
                System.out.println("Digite a Placa do Veículo que será excluído");
                do{    
                    leitura = leitor.nextLine();
                    Iterator<Seguradora> segur = empresas.iterator();
                    while (segur.hasNext() && !achou) {
                        Seguradora seg_atual = (Seguradora)segur.next();
                        Iterator<Cliente> clientes = seg_atual.getListaClientes().iterator();
                        while (clientes.hasNext() && !achou) {
                            Cliente cli_atual = (Cliente)clientes.next();
                            vei = cli_atual.ident_Veiculo(leitura);
                            if(vei != null){
                                achou = true;
                                cli = cli_atual;
                            }
                        }
                    }
                    if (!achou) {
                        System.out.println("Veículo não encontrado, por favor, verifique os dados");
                    }
                }while(!achou);
                if (cli.getClass().equals(ClientePF.class)) {
                    ((ClientePF)cli).removerVeiculo(vei);
                } else {
                    String code = null;
                    for (Frota frota : ((ClientePJ)cli).getListaFrota()) {
                        if (frota.getlistaVeiculos().contains(vei)) {
                            code = frota.getCode();
                        }
                    }
                    ((ClientePJ)cli).atualizarFrota(code, vei, 2);
                }
                System.out.println("O veículo foi removido com sucesso!");
            }
            else if (escolha != MenuOperacoesExcl.VOLTAR.getOperacao()){
                System.out.println("Por favor, as opções válidas são apenas números de 0 a 3 (inclusos).");
            }

        } while (escolha != MenuOperacoesExcl.VOLTAR.getOperacao());
    }
}