import main.java.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ItemContract> itemList = createItems();
        GildedRose rose = new GildedRose();
        rose.addItems(itemList);
        rose.updateQualityOfAllItems();
    }

    private static List<ItemContract> createItems() {
        List<ItemContract> itemList = new ArrayList<>();
        itemList.add(new StandardItem("+5 Dexterity Vest", 10, 20));
        itemList.add(new AgeImprovedItem("Aged Brie", 2, 0));
        itemList.add(new StandardItem("Elixir of the Mongoose", 5, 7));
        itemList.add(new NonDegradingItem("Sulfuras, Hand of Ragnaros", 0, 80));
        itemList.add(new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        itemList.add(new ConjuredItem("Conjured Mana Cake", 3, 6));
        return itemList;
    }
}
