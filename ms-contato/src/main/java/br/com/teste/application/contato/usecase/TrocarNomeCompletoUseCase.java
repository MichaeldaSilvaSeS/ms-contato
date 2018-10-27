package br.com.teste.application.contato.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.contato.service.AgendaService;

@Component
public class TrocarNomeCompletoUseCase {

	@Autowired
	private AgendaService agendaService;

	public List<ContatoSaidaDto> trocarNome() {
		List<ContatoSaidaDto> listar = agendaService.listar();

		listar
			.stream()
				.forEach(i -> i.inverter());

		return listar;
	}
}
