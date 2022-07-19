package banco.digital.desafio.controller;

import banco.digital.desafio.model.Conta;
import banco.digital.desafio.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {


    private ContaService conta;

    @Autowired
    public ContaController(ContaService conta){
        this.conta = conta;
    }


    @GetMapping("/")
    public List<Conta> all(){
        return conta.all();
    }


    @PostMapping("/{id}")
    public Conta post(@PathVariable Long id, @RequestBody Conta c ){
        return conta.post(id,c);
    }

}
