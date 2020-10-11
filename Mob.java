import java.util.Random;
import java.lang.Math;

public class Mob {
    private String name;
    private int level;
    private long hp;
    private static long maxHp;
    private boolean isBoss;
    private long givenExp;
    private long givenGold;

    public Mob(String name, int level, boolean isBoss) {
        this.name = name;
        this.level = level;
        this.isBoss = isBoss;
        maxHp = setAdequateHp(level, isBoss);
        hp = maxHp;
        givenExp = setgivenExp(level, isBoss);
        givenGold = setgivenGold(level, isBoss);
    }

    public String getName() { return name; } 
    public int getLevel() { return level; } 
    public long getHp() { return hp; }
    public long getGivenExp() { return givenExp; }
    public long getGivenGold() { return givenGold; }

    public void setHp(long hp) { this.hp = hp; }
    public boolean beAttacked(long damage) { 
        setHp(getHp() - damage); 
        if (getHp() <= 0) {
            System.out.println("defeat the \"" + getName() + "\" !!");
            System.out.println("You've got \"" + getGivenExp() + "\" Exps !!");
            System.out.println("You've got \"" + getGivenGold() + "\" golds !!");
            return true;
        }
        return false;
    }

    public static long setAdequateHp(int level, boolean isBoss) {
        return (int) (Math.pow(1.05, (level + 70)) * (isBoss ? 10 : 1));
    }

    public static long setgivenExp(int level, boolean isBoss) {
        return Math.round(maxHp / (isBoss ? 20 : 7)) - 3;
    }

    public static long setgivenGold(int level, boolean isBoss) {
        Random rand = new Random();
        return level * (rand.nextInt(11) + 9) * (isBoss ? 4 : 1);
    }

    public void printMobInfo() {
        System.out.println("\n########## Mob Info ##########");
        System.out.println("\"" + getName() + "\" (Lv." + getLevel() + ")");
        System.out.println("Hp: " + getHp());
        System.out.println("##############################");
    }

    public long giveExp() { return givenExp; }
    public long giveGold() { return givenGold; }

}