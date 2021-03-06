package br.com.teste.application.contato.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.application.contato.dto.saida.ContatoEntradaDto;
import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.contato.dto.saida.ContatosSaidaDto;
import br.com.teste.application.contato.service.AgendaService;
import br.com.teste.application.feign.BikeAPIClient;

@RestController
public class ContatoController {
	private static final String URL_CONTROLLER = "/v1/agenda";
	
	@Autowired
	private AgendaService service;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private BikeAPIClient phoneAPIClient;
	
	@GetMapping(path=URL_CONTROLLER+"/contatos",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ContatosSaidaDto contatosGet() {
		String resposta = phoneAPIClient.getBikes("norisbike-nurnberg");
		
		ContatoSaidaDto contato = new ContatoSaidaDto();
		contato.setNome(messageSource.getMessage("ms.nome", null, LocaleContextHolder.getLocale()));
		
		if( resposta.isEmpty() )
			contato.setNome("Vazio - " + contato.getNome());
		else
			contato.setNome("Cheio - " + contato.getNome());
		
		ContatosSaidaDto saida = new ContatosSaidaDto();
		saida.add(contato);
		
		saida.add(service.listar(resposta.isEmpty()));
		return saida;
	}
	
	@PostMapping(path=URL_CONTROLLER+"/contatos",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void contatosPost(@Valid @RequestBody ContatoEntradaDto contatoEntradaDto) {
		
	}

}
