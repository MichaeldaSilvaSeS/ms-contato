package br.com.teste.application.contato.dto.saida;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErroSaidaDto {
	
	private int codigoDoErro;
	
	private String mensagem;
	
	private List<CampoErroDto> campoErroDto;

}
