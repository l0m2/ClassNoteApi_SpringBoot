package com.api.ClassNote.Model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "professor")
public class ProfessorModel implements Serializable{
	
	// ajuda a garantir que objetos sejam desserializados corretamente mesmo se a classe evoluir.  
		private static final long serial = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private UUID id;
		@Column(nullable = false, length =50)
		private String nome;
		@Column(nullable = false, unique = true, length =50)
		private String email;
		@Column(nullable = false, unique = true, length = 13)
		private String telefone;
		
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
		public static long getSerial() {
			return serial;
		}
}
