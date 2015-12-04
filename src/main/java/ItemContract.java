package main.java;

public interface ItemContract {
    int getSellIn();
    int getQuality();
    String getName();

    void updateItem();
    int sellInTick();
    int qualityTick();
}
