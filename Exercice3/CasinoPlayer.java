package Exercice3;

public class CasinoPlayer {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String pseudo;
    private String uuid;

    private double money;

    public CasinoPlayer(String firstname, String lastname, String email, String password, String pseudo, double money, String uuid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.pseudo = pseudo;
        this.money = money;
        this.uuid = uuid;
    }

    public void removeMoney(double money) {
        this.money -= money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public double getMoney() {
        return money;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public String getUuid() {
        return this.uuid;
    }
}
