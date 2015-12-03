package main.java;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private List<ItemContract> items = null;

    public static void main(String[] args) {
        GildedRose rose = new GildedRose();
        rose.createItems();
        rose.updateQuality();
    }

    public GildedRose() {
        this.items = new ArrayList<>();
    }

    public List<ItemContract> createItems() {
        List<ItemContract> itemList = new ArrayList<>();
        itemList.add(new StandardItem("+5 Dexterity Vest", 10, 20));
        itemList.add(new AgeImprovedItem("Aged Brie", 2, 0));
        itemList.add(new StandardItem("Elixir of the Mongoose", 5, 7));
        itemList.add(new FixedItem("Sulfuras, Hand of Ragnaros", 0, 80));
        itemList.add(new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//        itemList.add(new Item("Conjured Mana Cake", 3, 6));
        items = itemList;
        return items;
    }

    public void updateQuality() {
        for (ItemContract item : items) {
            updateQualityOfItem(item);
        }
    }

    public ItemContract updateQualityOfItem(ItemContract item) {
        item.sellInTick();
        item.qualityTick();
        return item;
    }

    public List<ItemContract> getItems() {
        return items;
    }

    public void addItem(ItemContract item) {
        items.add(item);
    }
}