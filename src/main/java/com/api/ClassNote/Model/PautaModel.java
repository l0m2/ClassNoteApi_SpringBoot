package com.api.ClassNote.Model;

import java.io.Serializable;
import java.util.UUID;
import com.api.ClassNote.Model.*;
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
public class PautaModel implements Serializable {
  
	private static final long serial = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@ManyToOne
	@JoinColumn(name ="aluno")
	private AlunoModel aluno;
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
	public AlunoModel getAluno() {
		return aluno;
	}
	public void setAluno(AlunoModel aluno) {
		this.aluno = aluno;
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
