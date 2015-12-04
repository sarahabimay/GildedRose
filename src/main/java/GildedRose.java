package main.java;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private List<ItemContract> items = null;

    public GildedRose() {
        this.items = new ArrayList<>();
    }

    public void addItems(List<ItemContract> items) {
        this.items = items;
    }

    public void updateQualityOfAllItems() {
        for (ItemContract item : items) {
            updateQualityOfItem(item);
        }
    }

    public ItemContract updateQualityOfItem(ItemContract item) {
        item.updateItem();
        return item;
    }

    public List<ItemContract> getItems() {
        return items;
    }

    public void addItem(ItemContract item) {
        items.add(item);
    }

}