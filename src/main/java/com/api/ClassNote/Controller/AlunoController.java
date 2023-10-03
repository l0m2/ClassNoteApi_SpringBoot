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
	static AlunoModel alunoM =  new AlunoModel();
	static Optional<TurmaModel> turmaO;
	
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
}
