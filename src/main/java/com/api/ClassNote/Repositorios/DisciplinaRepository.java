package com.api.ClassNote.Repositorios;

import org.springframework.stereotype.Repository;
import com.api.ClassNote.Model.*;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, UUID> {

}
