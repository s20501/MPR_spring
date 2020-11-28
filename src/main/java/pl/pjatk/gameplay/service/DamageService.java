package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;


@Service
public class DamageService {


    public Player dealDamage(Player target,Player attacker ){
        target.setHealth(target.getHealth() - attacker.getAttack());
        return target;
    }

    public Player heal(Player player, int healValue){
        if(player.getHealth() + healValue > 100){
            return player;
        }
        player.setHealth(player.getHealth() + healValue);
        return  player;
    }

    public Player debuff(Player player, int debufValue){
        if(player.getAttack() - debufValue < 0){
            return player;
        }
        player.setAttack(player.getAttack() - debufValue);
        return  player;
    }

    public Player buff(Player player, int buffValue){
        player.setAttack(player.getAttack() + buffValue);
        return  player;
    }

    public Player removeBuff(Player player, int buffValue){
        player.setAttack(100);
        return  player;
    }
}
