package com.Model;

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
@Table(name="pauta")
public class pautaModel implements Serializable {
  
	private static final long serial = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@ManyToOne
	@JoinColumn(name ="aluno_id")
	private alunoModel aluno_id;
	@Column(nullable=false)
	private double primeiroTeste;
	@Column(nullable=false)
	private double segundoTeste;
	@Column(nullable=true)
	private double media;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public alunoModel getAluno_id() {
		return aluno_id;
	}
	public void setAluno_id(alunoModel aluno_id) {
		this.aluno_id = aluno_id;
	}
	public double getPrimeiroTeste() {
		return primeiroTeste;
	}
	public void setPrimeiroTeste(double primeiroTeste) {
		this.primeiroTeste = primeiroTeste;
	}
	public double getSegundoTeste() {
		return segundoTeste;
	}
	public void setSegundoTeste(double segundoTeste) {
		this.segundoTeste = segundoTeste;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public static long getSerial() {
		return serial;
	}
	
	public double CalcularMedia() {
		return (primeiroTeste + segundoTeste) / 2;
	}
	
	
}
