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
	
}
