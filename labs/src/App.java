public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        char a = '2';
        int a1 = a;
        System.out.println(a1); //50
        int a2 = Integer.valueOf(a);
        System.out.println(a2);//50
        int a3 = Character.valueOf(a);
        System.out.println(a3);//50
        int a4 = Character.getNumericValue(a);
        System.out.println(a4);//2
    }
}
