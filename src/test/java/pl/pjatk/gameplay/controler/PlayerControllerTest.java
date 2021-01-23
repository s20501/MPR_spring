package pl.pjatk.gameplay.controler;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.service.PlayerService;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlayerControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerService playerService;

    @Test
    void shouldReturnEmptyList() throws  Exception{
        mockMvc.perform(get("/player/list")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void shouldMatchContentForHelloWorld() throws  Exception{
        mockMvc.perform(get("/player/hello")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(CoreMatchers.equalTo("Hello world")));
    }

    @Test
    void shouldReturnNotFound() throws  Exception{
        Player player = playerService.save(new Player("25",3,4, List.of()));
        mockMvc.perform(get("/player/1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(CoreMatchers.equalTo("{\"id\":1,\"nickname\":\"25\",\"health\":3,\"attack\":4}")));


    }
}
