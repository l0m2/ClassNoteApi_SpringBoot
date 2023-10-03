package com.api.ClassNote.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ClassNote.DTOs.TurmaDTO;
import com.api.ClassNote.Model.TurmaModel;
import com.api.ClassNote.Services.TurmaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/turma")
public class TurmaController {
   
	 @Autowired
	 TurmaService turmaService;
	 public TurmaController() {
		 
	 }
	 
	 @PostMapping
	 public ResponseEntity<Object> salvaTurma(@RequestBody @Valid TurmaDTO turmaD){
		TurmaModel turmaM =  new TurmaModel();
		BeanUtils.copyProperties(turmaD, turmaM);
		var salvo = turmaService.save(turmaM);
		if(salvo != null) {
		return ResponseEntity.status(HttpStatus.OK).body(turmaM);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro no cadastro da turma");
	 }
}
