package com.api.ClassNote.Model;

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
import com.api.ClassNote.Model.*;

@Entity
@Table(name="aluno")
public class AlunoModel implements Serializable{
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
	   @JoinColumn(name = "turma")
	   private TurmaModel turma;
	   
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
	public TurmaModel getTurma() {
		return turma;
	}
	public void setTurma_id(TurmaModel turma) {
		this.turma = turma;
	}
	public static long getSerial() {
		return serial;
	}
	   
}
