package br.com.teste.application.contato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.contato.dto.saida.ContatosSaidaDto;
import br.com.teste.application.contato.service.AgendaService;

@RestController
public class ContatoController {
	private static final String URL_CONTROLLER = "/v1/agenda";
	
	@Autowired
	private AgendaService service;
	
	@RequestMapping(path=URL_CONTROLLER+"/contatos",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@GetMapping
	public ContatosSaidaDto home() {
		ContatoSaidaDto contato = new ContatoSaidaDto();
		contato.setNome("Michael da Silva");
		
		ContatosSaidaDto saida = new ContatosSaidaDto();
		saida.add(contato);
		
		saida.add(service.listar());		
		return saida;
	}

}
