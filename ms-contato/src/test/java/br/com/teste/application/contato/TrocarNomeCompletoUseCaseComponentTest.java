package br.com.teste.application.contato;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.contato.service.AgendaService;
import br.com.teste.application.contato.usecase.TrocarNomeCompletoUseCase;

@RunWith(MockitoJUnitRunner.class)
public class TrocarNomeCompletoUseCaseComponentTest {

	@InjectMocks
	private TrocarNomeCompletoUseCase trocarNomeCompletoUseCase;

	@Mock
	private AgendaService agendaService;
	
	@Test
	public void trocarNome() {
		List<ContatoSaidaDto> listaMock = new ArrayList<>();
		
		ContatoSaidaDto contato = new ContatoSaidaDto();
		contato.setNome("Michael Jackson");
		listaMock.add(contato);
		
		when(agendaService.listar()).thenReturn(listaMock);
				
		List<ContatoSaidaDto> lista = trocarNomeCompletoUseCase.trocarNome();		
		assertEquals(1, lista.size());
		verify(agendaService).listar();
	}
}
