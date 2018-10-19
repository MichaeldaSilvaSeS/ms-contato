package br.com.teste.application.contato.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;

@Service
public class AgendaService {

	public List<ContatoSaidaDto> listar(){
		List<ContatoSaidaDto> lista = new ArrayList<>();
		
		ContatoSaidaDto contato = new ContatoSaidaDto();
		contato.setNome("Michael da Silva");
		lista.add(contato);
		
		ContatoSaidaDto contato1 = new ContatoSaidaDto();
		contato1.setNome("Michael da Silva");
		lista.add(contato1);
		
		return lista;
	}
}
