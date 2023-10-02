package com.api.ClassNote.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.ClassNote.Repositorios.*;
import com.api.ClassNote.Model.*;
import jakarta.transaction.Transactional;

@Service
public class PautaService {

	final PautaRepository _pautaRepository;
	
	public PautaService(PautaRepository pauta) {
		_pautaRepository = pauta;
	}
	
	@Transactional
	public PautaModel save(PautaModel pauta) {
		double media = pauta.CalcularMedia();
		pauta.setMedia(media);
		return _pautaRepository.save(pauta);
	}
	
	public List<PautaModel> findAll(){
		return _pautaRepository.findAll();
	}
	
	public Optional<PautaModel> findById(UUID id){
		return _pautaRepository.findById(id);
	}
	
	@Transactional
	public void delete(PautaModel pauta) {
		_pautaRepository.delete(pauta);
	}

}
