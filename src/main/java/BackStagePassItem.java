package main.java;

public class BackStagePassItem extends Item implements ItemContract{
    public BackStagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int sellInTick() {
        sellIn--;
        return sellIn;
    }

    public int qualityTick() {
        if (quality < 50) {
            quality++;

            if (sellIn < 11) {
                if (quality < 50) {
                    quality++;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality++;
                }
            }
        }

        if (sellIn < 0) {
            quality -= quality;
        }
        return quality;
    }
}
