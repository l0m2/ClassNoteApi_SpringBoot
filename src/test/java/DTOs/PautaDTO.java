package DTOs;

import com.Model.alunoModel;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class PautaDTO {

	@NotNull
	private alunoModel aluno_id;
    @NotNull
	private double primeiroTeste;
	@NotNull
	private double segundoTeste;
	
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
	

	

}
