import main.java.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> itemList = createItems();
        GildedRose rose = new GildedRose();
        rose.addItems(itemList);
        rose.updateQuality();
    }

    private static List<Item> createItems() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("+5 Dexterity Vest", 10, 20));
        itemList.add(new Item("Aged Brie", 2, 0));
        itemList.add(new Item("Elixir of the Mongoose", 5, 7));
        itemList.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        itemList.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        itemList.add(new Item("Conjured Mana Cake", 3, 6));
        return itemList;
    }
}
