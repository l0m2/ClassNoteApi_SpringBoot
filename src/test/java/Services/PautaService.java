package Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Model.pautaModel;

import Repositorios.PautaRepository;
import jakarta.transaction.Transactional;

@Service
public class PautaService {

	final PautaRepository _pautaRepository;
	
	public PautaService(PautaRepository pauta) {
		_pautaRepository = pauta;
	}
	
	@Transactional
	public pautaModel save(pautaModel pauta) {
		return _pautaRepository.save(pauta);
	}
	
	public List<pautaModel> findAll(){
		return _pautaRepository.findAll();
	}
	
	public Optional<pautaModel> findById(UUID id){
		return _pautaRepository.findById(id);
	}
	
	@Transactional
	public void delete(pautaModel pauta) {
		_pautaRepository.delete(pauta);
	}

}
