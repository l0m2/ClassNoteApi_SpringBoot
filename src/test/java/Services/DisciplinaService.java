package Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Model.DisciplinaModel;

import Repositorios.DisciplinaRepository;
import jakarta.transaction.Transactional;

@Service
public class DisciplinaService {
 
	final DisciplinaRepository _disciplinaRepository;
	
	public DisciplinaService(DisciplinaRepository disciplinaRepository) {
		_disciplinaRepository = disciplinaRepository;
	}
	
	@Transactional
	public DisciplinaModel save(DisciplinaModel disciplina) {
		return _disciplinaRepository.save(disciplina);
	}
	
	public List<DisciplinaModel> findAll() {
		return _disciplinaRepository.findAll();
	}
	
	public Optional<DisciplinaModel> findById(UUID id){
		return _disciplinaRepository.findById(id);
	}
	
	@Transactional 
	public void delete(DisciplinaModel disciplina) {
		_disciplinaRepository.delete(disciplina);
	}
	
	public boolean existsById(UUID id) {
		if(_disciplinaRepository.existsById(id)) {
			return true;
		}
		return false;
	}
}
