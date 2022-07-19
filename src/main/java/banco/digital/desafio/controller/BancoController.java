package banco.digital.desafio.controller;

import banco.digital.desafio.model.Banco;
import banco.digital.desafio.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
public class BancoController {


    private BancoService banco;

    @Autowired
    public BancoController(BancoService banco){
        this.banco = banco;
    }

    @GetMapping("/")
    public List<Banco> all(){
        return  banco.all();
    }

    @PostMapping("/")
    public void post(@RequestBody Banco b){
         banco.post(b);
    }



}
