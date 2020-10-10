import java.util.Random;

public class RandomBox {
    private int numberOfItem = 4;
    
    public RandomBox(Character user) {
        Random rand = new Random();
        int itemIndex = rand.nextInt(numberOfItem);
        String[] itemName = new String[numberOfItem];

        itemName[0] = "sword";
        itemName[1] = "bow";
        itemName[2] = "axe";
        itemName[3] = "arrow";

        Item gotchaItem = new Item(itemName[itemIndex], Main.itemCode);

        System.out.println("Gotcha Slot ...");
        System.out.println("You got a \"" + gotchaItem.getName() + "\"");
        gotchaItem.printItemInfo();
        user.getItems(gotchaItem);

        System.out.println("Wearing ...");
        user.wearItems(gotchaItem);
    }
}
