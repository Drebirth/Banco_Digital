package banco.digital.desafio.service;

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

    public Conta post(Long id, Conta c){
        var b = banco.find(id);
        b.setId(b.getId());
        c.setBanco(b);
        //c.setConta(String.valueOf(TipoConta.poupança));
        return conta.save(c);
    }

    private double deposito(Conta a){
         a.setSaldo(a.getSaldo());
         return banco.post(a);
    }

    private double movimentacao(Conta a, Conta b){
        var c = a.getSaldo() - a.getSaldo();
        return c;
    }


}
