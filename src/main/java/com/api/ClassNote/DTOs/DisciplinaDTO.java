package com.api.ClassNote.DTOs;

import java.util.UUID;

import com.api.ClassNote.Model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DisciplinaDTO {
	   @NotBlank
	   @Size(min=2)
	   private String nome;
	   @NotBlank
	   private String descricao;
	   @NotNull
	   private UUID professor_id;
	   
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
	public UUID getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(UUID professor_id) {
		this.professor_id = professor_id;
	}
}
