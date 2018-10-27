package br.com.teste.application.contato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.repository.ContatoFakeRepository;

@Service
public class AgendaService {

	@Autowired
	private ContatoFakeRepository fakeRepository;
	
	public List<ContatoSaidaDto> listar(){
		return fakeRepository.listar();
	}
}
