import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int itemCode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Character c1 = new Character("Warrior");

        String tryOrNot;
        System.out.println("\nBeginner Package (Random Box)");
        System.out.print("Try ? (y/n)\n>> ");

        while (true) {
            tryOrNot = sc.nextLine();
            if (tryOrNot.equals("y")) { 
                RandomBox rb = new RandomBox(c1); 
                
                String wearOrNot;
                System.out.print("Wear ? (y/n)\n>> ");

                while (true) {
                    wearOrNot = sc.nextLine();
                    if (wearOrNot.equals("y"))  {
                        System.out.println("Wearing ...");
                        c1.wearItems(rb.getGotchaItem());
                    }
                    else if (wearOrNot.equals("n")) System.out.println("Denied.");
                    else {
                        System.out.print("Enter again\n>> ");
                        continue;
                    }
                    break;
                }
            }
            else if (tryOrNot.equals("n")) System.out.println("Denied.");
            else {
                System.out.print("Enter again\n>> ");
                continue;
            }
            break;
        }

        c1.printCharacterInfo();

        Mob m1 = new Mob("Slime", 3, false);
        m1.printMobInfo();

        System.out.print("Fight ? (y/n)\n>> ");

        String attackOrNot;

        while (true) {
            attackOrNot = sc.nextLine();
            if (attackOrNot.equals("y"));
            else if (attackOrNot.equals("n")) System.out.println("Don't give up..!");
            else {
                System.out.print("Enter again\n >> ");
                continue;
            }
            System.out.println("Let's Fight!");
            break;
        }

        String behave;

        while (true) {
            m1.printMobInfo();
            System.out.print("Attack(a) / Heal(h)\n>> ");
            behave = sc.nextLine();
            if (behave.equals("a")) {
                if (c1.attack(m1)) {
                    c1.gainExp(m1.giveExp());
                    c1.gainGolds(m1.giveGold());
                    break;
                }
            }
            else if (behave.equals("h")) {
                System.out.println("--Unimplemented--");
            }
        }
        
        c1.printCharacterInfo();

        sc.close();
    }
}
