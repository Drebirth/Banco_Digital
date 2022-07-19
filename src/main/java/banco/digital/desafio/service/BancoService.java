package banco.digital.desafio.service;

import banco.digital.desafio.model.Banco;
import banco.digital.desafio.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoService {

    private BancoRepository banco;

    @Autowired
    public BancoService(BancoRepository banco){
        this.banco = banco;
    }

    public List<Banco> all(){
        return banco.findAll();
    }

    public Banco post(Banco b){
        return banco.save(b);
    }

    public Banco find(Long id){
         var b = findId(id);
         return b;
    }


    private Banco findId(Long id){
        return banco.findById(id).orElseThrow();
    }









}
