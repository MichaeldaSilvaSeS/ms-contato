package br.com.teste.application.contato;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.teste.application.Application;
import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.contato.service.AgendaService;

@Profile("local")
@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.profiles.active=local" }, classes = Application.class)
//@WebMvcTest({ContatoController.class})
public class ContatoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AgendaService agendaService;
    
    @Test
    public void simpleResult() throws Exception {
        Mockito.when(agendaService.listar())
                .thenReturn(Collections.<ContatoSaidaDto>emptyList());

        this.mockMvc.perform(get("/v1/agenda/contatos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
