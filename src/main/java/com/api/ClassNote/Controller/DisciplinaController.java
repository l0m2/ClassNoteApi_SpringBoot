package com.api.ClassNote.Controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	 
}
