package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;


@Service
public class DamageService {


    public Player deal(Player target,Player attacker ){
        target.setHealth(target.getHealth() - attacker.getAttack());
        return target;
    }
}
