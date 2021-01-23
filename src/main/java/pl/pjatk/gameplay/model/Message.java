package pl.pjatk.gameplay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @JoinColumn(name="player_id")
    @ManyToOne
    @JsonIgnore
    private Player player;

    public Message(String content, Player player) {
        this.content = content;
        this.player = player;
    }

    public Long getId() {
        return id;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Message(Long id, String content, Player player) {
        this.id = id;
        this.content = content;
        this.player = player;
    }
}
