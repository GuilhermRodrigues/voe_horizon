package br.com.voehorizon.repository;

import br.com.voehorizon.model.ClasseVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseVooRepository extends JpaRepository<ClasseVoo, Long> {
}
