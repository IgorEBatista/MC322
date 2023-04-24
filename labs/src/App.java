import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> lista = new ArrayList<>();
        System.out.println("Hello, World!");
        
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(9);


        System.out.println(lista);

        lista.remove(null);

        System.out.println(lista);
        
    }

/*


        // do {
        //     System.out.println("Escolha o modo de funcionamento:\n1 - Modo Automático de Demonstração\n2 - Modo Interativo (1/2)");            
        //     modo = Integer.valueOf(leitor.nextInt());
        //     if (modo == 1 || modo == 2) {
        //         iniciado = true;                
        //     } else {
        //         System.out.println("Por favor, escolha uma opção válida!\n(1/2)");
        //     }
        // } while (!iniciado);


        
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