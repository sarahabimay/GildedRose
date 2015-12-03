package main.java;

public class FixedItem extends Item implements ItemContract{
    public FixedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int sellInTick() {
        sellIn--;
        return sellIn;
    }

    public int qualityTick() {
        return quality;
    }
}
