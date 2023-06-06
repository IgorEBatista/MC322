import java.util.ArrayList;

public class App {
    
    public static void main(String[] args){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        System.out.println(lista.remove(1));
        System.out.println(lista.remove(null));
    }
}
