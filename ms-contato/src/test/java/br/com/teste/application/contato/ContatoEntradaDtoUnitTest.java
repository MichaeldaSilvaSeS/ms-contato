package br.com.teste.application.contato;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.teste.application.contato.dto.saida.ContatoEntradaDto;

@RunWith(JUnit4.class)
public class ContatoEntradaDtoUnitTest {
	
	private ContatoEntradaDto contatoEntradaDto;
	
	@Before
	public void setUpClass() {
		contatoEntradaDto = ContatoEntradaDto.builder().build();
	}

	@Test
	public void nomeSobrenomeTest() {
		contatoEntradaDto.nomeCompleto("Michael", "Silva");
		
		assertNotNull(contatoEntradaDto.getNome());
	}
}
