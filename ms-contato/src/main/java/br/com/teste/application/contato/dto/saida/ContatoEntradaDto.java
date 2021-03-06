package br.com.teste.application.contato.dto.saida;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEntradaDto {
	
	@JsonProperty(value="nome")
	@NotNull
	private String nome;
	
	public void nomeCompleto(String nome, String sobrenome) {
		this.nome = nome.trim() + " " + sobrenome.trim();
	}

}
