package com.api.Model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class turmaModel implements Serializable {
  private static final long serial = 1L;
  
  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @Column(nullable = false, length = 40)
  private String nome;
  @Column(nullable = true)
  private int ano;
  @Column(nullable = true)
  private String semestre;
  
  
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
public int getAno() {
	return ano;
}
public void setAno(int ano) {
	this.ano = ano;
}
public String getSemestre() {
	return semestre;
}
public void setSemestre(String semestre) {
	this.semestre = semestre;
}
public static long getSerial() {
	return serial;
}
  
  
  
}
