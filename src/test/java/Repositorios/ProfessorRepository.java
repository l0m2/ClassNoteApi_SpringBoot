package Repositorios;

import org.springframework.stereotype.Repository;
import com.Model.ProfessorModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, UUID> {

}
