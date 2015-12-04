package main.java;

public class ConjuredItem extends Item implements ItemContract {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
        sellInTick();
        qualityTick();
    }

    public int sellInTick() {
        sellIn--;
        return sellIn;

    }

    public int qualityTick() {
        if (quality > 0) {
            quality -= 2;
        }
        if (sellIn < 0) {
            quality -= 2;
        }
        return quality;
    }
}
