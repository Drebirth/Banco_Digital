package banco.digital.desafio.exceptions.contaUsuario;

public class ValorException extends Exception {
    public ValorException(double d, double b){
        super("O valor de retirada:R$" + b+ " nao pode ser maior do que o valor em conta:R$" + d );
    }
}
