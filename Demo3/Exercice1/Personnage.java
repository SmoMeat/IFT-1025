package Demo3.Exercice1;

public abstract class Personnage {

    private String name;
    private String visualAlive;
    private String visualDead;
    private float hp;
    private boolean isAlive = true;

    public Personnage(String nom, String visualAlive, String visualDead, float hp) {
        this.name = nom;
        this.visualAlive = visualAlive;
        this.visualDead = visualDead;
        this.hp = hp;
    }

    public String getVisual() {
        return this.isAlive ? this.visualAlive : this.visualDead;
    }

    public void afficher() {
        System.out.println(this.getVisual());
    }

    public String getName() {
        return this.name;
    }

    public void damage(float amount) {
        this.hp -= amount;
    }

    public float getHp() {
        return this.hp;
    }

    public void attaquer(Personnage victim) {
        victim.damage(10);
        if (victim.getHp() <= 0) {
            victim.kill();
        }
    }

    public void kill() {
        this.hp = 0;
        this.isAlive = false;
    }

}
