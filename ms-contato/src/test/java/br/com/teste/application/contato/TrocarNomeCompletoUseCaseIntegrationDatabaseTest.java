package br.com.teste.application.contato;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.DirtiesContext.HierarchyMode;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.teste.application.contato.controller.ContatoController;
import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.contato.dto.saida.ContatosSaidaDto;

@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.profiles.active=test"})
@DirtiesContext(classMode=ClassMode.AFTER_CLASS,hierarchyMode=HierarchyMode.EXHAUSTIVE,methodMode=MethodMode.AFTER_METHOD)
public class TrocarNomeCompletoUseCaseIntegrationDatabaseTest {

	@Autowired
	private ContatoController contatoController;
	
	@Test
	public void listarAgenda() {
		ContatosSaidaDto contatosGet = contatoController.contatosGet();
		List<ContatoSaidaDto> contatos = contatosGet.getContatos();
		
		assertNotNull(contatos);
		assertEquals(3,contatos.size());
	}
	
}
