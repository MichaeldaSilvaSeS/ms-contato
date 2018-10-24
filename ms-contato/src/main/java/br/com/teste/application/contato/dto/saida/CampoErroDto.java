package br.com.teste.application.contato.dto.saida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampoErroDto {

	private String campo;
	
	private String mensagem;
}
