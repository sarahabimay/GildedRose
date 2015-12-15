package main.java;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

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
            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                if (("Aged Brie".equals(items.get(i).getName()))) {
                    if (items.get(i).getQuality() < 50) {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    }
                } else if (
                        "Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                    if (items.get(i).getQuality() < 50) {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);

                        if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                            if (items.get(i).getSellIn() < 11) {
                                if (items.get(i).getQuality() < 50) {
                                    items.get(i).setQuality(items.get(i).getQuality() + 1);
                                }
                            }

                            if (items.get(i).getSellIn() < 6) {
                                if (items.get(i).getQuality() < 50) {
                                    items.get(i).setQuality(items.get(i).getQuality() + 1);
                                }
                            }
                        }
                    }
                } else if (items.get(i).getQuality() > 0) {
                    items.get(i).setQuality(items.get(i).getQuality() - 1);
                }

                items.get(i).setSellIn(items.get(i).getSellIn() - 1);

                if (items.get(i).getSellIn() < 0) {
                    if ("Aged Brie".equals(items.get(i).getName()) && items.get(i).getQuality() < 50) {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    } else if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    } else if (items.get(i).getQuality() > 0) {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            }
        }
    }
}
