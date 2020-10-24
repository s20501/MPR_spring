package pl.pjatk.gameplay.model;

public class Player {
    private int id;
    private String nickname;
    private int health;
    private int attack;

    public Player(int id, String nickname, int health, int attack) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
