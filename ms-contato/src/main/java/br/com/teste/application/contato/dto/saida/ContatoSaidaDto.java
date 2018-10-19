package br.com.teste.application.contato.dto.saida;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContatoSaidaDto {

	@JsonProperty(value="nome")
	private String nome;
}
