package br.com.teste.application.contato;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.contato.usecase.TrocarNomeCompletoUseCase;
import br.com.teste.application.repository.ContatoFakeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrocarNomeCompletoUseCaseIntegrationTest {

	@Autowired
	private TrocarNomeCompletoUseCase trocarNomeCompletoUseCase;
	
	@MockBean
	private ContatoFakeRepository fakeRepository;
	
	@Test
	public void trocarNome() {
		List<ContatoSaidaDto> listaMock = new ArrayList<>();
		
		ContatoSaidaDto contato = new ContatoSaidaDto();
		contato.setNome("Michael Jackson");
		listaMock.add(contato);
		
		when(fakeRepository.listar()).thenReturn(listaMock);
		
		List<ContatoSaidaDto> lista = trocarNomeCompletoUseCase.trocarNome();
		assertEquals(1, lista.size());
	}
	
}
