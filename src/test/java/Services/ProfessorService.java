package Services;

import Repositorios.ProfessorRepository;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Model.ProfessorModel;

@Service
public class ProfessorService {

	final ProfessorRepository _professorRepository;
	
	public ProfessorService(ProfessorRepository professorRepository) {
		_professorRepository = professorRepository;
	}
	
	@Transactional
	public ProfessorRepository save(ProfessorRepository professor) {
	 return _professorRepository.save(professor);
	}
	
	public List<ProfessorModel> findAll(){
		return _professorRepository.findAll();
	}
}
