package main.java;

public interface ItemContract {
    void updateItem();
    int sellInTick();
    int qualityTick();

    int getSellIn();
    int getQuality();
    String getName();
}
