public enum MenuOperacoesExcl {
    CLIENTE (1) ,
    VEICULO (2) ,
    VOLTAR (0) ;


    public final int operacao ;

    MenuOperacoesExcl ( int operacao ) {
        this . operacao = operacao ;
    }

    public int getOperacao () {
        return this . operacao ;
    }


}
