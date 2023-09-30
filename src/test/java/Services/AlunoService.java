package Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Model.alunoModel;
import com.Model.turmaModel;

import Repositorios.AlunoRepository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {
  
	final AlunoRepository _alunoRepository;
	
	public AlunoService(AlunoRepository aluno) {
		_alunoRepository = aluno;
	}
	
	@Transactional 
	public alunoModel save(alunoModel aluno) {
		return _alunoRepository.save(aluno);
	}
	
	public List<alunoModel> findAll(){
		return _alunoRepository.findAll();
	}
	
	public Optional<alunoModel> findById(UUID id) {
		return _alunoRepository.findById(id);
	}
	
	@Transactional  
	public void delete(alunoModel aluno) {
		_alunoRepository.delete(aluno);
	}
	
	public boolean existsById(UUID id) {
		if(_alunoRepository.existsById(id)) {
			return true;
		}
		return false;
	}
}
