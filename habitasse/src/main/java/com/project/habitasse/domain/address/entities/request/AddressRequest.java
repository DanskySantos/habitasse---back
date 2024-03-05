package com.project.habitasse.domain.address.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

	private Integer id;
	private String nome;
	private LocalDateTime dataNascimento;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
}
