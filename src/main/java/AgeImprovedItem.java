package main.java;

public class AgeImprovedItem extends Item implements ItemContract {
    public AgeImprovedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int sellInTick() {
        sellIn--;
        return sellIn;
    }

    public int qualityTick() {
        if (quality < 50) {
            quality++;
            if (sellIn < 0) {
                quality++;
            }
        }
        return quality;
    }
}
