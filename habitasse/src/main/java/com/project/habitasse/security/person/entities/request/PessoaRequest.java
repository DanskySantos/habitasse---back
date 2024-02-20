package com.project.habitasse.security.person.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaRequest {

	private Long id;
	private String nome;
	private LocalDateTime dataNascimento;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
}
