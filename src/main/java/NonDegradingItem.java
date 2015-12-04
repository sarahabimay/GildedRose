package main.java;

public class NonDegradingItem extends Item implements ItemContract{
    public NonDegradingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
        sellInTick();
        qualityTick();
    }

    public int sellInTick() {
        return sellIn;
    }

    public int qualityTick() {
        return quality;
    }
}
