public enum MenuOperacoesPrin {
    CADASTRAR (1) ,
    LISTAR (2) ,
    SINISTRAR (3) ,    
    TRANSFERIR (4) ,
    CALCULAR (5) ,
    EXCLUIR (6) ,
    SAIR (0) ;

    public final int operacao ;

    MenuOperacoesPrin ( int operacao ) {
        this . operacao = operacao ;
    }

    public int getOperacao () {
        return this . operacao ;
    }


}
