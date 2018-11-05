package br.com.teste.application.contato;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.teste.application.contato.controller.ContatoController;
import br.com.teste.application.contato.dto.saida.ContatoSaidaDto;
import br.com.teste.application.contato.service.AgendaService;

@ActiveProfiles(value= {"local"})
@RunWith(SpringRunner.class)
@WebMvcTest(useDefaultFilters=true,secure=false,controllers= {ContatoController.class})
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
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
    }
}
