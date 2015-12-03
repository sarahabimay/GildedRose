package main.java;

public class StandardItem extends Item implements ItemContract{
    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int sellInTick() {
        sellIn--;
        return sellIn;
    }

    public int qualityTick() {
        if (quality > 0) {
            quality--;
        }
        if (sellIn < 0) {
            quality--;
        }
        return quality;
    }
}
