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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ClassNote.DTOs.DisciplinaDTO;
import com.api.ClassNote.Model.DisciplinaModel;
import com.api.ClassNote.Model.ProfessorModel;
import com.api.ClassNote.Services.DisciplinaService;
import com.api.ClassNote.Services.ProfessorService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/disciplina")
public class DisciplinaController {
  
	 @Autowired
	 DisciplinaService _disciplinaService;
	 ProfessorService _professorService;
	 
	 public DisciplinaController() {
		 
	 }
	 
	 @PostMapping
	 public ResponseEntity<Object> salvaDisciplina(@RequestBody  @Valid DisciplinaDTO disciplinaD){
         DisciplinaModel disciplinaM = new DisciplinaModel();
		 BeanUtils.copyProperties(disciplinaD, disciplinaM);
		 var salvo = _disciplinaService.save(disciplinaM);
	 if(salvo != null) {
			return ResponseEntity.status(HttpStatus.OK).body(disciplinaM);
	   }
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nao foi possivel fazer o registo");
	}
	 
	@GetMapping
	public ResponseEntity<List<DisciplinaModel>> listarDisciplina(){
	  	return ResponseEntity.status(HttpStatus.OK).body(_disciplinaService.findAll());
	}
	 
	@GetMapping("/{id}")
	public ResponseEntity<Object> umaDisciplina(@PathVariable (value = "id") UUID id){
		Optional<DisciplinaModel> disciplinaO = _disciplinaService.findById(id);
		if(disciplinaO.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(disciplinaO.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id da disciplina Fornecido nao existe");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDisciplina(@PathVariable (value = "id") UUID id){
		Optional<DisciplinaModel> disciplinaO = _disciplinaService.findById(id);
		if(disciplinaO.isPresent()) {
		 _disciplinaService.delete(disciplinaO.get());
			 return ResponseEntity.status(HttpStatus.OK).body("Disciplina apagada");
		 }
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id da disciplina fornecido nao existe");
	}
}
