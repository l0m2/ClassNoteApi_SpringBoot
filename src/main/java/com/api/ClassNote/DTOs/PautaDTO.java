package com.api.ClassNote.DTOs;

import com.api.ClassNote.Model.*;
import jakarta.validation.constraints.NotNull;

public class PautaDTO {
	@NotNull
	private AlunoModel aluno_id;
    @NotNull
	private double primeiroTeste;
	@NotNull
	private double segundoTeste;
	
	public AlunoModel getAluno_id() {
		return aluno_id;
	}
	public void setAluno_id(AlunoModel aluno_id) {
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
