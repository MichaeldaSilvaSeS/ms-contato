package br.com.teste.application.contato;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.teste.application.repository.ContatoEntity;

@DataJpaTest(showSql=true)
@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.profiles.active=test"})
public class ContatoJpaUnitTest {
	
	@Autowired
	private EntityManager em;

	@Test
	@SuppressWarnings("unchecked")
	public void listarTest() {
		List<ContatoEntity> result = ((List<ContatoEntity>)em.createNativeQuery("select id, nome from tbl_contato", ContatoEntity.class).getResultList());
		assertEquals(2, result.size());
	}
}
