import java.util.Random;

public class Main {
    public static int itemCode;
    public static void main(String[] args) {
        Character user1 = new Character("Warrior");

        RandomBox rb = new RandomBox(user1);

        user1.printInventory();

        System.out.println("Name: " + user1.getNickName());
        System.out.println("Force: " + (int) user1.getForce());
        System.out.println("Damage Range: " + (int) user1.getMinDamage() + " ~ " + (int) user1.getMaxDamage());

        user1.attack();
        user1.attack();
        user1.attack();
        user1.attack();
        user1.attack();
        user1.attack();
        user1.attack();
    }
}
