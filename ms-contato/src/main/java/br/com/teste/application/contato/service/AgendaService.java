package br.com.teste.application.contato.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.repository.ContatoFakeRepository;

@Service
public class AgendaService {

	@Autowired
	private ContatoFakeRepository fakeRepository;
	
	@HystrixCommand(commandKey="listar",fallbackMethod="listarFallback")
	public List<ContatoSaidaDto> listar(boolean ex){
		if(ex)
			throw new RuntimeException();
		return fakeRepository.listar();
	}
	
	public List<ContatoSaidaDto> listarFallback(boolean ex) {
		return Collections.<ContatoSaidaDto>emptyList();
	}
}
