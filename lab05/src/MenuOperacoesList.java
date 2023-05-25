public enum MenuOperacoesList {
    CLI_SEG (1) ,
    SIN_SEG (2) ,
    SIN_CLI (3) ,
    VEI_SEG (4) ,
    VEI_CLI (5) ,
    VOLTAR (0) ;

    public final int operacao ;

    MenuOperacoesList ( int operacao ) {
        this . operacao = operacao ;
    }

    public int getOperacao () {
        return this . operacao ;
    }


}
