import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
    private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws Exception {
        LocalDate dataL = LocalDate.now();
        Date dataN = formato.parse(dataL.toString()); 
        System.out.println(dataN);
    }
}
