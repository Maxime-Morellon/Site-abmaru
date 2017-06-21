package friendsofmine;

import friendsofmine.controllers.ActiviteController;
import friendsofmine.service.InitialisationService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ActiviteController.class)
public class ActiviteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Bootstrap bootstrap;

    @Test
    public void testGetActivites() throws Exception{
        when(bootstrap.getInitialisationService()).thenReturn(new InitialisationService());
        mockMvc.perform(get("/activites"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("activites"))
                .andExpect(content().string(Matchers.containsString("<h2>Liste des Activités</h2>")))
                .andDo(print());
    }
}

