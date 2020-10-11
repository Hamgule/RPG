import java.util.Random;
import java.util.Scanner;

public class RandomBox {
    private int numberOfItem = 4;
    private Item gotchaItem;

    public RandomBox(Character c) {
        Random rand = new Random();
        int itemIndex = rand.nextInt(numberOfItem);

        String[][] itemInfo = new String[numberOfItem][numberOfItem];

        itemInfo[0][0] = "sword";
        itemInfo[1][0] = "bow";
        itemInfo[2][0] = "axe";
        itemInfo[3][0] = "arrow";
        itemInfo[0][1] = "weapon";
        itemInfo[1][1] = "weapon";
        itemInfo[2][1] = "weapon";
        itemInfo[3][1] = "consumable";

        gotchaItem = new Item(itemInfo[itemIndex][0], itemInfo[itemIndex][1], Main.itemCode);

        System.out.println("\n[Gotcha Slot ...]");
        System.out.println("You got a \"" + gotchaItem.getName() + "\"");
        gotchaItem.printItemInfo();
        c.gainItems(gotchaItem);
        c.printInventory();
    }

    public Item getGotchaItem() { return gotchaItem; }
}
