import java.util.Scanner;

public class Lab02 {

    public static void main(String[] args) {
        int modo = 0;
        boolean iniciado = false;
        Scanner leitor = new Scanner(System.in);

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
            Cliente cliente = new Cliente("Pedro","83371911047",23,"29/02/2000","Rua Roxo Moreira, nº3000");
            Veiculo veiculo = new Veiculo("LAB0O02", "MC", "322A");
            Seguradora seguradora = new Seguradora("IC Seguros", "3521-5838", "ic_seguros@gmail.com", "Av. Albert Einstein, 1251");
            Sinistro sinistro = new Sinistro("17/07/2023","Rua da Reitoria, 109");
            
            //Impressão dos objetos
            System.out.println(cliente.toString());
            System.out.println(veiculo.toString());
            System.out.println(seguradora.toString());
            System.out.println(sinistro.toString());

            //Teste de Setters
            System.out.println("Mudando nome e CPF");
            cliente.setNome("Joaquim");
            cliente.setcpf("498.456.590-45");
            cliente.setcpf("127.726.730-81");
            System.out.println(cliente.toString());
            
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
                
            } while (rodando);
        }
    leitor.close();
    }
}
