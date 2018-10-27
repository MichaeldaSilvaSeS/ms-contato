package br.com.teste.application.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;

@Component
public class ContatoFakeRepository {
	
	@Autowired
	private ContatoRepository contatoRepository;

	public List<ContatoSaidaDto> listar() {		
		return contatoRepository
				.findAll()
					.stream()
						.map(e -> {
							return ContatoSaidaDto
									.builder()
										.nome(e.getNome())
									.build();
							})
						.collect(Collectors.toList());
	}
}
