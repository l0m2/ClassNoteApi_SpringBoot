package com.api.ClassNote.Repositorios;
import com.api.ClassNote.Model.*;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, UUID> {

}
