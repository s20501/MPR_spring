package pl.pjatk.gameplay.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.service.PlayerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;

    }

    @GetMapping("/list")
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> findById(@PathVariable Long id) {

        Optional<Player> optionalPlayer = playerService.findById((id));


        if (optionalPlayer.isPresent()) {
            return ResponseEntity.ok(optionalPlayer.get());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helo() {
        return ResponseEntity.ok("Hello world");
    }

    @PostMapping("/add")
    public ResponseEntity<Player> save(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.save(player));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        playerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Player> update(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.update(player));

    }

    @PostMapping("/attack")
    public ResponseEntity<Player> attack(@RequestBody Long targetId, Long attackerId) {
        return ResponseEntity.ok(playerService.attack(targetId, attackerId));
    }
}
