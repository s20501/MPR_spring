package pl.pjatk.gameplay.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private int health;
    private int attack;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "player")
    private List<Message> messageList = new ArrayList<>();

    public Player( String nickname, int health, int attack, List<Message> messageList) {
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.messageList = messageList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }


    public Player(String nickname, int health, int attack) {
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;

    }

    public int getAttack() {
        return attack;
    }

    public Player() {

    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                '}';
    }
}
