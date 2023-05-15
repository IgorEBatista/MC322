public enum MenuOperacoesPrin {
    CADASTRAR (1) ,
    LISTAR (2) ,
    EXCLUIR (3) ,
    SINISTRAR (4) ,    
    TRANSFERIR (5) ,
    CALCULAR (6) ,
    SAIR (0) ;

    public final int operacao ;

    MenuOperacoesPrin ( int operacao ) {
        this . operacao = operacao ;
    }

    public int getOperacao () {
        return this . operacao ;
    }


}
