package Services;

import Repositorios.ProfessorRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Model.ProfessorModel;

@Service
public class ProfessorService {

	final ProfessorRepository _professorRepository;
	
	public ProfessorService(ProfessorRepository professorRepository) {
		_professorRepository = professorRepository;
	}
	
	@Transactional
	public ProfessorModel save(ProfessorModel professor) {
	 return _professorRepository.save(professor);
	}
	
	public List<ProfessorModel> findAll(){
		return _professorRepository.findAll();
	}
	
	public Optional<ProfessorModel> findById(UUID id){
		return _professorRepository.findById(id);
	}
	
	@Transactional
	public void delete(ProfessorModel professor) {
		_professorRepository.delete(professor);
	}
	
	public boolean existsById(UUID id) {
		if(_professorRepository.existsById(id)) {
			return true;
		}
		return false;
	}
	
}
