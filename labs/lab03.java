import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab03 {

    public static void main(String[] args) throws ParseException {
        int modo = 0;
        boolean iniciado = false;
        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


        do {
            System.out.println("Escolha o modo de funcionamento:\n1 - Modo Automático de Demonstração\n2 - Modo Interativo (1/2)");            
            modo = Integer.valueOf(leitor.nextInt());
            if (modo == 1 || modo == 2) {
                iniciado = true;                
            } else {
                System.out.println("Por favor, escolha uma opção válida!\n(1/2)");
            }
        } while (!iniciado);
        
        if (modo == 1) {
            //Instanciamento de objetos
            Date data_carteira = formato.parse("20/04/2023");
            Date data_nasc = formato.parse("29/02/2000");
            Date data_acidente = formato.parse("21/04/2023");

            ClientePF cliente = new ClientePF("Pedro","Rua Roxo Moreira, nº3000","83371911047", "Masculino", data_carteira, "Superior Incompleto", data_nasc, "Alta");
            Veiculo veiculo = new Veiculo("LAB0O02", "MC", "322A", 0000);
            Seguradora seguradora = new Seguradora("IC Seguros", "3521-5838", "ic_seguros@gmail.com", "Av. Albert Einstein, 1251");
            Sinistro sinistro = new Sinistro(data_acidente,"Rua da Reitoria, 109", veiculo, cliente);
            
            //Impressão dos objetos
            System.out.println(cliente.toString());
            System.out.println(veiculo.toString());
            System.out.println(seguradora.toString());
            System.out.println(sinistro.toString());
            System.out.println(cliente.toString());
        /*    
        } else {
            int escolha;
            boolean rodando = true;
            
            do {
                //Verifica o objetivo do usuário
                System.out.println("Escolha o que deseja criar:\n" +
                                    "1 - Cliente\n" +
                                    "2 - Veículo\n" +
                                    "3 - Seguradora\n" +
                                    "4 - Sinistro\n" +
                                    "0 - FECHAR PROGRAMA");
                
                escolha = leitor.nextInt();

                if (escolha == 1) {
                    //Cria Cliente
                    String Nome, CPF, Nascimento, Idade, Endereco;
                    System.out.println("Digite o Nome:");
                    leitor.nextLine();
                    Nome = leitor.nextLine();

                    do {
                    System.out.println("Digite o CPF:");
                    CPF = leitor.nextLine();
                    } while (!Cliente.validarCPF(CPF));

                    System.out.println("Digite a Data de Nascimento:");
                    Nascimento = leitor.nextLine();
                    System.out.println("Digite a Idade:");
                    Idade = leitor.nextLine();
                    System.out.println("Digite o Endereço:");
                    Endereco = leitor.nextLine();

                    Cliente cliente = new Cliente(Nome, CPF, Integer.valueOf(Idade), Nascimento, Endereco);
                    System.out.println(cliente.toString());

                } else if(escolha == 2){
                    //Cria Veículo
                    String Placa, Marca, Modelo;
                    System.out.println("Digite a Placa:");
                    leitor.nextLine();
                    Placa = leitor.nextLine();
                    System.out.println("Digite a Marca:");
                    Marca = leitor.nextLine();
                    System.out.println("Digite o Modelo:");
                    Modelo = leitor.nextLine();

                    Veiculo veiculo = new Veiculo(Placa,  Marca, Modelo);
                    System.out.println(veiculo.toString());

                } else if(escolha == 3){
                    //Cria Seguradora
                    String Nome, Telefone, email, Endereco;
                    System.out.println("Digite o Nome:");
                    leitor.nextLine();
                    Nome = leitor.nextLine();
                    System.out.println("Digite o Telefone:");
                    Telefone = leitor.nextLine();
                    System.out.println("Digite o email:");
                    email = leitor.nextLine();
                    System.out.println("Digite o Endereço:");
                    Endereco = leitor.nextLine();

                    Seguradora seguradora = new Seguradora(Nome, Telefone, email, Endereco);
                    System.out.println(seguradora.toString());

                } else if(escolha == 4){
                    //Cria Sinistro
                    String Data, Endereco;
                    System.out.println("Digite a Data:");
                    leitor.nextLine();
                    Data = leitor.nextLine();
                    System.out.println("Digite o Endereço:");
                    Endereco = leitor.nextLine();

                    Sinistro sinistro = new Sinistro(Data, Endereco);
                    System.out.println(sinistro.toString());

                } else if(escolha == 0){
                    //Fecha o programa
                    rodando = false;
                } else {
                    System.out.println("Por favor, escolha uma opção válida (1/2/3/4/0)");
                }
            } while (rodando);*/
        }
    leitor.close();
    } 
}
