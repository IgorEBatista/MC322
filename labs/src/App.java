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
}
