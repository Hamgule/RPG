import java.util.Random;

public class Item {
    private String name;
    private int code;
    private double power;
    private double fixedPower;
    private double additionalPower;
    private boolean isWorn;
    private String type;
    private boolean wearable;

    public Item(String name, String type, int latestCode) {
        Main.itemCode++;
        this.name = name;
        code += latestCode;
        isWorn = false;
        setType(type);
        setAppropriatePower();
        setAdditionalPower();
        setPower();
        setWearable();
    }

    // getter
    public String getName() { return name; }
    public int getCode() { return code; }
    public double getPower() { return power; }
    public double getFixedPower() { return fixedPower; }
    public double getAdditionalPower() { return additionalPower; }
    public boolean getIsWorn() { return isWorn; }
    public String getType() { return type; }
    public boolean getWearable() { return wearable; }

    // setter
    public void setFixedPower(double power) { this.fixedPower = power; }
    public void setIsWorn(boolean state) { isWorn = state; } 
    public void setType(String type) { this.type = type; } 

    public void setWearable() { 
        String[] wearableType = new String[10];
        wearableType[0] = "weapon";

        wearable = false;

        for (String t : wearableType)
            if (type == t) wearable = true;
    } 

    // set weapon-based attack figure
    public void setAppropriatePower() {
        if (getName() == "sword") setFixedPower(50);
        else if (getName() == "bow") setFixedPower(30);
        else if (getName() == "axe") setFixedPower(40);
        else if (getName() == "arrow") setFixedPower(5);
    }

    public void setAdditionalPower() {
        Random rand = new Random();
        additionalPower = getFixedPower() * rand.nextDouble() * 0.5;
    } 
    
    public void setPower() {
        power = getFixedPower() + getAdditionalPower();
    }

    // print all information of the item
    public void printItemInfo() {
        System.out.println("-------------------------------");
        System.out.println("Item: " + getName() + "(" + getType() + ")");
        // System.out.println("Code: " + getCode());
        System.out.println("Power: " + String.format("%.2f", getPower()) + "(=" + getFixedPower() + "+" + String.format("%.2f", getAdditionalPower()) + ")");
        System.out.println("-------------------------------");
    }
}
