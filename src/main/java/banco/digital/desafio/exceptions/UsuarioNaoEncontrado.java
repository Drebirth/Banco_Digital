package banco.digital.desafio.exceptions;

public class UsuarioNaoEncontrado extends Exception{

    public UsuarioNaoEncontrado(Long id){
        super("Usuario não encontrado!");
    }
    
}
