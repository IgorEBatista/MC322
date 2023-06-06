public class Validacao {

    public static boolean validarCNPJ(String cnpj){
        //Validador de cnpj
        int pdig = 0, sdig = 0, j;
        boolean igual = true;
            
        //Limpa a String
        for (int i  = 0; i<cnpj.length(); i++){
            char c = cnpj.charAt(i);
            if ( !Character.isDigit(c)){
                cnpj = cnpj.replaceAll("\\D", "");
            }
        }        
        //Conta digitos
        if (cnpj.length() != 14) {
            return false;
        }

        //Verifica igualdade
        for (int i  = 1; i<cnpj.length() && igual ; i++) {
            if (cnpj.charAt(i) != cnpj.charAt(0)) {
                igual = false;
            }
        }
        if (igual){
            return false;
        }
        
        //Calcula o primeiro dígito verificador

        for (int i = 0; i < (cnpj.length() - 2); i++) {
            j = 5 - i;
            if (j < 2 ) j += 8;

            pdig +=(Character.getNumericValue(cnpj.charAt(i))) * j;
        }
        pdig = pdig % 11;
        if (pdig < 2) {
            pdig = 0;
        }else pdig = 11 - pdig;

        if (pdig != Character.getNumericValue(cnpj.charAt(cnpj.length() - 2))) {
            return false;
            
        }
    
        //Calcula o segundo dígito verificador

        for (int i = 0; i < (cnpj.length() - 1); i++) {
            j = 6 - i;
            if (j < 2) j += 8;

            sdig +=(Character.getNumericValue(cnpj.charAt(i))) * j;
        }
        sdig = sdig % 11;
        if (sdig < 2) {
            sdig = 0;
        }else sdig = 11 - sdig;

        if (sdig != Character.getNumericValue(cnpj.charAt(cnpj.length() - 1))) {
            return false;
            
        }

        return true;
    }


    public static boolean validarCPF(String cpf){
        //Validador de cpf
        int pdig = 0, sdig = 0;
        boolean igual = true;
            
    
        for (int i  = 0; i<cpf.length(); i++){
            char c = cpf.charAt(i);
            if ( !Character.isDigit(c)){
                cpf = cpf.replaceAll("\\D", "");
            }
        }        
        //Conta digitos
        if (cpf.length() != 11) {
            return false;
        }

        //Verifica igualdade
        for (int i  = 1; i<cpf.length() && igual ; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                igual = false;
            }
        }
        if (igual){
            return false;
        }
        
        //Calcula o primeiro dígito verificador

        for (int i = 0; i < (cpf.length() - 2); i++) {
            pdig +=((cpf.charAt(i))- 48) * (10 - i);
        }
        pdig = (pdig * 10) % 11;
        if (pdig>=10) {
            pdig = 0;
        }

        if (pdig != cpf.charAt(9) - '0') {
            return false;
            
        }
    
        //Calcula o segundo dígito verificador

        for (int i = 0; i < (cpf.length() - 1); i++) {
            sdig +=((cpf.charAt(i) - 48) * (11 - i));
        }
        sdig = (sdig * 10) % 11;
        if (sdig>=10) {
            sdig = 0;
        }

        if (sdig != cpf.charAt(10) - '0') {
            return false;
            
        }

        return true;
    }

    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z]{1,}");
    }
    public static boolean validaTelef(String tlf) {
        return tlf.length() >= 8;
    }

    public static String limpaNum(String numero) {
        return numero.replaceAll("\\D", "");
    }
}