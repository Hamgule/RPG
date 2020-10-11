import java.util.Random;
import java.lang.Math;

public class Character {
    private static long level1Exp = 10;

    private String nickname;

    // level relevant
    private int level;
    private long exp;
    private double expRate;

    // force relevant
    private double force;
    private double minDamage;
    private double maxDamage;

    // hp/mp relevant
    private long hp;
    private long mp;

    // inventory relevant
    private int inventorySize;
    private int numOfItemGot;
    private Inventory[] inven;
    private long gold;

    private Item equipmentWeapon;

    public Character(String name) {
        nickname = name;
        
        // level relevant
        level = 1;
        exp = 0;
        expRate = 0.0;

        // force relevant
        force = 40.0;
        setMaxDamage();
        setMinDamage();
        
        // inventory relevant
        inventorySize = 10;
        numOfItemGot = 0;
        gold = 0;
        inven = new Inventory[inventorySize];
    }

    // getter
    public String getNickName() { return nickname; }
    
    public void printCharacterInfo() {
        System.out.println("\n********* Character Info *********");
        System.out.println("\"" + getNickName() + "\" (Lv." + getLevel() + ")");
        System.out.println("Exp: " + getExp() + String.format("(%.2f%%)", getExpRate() * 100));
        System.out.println("Force: " + Math.round(getForce()));
        System.out.println("Damage Range: " + Math.round(getMinDamage()) + " ~ " + Math.round(getMaxDamage()));
        System.out.println("Golds: " + getGold());
        System.out.println("***********************************");
    }

    // level relevant
    public int getLevel() { return level; }
    public long getExp() { return exp; }
    public double getExpRate() { return expRate; }

    // force relevant
    public double getForce() { return force; }
    public double getMinDamage() { return minDamage; }
    public double getMaxDamage() { return maxDamage; }

    // inventory relevant
    public long getGold() { return gold; }

    // setter

    // level relevant
    public static long expCalculator(int level) {
        long exp = level1Exp;
        long differenceExp = 0;

        for (int i = 1; i < level; i++) {
            if (i % 10 == 9) differenceExp = (int) (i / 10) + 4;
            else differenceExp = (int) (i / 10) + 1;
            exp += differenceExp;
        }
        return exp;
    }
    public void setExpRate() { this.expRate = 1.0 * getExp() / expCalculator(this.level); }

    public static long accumulateExpCalculator(int level) {
        long accumulateExp = 0;
        for (int i = 1; i <= level; i++) accumulateExp += expCalculator(i);
        return accumulateExp;
    }

    public void gainExp(long exp) { 
        this.exp += exp; 
        setExpRate();
    }
    public void loseOutExp(long exp) { 
        this.exp -= exp; 
        if (this.exp < 0) this.exp = 0;
        setExpRate();
    }


    // force relevant
    public void addForce(double force) { 
        this.force += force; 
        setMinDamage();
        setMaxDamage();
    }
    public void setMinDamage() {
        minDamage = 0.7 * getMaxDamage();
    }
    public void setMaxDamage() {
        maxDamage = force * 0.1;
    }
    
    // hp/mp relevant
    public static setAdequateHp()

    // inventory relevant
    public void printInventory() {
        System.out.println("\n******** Inventory ********");
        for (int i = 0; i < numOfItemGot; i++) {
            System.out.println((i + 1) + " : " + inven[i].getItem().getName());
        }
        System.out.println("***************************");
    }

    public void gainItems(Item item) {
        if (numOfItemGot >= 10) {
            System.out.println("No more Items!");
            return;
        }
        inven[numOfItemGot] = new Inventory(item, 1);
        numOfItemGot++;
    }
    
    public void wearItems(Item item) {
        if (item.getWearable()) {
            equipmentWeapon = item;
            addForce(equipmentWeapon.getPower());
        }
        else System.out.println("Cannot equip this item!");
    }

    public void gainGolds(long gold) {
        this.gold += gold;
    }
    public void loseOutGolds(long gold) {
        if (this.gold < gold) System.out.println("Not enough golds!");
        else this.gold -= gold;
    }

    // combat relevant
    public boolean attack(Mob monster) {
        Random rand = new Random();
        int damage;
        damage = (int) (rand.nextDouble() * (getMaxDamage() - getMinDamage()) + getMinDamage());
        System.out.println("Attack! -" + damage);
        return monster.beAttacked(damage);
    }

    


}
