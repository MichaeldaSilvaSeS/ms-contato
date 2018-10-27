package br.com.teste.application.contato.dto.saida;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ContatosSaidaDto {

	@JsonProperty("contatos")
	private List<ContatoSaidaDto> contatos;
	
	public ContatosSaidaDto() {
		contatos = new ArrayList<>();
	}
	
	public void add(ContatoSaidaDto contato){
		contatos.add(contato);
	}
	
	public void add(List<ContatoSaidaDto> contatos){
		this.contatos.addAll(contatos);
	}
}
