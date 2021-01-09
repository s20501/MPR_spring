package pl.pjatk.gameplay.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.gameplay.model.Player;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PlayerServiceTestIT {

    @Autowired
    private PlayerService playerService;

    @BeforeEach
    void cleanUp(){
        playerService.deleteAll();
    }

    @Test
    void shouldNotFindAnyone(){
        List<Player> all = playerService.findAll();
        Assertions.assertThat(all).isEmpty();
    }

    @Test
    void shouldFindAllPlayers(){
        playerService.save(new Player("25",3,4));
        List<Player> all = playerService.findAll();
        Assertions.assertThat(all).isNotEmpty();
    }

    @Test
    void shouldSavePlayer(){
       Player player = playerService.save(new Player("25",3,4));
        Assertions.assertThat(player.getId()).isPositive();

    }

    @Test
    void shouldFindById(){
        Player player = playerService.save(new Player("25",3,4));
        Assertions.assertThat(playerService.findById(player.getId())).isNotEmpty();

    }

    @Test
    void shouldAttackPlayer(){
        Player attacker = playerService.save(new Player("25",24,4));
        Player target = playerService.save(new Player("25",24,4));

        playerService.attack(target.getId(), attacker.getId());

        Optional<Player>  updatedPlayer = playerService.findById(target.getId());

        Assertions.assertThat(updatedPlayer.get().getHealth()).isEqualTo(20);


    }


}
