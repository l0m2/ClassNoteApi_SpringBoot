package Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Model.turmaModel;

import Repositorios.TurmaRepository;
import jakarta.transaction.Transactional;

@Service
public class TurmaService {

	final TurmaRepository _turmaRepository;
	
	public TurmaService(TurmaRepository turma) {
		_turmaRepository = turma;
	}
	
	@Transactional
	public turmaModel save(turmaModel turma) {
		return _turmaRepository.save(turma);
	}
	
	public List<turmaModel> findAll(){
		return _turmaRepository.findAll();
	}
	
	public Optional<turmaModel> findById(UUID id) {
		return _turmaRepository.findById(id);
	}
	
	@Transactional 
	public void delete(turmaModel turma) {
		_turmaRepository.delete(turma);
	}
	
	public boolean existsById(UUID id) {
		if(_turmaRepository.existsById(id)) {
			return true;
		}
		return false;
	}
}
