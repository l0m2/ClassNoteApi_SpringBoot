package com.api.ClassNote.DTOs;

import java.util.UUID;

import com.api.ClassNote.Model.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlunoDTO {
	  @NotBlank
	  @Size(min=2)
	  private String nome;
	  @Email
	   private String email;
	   @NotBlank
	   private String telefone;
	   @NotNull
	   private UUID turma_id;
	   
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
	public UUID getTurma_id() {
		return turma_id;
	}
	public void setTurma_id(UUID turma_id) {
		this.turma_id = turma_id;
	}
	   
}
