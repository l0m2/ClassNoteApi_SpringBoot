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
@Table(name="disciplina")
public class DisciplinaModel implements Serializable {
   private static final long serial = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;
   @Column(nullable=false, length=70)
   private String nome;
   @Column(nullable=true)
   private String descricao;
   @ManyToOne
   @JoinColumn(name ="professor")
   private ProfessorModel professor_id;
   
   
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
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public ProfessorModel getProfessor_id() {
	return professor_id;
}
public void setProfessor_id(ProfessorModel professor_id) {
	this.professor_id = professor_id;
}
public static long getSerial() {
	return serial;
}
   
   
      
}
