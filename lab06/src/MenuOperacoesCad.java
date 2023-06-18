public enum MenuOperacoesCad {
    CLIENTE (1) ,
    VEICULO (2) ,
    SEGURADORA (3) ,
    VOLTAR (0) ;

    public final int operacao ;

    MenuOperacoesCad ( int operacao ) {
        this . operacao = operacao ;
    }

    public int getOperacao () {
        return this . operacao ;
    }


}
