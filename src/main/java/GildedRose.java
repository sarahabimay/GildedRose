package main.java;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED_ITEM = "Conjured Mana Cake";
    private static List<Item> items = null;

    public GildedRose() {
        items = new ArrayList<>();
    }

    public static void main(String[] args) {

        items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
    }

    public List<Item> getItems() {
        return items;
    }


    public void addItem(Item item) {
        items.add(item);
    }


    public void addItems(List<Item> items) {
        items = items;
    }

    public static void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (!itemIs(SULFURAS, item)) {
                updateQualityOfBrie(item);
                updateQualityOfBackstagePasses(item);
                updateQualityOfStandardItem(item);
                updateQualityOfConjuredItem(item);
            }
        }
    }

    private static void updateQualityOfStandardItem(Item item) {
        if (!itemIsNonStandard(item) && item.getQuality() > 0) {
            decreaseQualityBy(1, item);
            decreaseSellinByOne(item);
            if (item.getSellIn() < 0 && item.getQuality() > 0) {
                decreaseQualityBy(1, item);
            }
        }
    }

    private static void updateQualityOfConjuredItem(Item item) {
        if (itemIs(CONJURED_ITEM, item)) {
            decreaseQualityBy(2, item);
            decreaseSellinByOne(item);
            if (item.getSellIn() < 0 && item.getQuality() > 0) {
                decreaseQualityBy(2, item);
            }
        }
    }

    private static void updateQualityOfBrie(Item item) {
        if (itemIs(AGED_BRIE, item) && isLessThanMaxQuality(item)) {
            increaseQualityByOne(item);
            decreaseSellinByOne(item);
            if (item.getSellIn() < 0) {
                increaseQualityByOne(item);
            }
        }
    }

    private static void updateQualityOfBackstagePasses(Item item) {
        if (itemIs(BACKSTAGE_PASS, item)) {
            if (isLessThanMaxQuality(item)) {
                increaseQualityOfBackstagePass(item);
            }
            decreaseSellinByOne(item);
            if (item.getSellIn() < 0) {
                reduceQualityToZero(item);
            }
        }
    }

    private static void increaseQualityOfBackstagePass(Item item) {
        increaseQualityByOne(item);
        if (item.getSellIn() < 11) {
            increaseQualityByOne(item);
        }
        if (item.getSellIn() < 6) {
            increaseQualityByOne(item);
        }
    }

    private static void reduceQualityToZero(Item item) {
        decreaseQualityBy(item.getQuality(), item);
    }

    private static boolean itemIs(String itemName, Item item) {
        return itemName.equals(item.getName());
    }

    private static boolean itemIsNonStandard(Item item) {
        return itemIs(AGED_BRIE, item) || itemIs(BACKSTAGE_PASS, item) || itemIs(CONJURED_ITEM, item);
    }

    private static void decreaseSellinByOne(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    private static void decreaseQualityBy(int amount, Item item) {
        item.setQuality(item.getQuality() - amount);
    }

    private static void increaseQualityByOne(Item item) {
        item.setQuality(item.getQuality() + 1);
    }

    private static boolean isLessThanMaxQuality(Item item) {
        return item.getQuality() < 50;
    }
}
