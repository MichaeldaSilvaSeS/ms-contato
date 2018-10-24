package br.com.teste.application.contato.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.application.contato.dto.saida.ContatoEntradaDto;
import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.contato.dto.saida.ContatosSaidaDto;
import br.com.teste.application.contato.service.AgendaService;

@RestController
public class ContatoController {
	private static final String URL_CONTROLLER = "/v1/agenda";
	
	@Autowired
	private AgendaService service;
	
	@GetMapping(path=URL_CONTROLLER+"/contatos",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ContatosSaidaDto contatosGet() {
		ContatoSaidaDto contato = new ContatoSaidaDto();
		contato.setNome("Michael da Silva");
		
		ContatosSaidaDto saida = new ContatosSaidaDto();
		saida.add(contato);
		
		saida.add(service.listar());		
		return saida;
	}
	
	//@RequestMapping(path=URL_CONTROLLER+"/contatos",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping(path=URL_CONTROLLER+"/contatos",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void contatosPost(@Valid @RequestBody ContatoEntradaDto contatoEntradaDto) {
		
	}

}
