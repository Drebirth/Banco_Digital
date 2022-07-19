package banco.digital.desafio.service;

import banco.digital.desafio.exceptions.UsuarioNaoEncontrado;
import banco.digital.desafio.exceptions.contaUsuario.ValorException;
import banco.digital.desafio.model.Conta;
import banco.digital.desafio.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private ContaRepository conta;

    private BancoService banco;

    @Autowired
    public ContaService(ContaRepository conta, BancoService banco){
        this.conta = conta;
        this.banco = banco;
    }

    public List<Conta> all(){
        return conta.findAll();
    }

    public Conta post(Long id, Conta c) throws Exception{
        var b = banco.find(id);
        b.setId(b.getId());
        c.setBanco(b);
        //c.setConta(String.valueOf(TipoConta.poupança));
        return conta.save(c);
    }

    public Conta encontrar(Long id) throws UsuarioNaoEncontrado{
        var c = find(id);
        return c;
    }

    public Conta depositar(Long id, Conta c)throws UsuarioNaoEncontrado{
        var idDeposito = encontrar(id);
        c.setId(idDeposito.getId());
        c.setSaldo(idDeposito.getSaldo());
        conta.save(c);
        c.setSaldo(c.getSaldo() + c.getValor());
        return conta.save(c);

    }

    public Conta sacar(Long id, Conta c) throws UsuarioNaoEncontrado, ValorException{
        var idConta = encontrar(id);
           c.setId(idConta.getId());
           c.setSaldo(idConta.getSaldo());
           conta.save(c);
           if(c.getValor() < c.getSaldo()){
            c.setSaldo(c.getSaldo() - idConta.getValor());
            conta.save(c);
            }else{
            throw new ValorException(c.getSaldo(), c.getValor()); }
            return c;
        }

    public Conta transferir(Long id, Conta c) throws UsuarioNaoEncontrado, ValorException{
        var idConta1 = encontrar(id);
        idConta1.setValor(c.getValor());
        idConta1 = sacar(id,idConta1 );
        conta.save(idConta1);
        c = depositar(c.getId(), c);
        conta.save(c);
        return idConta1;

    }
    


    private Conta find(Long id) throws UsuarioNaoEncontrado{
        return conta.findById(id).orElseThrow(() ->
        new UsuarioNaoEncontrado(id));
    }


}
