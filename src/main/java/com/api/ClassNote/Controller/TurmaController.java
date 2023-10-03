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
	 
	 static Optional<TurmaModel> turmaO ;
	 static TurmaModel turmaM =  new TurmaModel();
	 
	 public TurmaController() {
		 
	 }
	 
	 @PostMapping
	 public ResponseEntity<Object> salvaTurma(@RequestBody @Valid TurmaDTO turmaD){
		BeanUtils.copyProperties(turmaD, turmaM);
		var salvo = turmaService.save(turmaM);
		if(salvo != null) {
		return ResponseEntity.status(HttpStatus.OK).body(turmaM);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro no cadastro da turma");
	 }
	 
	 @GetMapping
	 public ResponseEntity<List<TurmaModel>> listarTurmas(){
		 return ResponseEntity.status(HttpStatus.OK).body(turmaService.findAll());
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Object> umaTurma(@PathVariable (value = "id") UUID id){
		 turmaO = turmaService.findById(id);
		 if(turmaO.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(turmaO.get()); 
		 }
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id da turma fornecido nao existe");
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> deleteTurma(@PathVariable (value = "id") UUID id){
		 turmaO = turmaService.findById(id);
		 if(turmaO.isPresent()) {
			turmaService.delete(turmaO.get());
			return ResponseEntity.status(HttpStatus.OK).body("A turma foi apagada com sucesso");
		 }
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("o id da turma fornecido nao existe");
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Object> atualizaTurma(@PathVariable (value= "id") UUID id, @RequestBody @Valid TurmaDTO turmaD){
	     turmaO = turmaService.findById(id);
	     if(turmaO.isPresent()) {
	    	BeanUtils.copyProperties(turmaD, turmaM);
	    	turmaM.setId(id);
	    	var salvo = turmaService.save(turmaM);
	    	if(salvo != null) {
	    	return ResponseEntity.status(HttpStatus.OK).body(turmaM);
	    	}
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na atualizacao");
	     }
	     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id da turma fornecido nao existe!");
	 }
}
