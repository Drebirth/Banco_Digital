package banco.digital.desafio.controller;

import banco.digital.desafio.exceptions.UsuarioNaoEncontrado;
import banco.digital.desafio.exceptions.contaUsuario.ValorException;
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
    public Conta post(@PathVariable Long id, @RequestBody Conta c )throws Exception{
        return conta.post(id,c);
    }

    @GetMapping("/{id}")
    public Conta encontrar(@PathVariable Long id) throws UsuarioNaoEncontrado{
        return conta.encontrar(id);
    }

    @PutMapping("/{id}")
    public Conta depositar(@PathVariable Long id, @RequestBody Conta c) throws UsuarioNaoEncontrado{
        return conta.depositar(id, c);
    }

    @PutMapping("/sacar/{id}")
    public Conta sacar(@PathVariable Long id, @RequestBody Conta c)throws UsuarioNaoEncontrado, ValorException{
        return conta.sacar(id, c);
    }

    @PutMapping("/transferir/{id}")
    public Conta transferir(@PathVariable Long id, Conta c) throws UsuarioNaoEncontrado, ValorException{
        return conta.transferir(id, c);
    }

}
