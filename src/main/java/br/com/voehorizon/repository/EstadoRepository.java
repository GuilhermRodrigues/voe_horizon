package br.com.voehorizon.repository;

import br.com.voehorizon.model.Estado;
import br.com.voehorizon.model.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Estado findByUf(String uf);
}
