import java.util.Random;

public class Character {
    private String nickname;
    private double force;
    private double minDamage;
    private double maxDamage;

    private int inventorySize;
    private int numOfItemGot;
    private Inventory[] inven;

    private Item equipmentWeapon;

    public Character(String name) {
        nickname = name;
        force = 100.0;
        setMaxDamage();
        setMinDamage();
        
        inventorySize = 10;
        numOfItemGot = 0;

        inven = new Inventory[inventorySize];
    }

    // getter
    public String getNickName() { return nickname; }
    public double getForce() { return force; }
    public double getMinDamage() { return minDamage; }
    public double getMaxDamage() { return maxDamage; }

    // setter

    // Damage
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

    // Inventory
    public void printInventory() {
        System.out.println("******** Inventory ********");
        for (int i = 0; i < numOfItemGot; i++) {
            System.out.println((i + 1) + " : " + inven[i].getItems().getName());
        }
        System.out.println("***************************");
    }

    public void getItems(Item item) {
        if (numOfItemGot >= 10) {
            System.out.println("No more Items!");
            return;
        }
        inven[numOfItemGot] = new Inventory(item, 1);
        numOfItemGot++;
    }
    
    public void wearItems(Item item) {
        equipmentWeapon = item;
        addForce(equipmentWeapon.getPower());
    }

    public void attack() {
        Random rand = new Random();
        int damage;
        damage = (int) (rand.nextDouble() * (getMaxDamage() - getMinDamage()) + getMinDamage());
        System.out.println("Attack! -" + damage);
    }
}
