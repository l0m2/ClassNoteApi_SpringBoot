package com.api.ClassNote.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	public ProfessorController(ProfessorService professor) {
		_professorService = professor;
	}
	
	 @PostMapping
	 public ResponseEntity<Object> salvaProfessor(@RequestBody @Valid ProfessorDTO professorD){
		 
	  if(_professorService.equals(professorD.getTelefone())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("O numero de telefone ja existe");
		}
		
		if(_professorService.equals(professorD.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("O email ja existe");
		}
		
		ProfessorModel professorM = new ProfessorModel();
		BeanUtils.copyProperties(professorD, professorM);
		var salvo = _professorService.save(professorM);
		if(salvo != null){
			return ResponseEntity.status(HttpStatus.CREATED).body(_professorService.findById(professorM.getId()));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao Registar o professor");
		
	 }
}
