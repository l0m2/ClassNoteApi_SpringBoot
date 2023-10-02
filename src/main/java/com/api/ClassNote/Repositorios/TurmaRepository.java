package com.api.ClassNote.Repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ClassNote.Model.TurmaModel;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, UUID> {

}
