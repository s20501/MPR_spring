package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    private DamageService damageService;

    public PlayerService(PlayerRepository playerRepository, DamageService damageService) {
        this.playerRepository = playerRepository;
        this.damageService = damageService;

    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id) {

        return playerRepository.findById(id);
    }


    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    public Player update(Player player) {
        if (playerRepository.findById(player.getId()).isEmpty()) {
            throw new RuntimeException();
        } else {
            return playerRepository.save(player);
        }

    }

    public Player attack(Long targetId, Long attackerId) {

        Optional<Player> getTarget = playerRepository.findById(targetId);
        Optional<Player> getAttacker = playerRepository.findById(attackerId);


        if (getTarget.isEmpty() || getAttacker.isEmpty()) {
            throw new RuntimeException();
        }

        Player target = getTarget.get();
        Player attacker = getAttacker.get();

        damageService.dealDamage(target, attacker);
        return playerRepository.save(target);
    }

    public void deleteAll(){
        playerRepository.deleteAll();
    }
}
