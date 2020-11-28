package pl.pjatk.gameplay.service;

import org.junit.jupiter.api.Test;
import pl.pjatk.gameplay.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class DamageServiceTest {

    private DamageService damageService = new DamageService();

    @Test
    void shouldHealPlayer() {
        Player player = new Player("nickname", 95, 10);
        damageService.heal(player, 5);

        assertThat(player.getHealth()).isEqualTo(100);

    }

    @Test
    void shouldNotHealPlayer() {
        Player player = new Player("nickname", 95, 10);

        damageService.heal(player, 1000);
        assertThat(player.getHealth()).isEqualTo(95);

    }

    @Test
    void shouldDebuffPlayer() {
        Player player = new Player("nickname", 100, 10);
        damageService.debuff(player, 5);

        assertThat(player.getAttack()).isEqualTo(5);


    }

    @Test
    void shouldNotDebuffPlayer() {
        Player player = new Player("nickname", 100, 10);

        damageService.debuff(player, 1000);

        assertThat(player.getAttack()).isEqualTo(10);

    }

    @Test
    void shouldBuffPlayer() {
        Player player = new Player("nickname", 100, 10);
        damageService.buff(player, 5);

        assertThat(player.getAttack()).isEqualTo(15);
    }

    @Test
    void shouldRemoveBuffFromPlayer() {

        Player player = new Player("nickname", 100, 150);
        damageService.removeBuff(player);

        assertThat(player.getAttack()).isEqualTo(100);

    }
}
