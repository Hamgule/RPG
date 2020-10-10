public class Inventory {
    private Item item;
    private int amount;

    Inventory(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItems() { return item; }
    public int getAmount() { return amount; }
}