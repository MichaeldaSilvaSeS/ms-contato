package br.com.teste.application.contato.dto.saida;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ContatoSaidaDto {

	@JsonProperty(value="nome")
	private String nome;
}
