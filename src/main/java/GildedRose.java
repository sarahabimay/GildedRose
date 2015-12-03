package main.java;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private List<Item> items = null;

    public static void main(String[] args) {
        GildedRose rose = new GildedRose();
        rose.createItems();
        rose.updateQuality();
    }

    public GildedRose() {
        this.items = new ArrayList<>();
    }

    public List<Item> createItems() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("+5 Dexterity Vest", 10, 20));
        itemList.add(new Item("Aged Brie", 2, 0));
        itemList.add(new Item("Elixir of the Mongoose", 5, 7));
        itemList.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        itemList.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        itemList.add(new Item("Conjured Mana Cake", 3, 6));
        items = itemList;
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityOfItem(item);
        }
    }

    public Item updateQualityOfItem(Item item) {
        updateSellIn(item);

        if (isStandardItem(item)) {
            updateStandardItem(item);
        }

        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            updateOnlyBackstagePasses(item);
        }
        if ("Aged Brie".equals(item.getName())) {
            updateOnlyAgedBrie(item);
        }
        return item;
    }

    private void updateStandardItem(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
        if (item.getSellIn() < 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private boolean isStandardItem(Item item) {
        return (!"Aged Brie".equals(item.getName())) &&
                !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) &&
                !"Sulfuras, Hand of Ragnaros".equals(item.getName());
    }

    private void updateOnlyAgedBrie(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);

            if (item.getSellIn() < 0) {
                item.setQuality(item.getQuality() + 1);
            }
        }
    }

    private void updateOnlyBackstagePasses(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);

            if (item.getSellIn() < 11) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }

            if (item.getSellIn() < 6) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }

        if (item.getSellIn() < 0) {
            item.setQuality(item.getQuality() - item.getQuality());
        }
    }

    private void updateSellIn(Item item) {
        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}