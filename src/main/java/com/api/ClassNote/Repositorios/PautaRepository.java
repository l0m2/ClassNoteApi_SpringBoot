package com.api.ClassNote.Repositorios;
import com.api.ClassNote.Model.*;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<PautaModel , UUID> {

}
