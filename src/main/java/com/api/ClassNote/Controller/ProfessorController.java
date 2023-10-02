package com.api.ClassNote.Controller;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

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

import com.api.ClassNote.DTOs.ProfessorDTO;
import com.api.ClassNote.Model.ProfessorModel;
import com.api.ClassNote.Services.ProfessorService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/professor")
public class ProfessorController {
	
	final ProfessorService _professorService;
	@Autowired 
	public ProfessorController(ProfessorService professor) {
		_professorService = professor;
	}
	
	 @PostMapping
	 public ResponseEntity<Object> salvaProfessor(@RequestBody @Valid ProfessorDTO professorD){
/* 
	  if(_professorService.verificarSeExiste(professorD.getTelefone())){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("O numero de telefone ja existe");
		}
		
		if(_professorService.verificarSeExiste(professorD.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("O email ja existe");
		}*/
		
		ProfessorModel professorM = new ProfessorModel();
		BeanUtils.copyProperties(professorD, professorM);
		var salvo = _professorService.save(professorM);
		if(salvo != null){
			return ResponseEntity.status(HttpStatus.CREATED).body(_professorService.findById(professorM.getId()));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao Registar o professor");
		
	 }
	 
	 @GetMapping
	 public ResponseEntity<List<ProfessorModel>> listarProfessores(){
		 return ResponseEntity.status(HttpStatus.OK).body(_professorService.findAll());
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Object> umProfessor(@PathVariable(value="id") UUID id){
		 Optional<ProfessorModel> professorO = _professorService.findById(id);
		 if(professorO.isPresent()) {
			 return ResponseEntity.status(HttpStatus.OK).body(professorO.get());
		 }
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O professor nao existe!");
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteProfessor(@PathVariable(value = "id") UUID id){
		 Optional<ProfessorModel> professorO = _professorService.findById(id);
		 if(professorO.isPresent()) {
			 _professorService.delete(professorO.get());
			 return ResponseEntity.status(HttpStatus.OK).body("Registo apagado");
		 }
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O professor nao existe!");
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Object> atualizaProfessor(@PathVariable(value ="id") UUID id, @RequestBody @Valid ProfessorDTO professorD){
		 Optional<ProfessorModel> professorO = _professorService.findById(id);
		 if(professorO.isPresent()) {
			 ProfessorModel professorM = new ProfessorModel();
			 BeanUtils.copyProperties(professorD, professorM);
			 professorM.setId(professorO.get().getId());
			 return ResponseEntity.status(HttpStatus.OK).body(_professorService.save(professorM));
		 }
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O professor nao existe!");
	 }
 }
