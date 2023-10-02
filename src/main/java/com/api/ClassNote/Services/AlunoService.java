package com.api.ClassNote.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.ClassNote.Model.*;
import com.api.ClassNote.Repositorios.*;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {
  
	final AlunoRepository _alunoRepository;
	
	public AlunoService(AlunoRepository aluno) {
		_alunoRepository = aluno;
	}
	
	@Transactional 
	public AlunoModel save(AlunoModel aluno) {
		return _alunoRepository.save(aluno);
	}
	
	public List<AlunoModel> findAll(){
		return _alunoRepository.findAll();
	}
	
	public Optional<AlunoModel> findById(UUID id) {
		return _alunoRepository.findById(id);
	}
	
	@Transactional  
	public void delete(AlunoModel aluno) {
		_alunoRepository.delete(aluno);
	}
	
	public boolean existsById(UUID id) {
		if(_alunoRepository.existsById(id)) {
			return true;
		}
		return false;
	}
}
