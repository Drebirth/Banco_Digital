package banco.digital.desafio.repository;

import banco.digital.desafio.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {


}
