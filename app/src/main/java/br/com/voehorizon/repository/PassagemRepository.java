package br.com.voehorizon.repository;

import br.com.voehorizon.model.Passageiro;
import br.com.voehorizon.model.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {
}
