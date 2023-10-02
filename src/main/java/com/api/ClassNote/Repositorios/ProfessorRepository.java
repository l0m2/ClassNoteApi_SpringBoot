package com.api.ClassNote.Repositorios;
import com.api.ClassNote.Model.*;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, UUID> {

	//boolean verificarSeExiste(String s);

}
