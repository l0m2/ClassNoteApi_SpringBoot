package com.api.ClassNote.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.ClassNote.Model.*;
import com.api.ClassNote.Repositorios.*;
import jakarta.transaction.Transactional;

@Service
public class TurmaService {

	final TurmaRepository _turmaRepository;
	
	public TurmaService(TurmaRepository turma) {
		_turmaRepository = turma;
	}
	
	@Transactional
	public TurmaModel save(TurmaModel turma) {
		return _turmaRepository.save(turma);
	}
	
	public List<TurmaModel> findAll(){
		return _turmaRepository.findAll();
	}
	
	public Optional<TurmaModel> findById(UUID id) {
		return _turmaRepository.findById(id);
	}
	
	@Transactional 
	public void delete(TurmaModel turma) {
		_turmaRepository.delete(turma);
	}
	
	public boolean existsById(UUID id) {
		if(_turmaRepository.existsById(id)) {
			return true;
		}
		return false;
	}
}
