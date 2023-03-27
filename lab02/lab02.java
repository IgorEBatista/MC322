import java.util.Scanner;

public class lab02 {
    public static void main(String[] args) {
        Veiculo testVeiculo = new Veiculo("aaa","bbb","ccc");
        System.out.println(testVeiculo);
        testVeiculo.toString();

        Cliente testCliente = new Cliente("nome","07597667469",90,"12/09/1920","Rua dos bobos nº0");
        System.out.println(testCliente);
        testCliente.toString();

        //Scanner leitor = new Scanner(System.in);
        //leitor.next();
        //testCliente.setcpf(leitor.toString());
        
        
        
    }
}
