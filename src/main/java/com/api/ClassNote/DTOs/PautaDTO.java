package com.api.ClassNote.DTOs;

import java.util.UUID;

import com.api.ClassNote.Model.*;
import jakarta.validation.constraints.NotNull;

public class PautaDTO {
	@NotNull
	private UUID aluno_id;
    @NotNull
	private double primeiroTeste;
	@NotNull
	private double segundoTeste;
	
	public UUID getAluno_id() {
		return aluno_id;
	}
	public void setAluno_id(UUID aluno_id) {
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
	
}
