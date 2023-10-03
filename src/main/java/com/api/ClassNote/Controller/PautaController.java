package com.api.ClassNote.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.ClassNote.Model.*;
import com.api.ClassNote.DTOs.PautaDTO;
import com.api.ClassNote.Services.AlunoService;
import com.api.ClassNote.Services.PautaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/pauta")
public class PautaController {

	 @Autowired
	 PautaService pautaService;
	 @Autowired
	 AlunoService alunoService;
	 
	 public PautaController() {
		 
	 }
	 
	 private Optional<PautaModel> pautaO;
	 private PautaModel pautaM = new PautaModel();
	 private Optional<AlunoModel> alunoO;
	 
	 @PostMapping 
	 public ResponseEntity<Object> salvaPauta (@RequestBody @Valid PautaDTO pautaD){
		 alunoO = alunoService.findById(pautaD.getAluno_id());
		 if(alunoO.isPresent()) {
		   BeanUtils.copyProperties(pautaD, pautaM);
		   pautaM.setAluno(alunoO.get());
		   var salvo = pautaService.save(pautaM);
		   if(salvo != null) {
			   return ResponseEntity.status(HttpStatus.OK).body(salvo);
		   }
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro no registo da pauta");
		 }
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id do aluno fornecido nao existe");
	 }
	 
	 @GetMapping
	 public ResponseEntity<List<PautaModel>> ListarPauta(){
		 return ResponseEntity.status(HttpStatus.OK).body(pautaService.findAll());
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Object> umPauta(@PathVariable (value = "id") UUID id){
	  pautaO = pautaService.findById(id);
	  if(pautaO.isPresent()) {
	   return ResponseEntity.status(HttpStatus.OK).body(pautaO.get()); 
	  }
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id da pauta fornecido nao existe");
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deletePauta(@PathVariable (value = "id") UUID id){
		  pautaO = pautaService.findById(id);
		  if(pautaO.isPresent()) { 
		pautaService.delete(pautaO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Apagado com sucesso");
		  }
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id da pauta fornecido nao existe");
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Object> atualizaPauta(@PathVariable (value = "id") UUID id, @RequestBody @Valid PautaDTO pautaD){
		 pautaO = pautaService.findById(id);
		  if(pautaO.isPresent()) {  
			  alunoO = alunoService.findById(pautaD.getAluno_id());
		if(alunoO.isPresent()) {
		BeanUtils.copyProperties(pautaD, pautaM);
		pautaM.setAluno(alunoO.get());
		pautaM.setId(alunoO.get().getId());
		pautaService.save(pautaM);
		return ResponseEntity.status(HttpStatus.OK).body(pautaService.save(pautaM));
				 }
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id do aluno fornecido nao existe");		 
	 }
 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id da pauta fornecido nao existe");
}
}
