package br.com.teste.application.contato.dto.saida;

import org.bouncycastle.util.Arrays;

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
	
	public void inverter() {
		this.nome = new String(Arrays.reverse(this.nome.getBytes()));
	}
}
