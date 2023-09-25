package com.api.Model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="aluno")
public class aluno implements Serializable {
   private static final long serial = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;
   @Column(nullable = false, length=50)
   private String nome;
   @Column(nullable= true, length = 50)
   private String email;
   @Column(nullable = true, length = 50)
   private String telefone;
   @ManyToOne
   @JoinColumn(name = "turma_id")
   private turmaModel turma_id;
   
public UUID getId() {
	return id;
}
public void setId(UUID id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public turmaModel getTurma_id() {
	return turma_id;
}
public void setTurma_id(turmaModel turma_id) {
	this.turma_id = turma_id;
}
public static long getSerial() {
	return serial;
}
    
}
