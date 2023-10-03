package com.api.ClassNote.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.api.ClassNote.DTOs.AlunoDTO;
import com.api.ClassNote.Model.AlunoModel;
import com.api.ClassNote.Model.TurmaModel;
import com.api.ClassNote.Services.AlunoService;
import com.api.ClassNote.Services.TurmaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping ("/aluno")
public class AlunoController {
   
	@Autowired 
	AlunoService alunoService;
	@Autowired
	TurmaService turmaService;
	private AlunoModel alunoM =  new AlunoModel();
	private Optional<AlunoModel> alunoO;
	private Optional<TurmaModel> turmaO;
	
	public AlunoController() {
		
	}
	
	@PostMapping
	public ResponseEntity<Object> salvaAluno(@RequestBody @Valid AlunoDTO alunoD){
		turmaO = turmaService.findById(alunoD.getTurma_id());
		if(turmaO.isPresent()) {
			BeanUtils.copyProperties(alunoD, alunoM);
			alunoM.setTurma(turmaO.get());
			var salvo = alunoService.save(alunoM);
			if(salvo != null) {
		 return ResponseEntity.status(HttpStatus.OK).body(alunoM);
			}
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro no cadastro do aluno");
		}
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id da turma Fornecido nao existe");
	}
	
	@GetMapping 
	public ResponseEntity<List<AlunoModel>> listarAlunos(){
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> umAluno(@PathVariable (value = "id") UUID id){
	  alunoO =  alunoService.findById(id);
	  if(alunoO.isPresent()) {
		  return ResponseEntity.status(HttpStatus.OK).body(alunoO.get());
	  }
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O id do aluno fornecido nao existe");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagarAluno(@PathVariable (value = "id") UUID id){
	  alunoO = alunoService.findById(id);
	  if(alunoO.isPresent()) {
		  alunoService.delete(alunoO.get());
		  return ResponseEntity.status(HttpStatus.OK).body("Aluno apagado com sucesso");
	  }
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id do aluno fornecido nao existe");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizaAluno(@PathVariable (value="id") UUID id, @RequestBody @Valid AlunoDTO alunoD){
	 alunoO = alunoService.findById(id);
	 if(alunoO.isPresent()) {
		turmaO = turmaService.findById(alunoD.getTurma_id());
		if(turmaO.isPresent()) {
		 BeanUtils.copyProperties(alunoD,alunoM);
		 alunoM.setTurma(turmaO.get());
		 alunoM.setId(id);
		 alunoService.save(alunoM);
		 return ResponseEntity.status(HttpStatus.OK).body(alunoM);
		}
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id da turma fornecida nao existe");
	 }
	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id do aluno fornecido nao existe");
	}
}
