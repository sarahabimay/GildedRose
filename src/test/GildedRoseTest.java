package test;

import main.java.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class GildedRoseTest {

    @Test
    public void backwardCompatibleForStandardItemDexterityVest() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = createItems();
        rose.addItems(items);

        ItemContract item = items.get(0);
        String name = item.getName();
        int sellIn = item.getSellIn();
        int quality = item.getQuality();

        int expectedQuality = previousUpdateQuantityCode(item);
        sellIn--;
        int expectedSellIn = sellIn;

        rose.updateQualityOfAllItems();
        int sellInAfterUpdate = item.getSellIn();
        int qualityAfterUpdate = item.getQuality();

        System.out.println(String.format("%s: Quality b4: %s, SellIn b4: %s, Quality after: %s, SellIn after: %s, " +
                        "Expected Q: %s, Expected S: %s",
                name, quality, sellIn, qualityAfterUpdate, sellInAfterUpdate, expectedQuality, expectedSellIn));
        assertEquals(qualityAfterUpdate, expectedQuality);
    }

    @Test
    public void backwardCompatibleForAgedItem() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = createItems();
        rose.addItems(items);

        ItemContract item = items.get(1);
        int sellIn = item.getSellIn();

        int expectedQuality = previousUpdateQuantityCode(item);
        sellIn--;
        int expectedSellIn = sellIn;

        rose.updateQualityOfAllItems();
        int sellInAfterUpdate = item.getSellIn();
        int qualityAfterUpdate = item.getQuality();

        assertEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    public void backwardCompatableForStandardItem() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = createItems();
        rose.addItems(items);

        ItemContract item = items.get(2);
        int sellIn = item.getSellIn();

        int expectedQuality = previousUpdateQuantityCode(item);
        sellIn--;
        int expectedSellIn = sellIn;

        rose.updateQualityOfAllItems();
        int sellInAfterUpdate = item.getSellIn();
        int qualityAfterUpdate = item.getQuality();

        assertEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    public void backwardCompatableForNonDeteriatingItem() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = createItems();
        rose.addItems(items);

        ItemContract item = items.get(3);
        int sellIn = item.getSellIn();

        int expectedQuality = previousUpdateQuantityCode(item);
        int expectedSellIn = sellIn;

        rose.updateQualityOfAllItems();
        int sellInAfterUpdate = item.getSellIn();
        int qualityAfterUpdate = item.getQuality();

        assertEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    public void backwardCompatableForBackstagePass() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = createItems();
        rose.addItems(items);

        ItemContract item = items.get(4);
        int sellIn = item.getSellIn();

        int expectedQuality = previousUpdateQuantityCode(item);
        sellIn--;
        int expectedSellIn = sellIn;

        rose.updateQualityOfAllItems();
        int sellInAfterUpdate = item.getSellIn();
        int qualityAfterUpdate = item.getQuality();


        assertEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    public void notBackwardCompatableForConjuredItem() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = createItems();
        rose.addItems(items);

        ItemContract item = items.get(5);
        int sellIn = item.getSellIn();

        int expectedQuality = previousUpdateQuantityCode(item);
        sellIn--;
        int expectedSellIn = sellIn;

        rose.updateQualityOfAllItems();
        int sellInAfterUpdate = item.getSellIn();
        int qualityAfterUpdate = item.getQuality();

        assertNotEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    public void standardItem() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new StandardItem("Elixir of the Mongoose", 0, 5);
        assertEquals(3, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void backStagePassItemImprovesInQuality() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        assertEquals(23, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void backStagePassItemExpired() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        assertEquals(0, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void nonDegradingItem() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new NonDegradingItem("Sulfuras, Hand of Ragnaros", 0, 80);
        assertEquals(80, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void ageImprovedItem() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new AgeImprovedItem("Aged Brie", 0, 20);
        assertEquals(22, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void conjuredItem() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new ConjuredItem("Conjured Mana Cake", 3, 6);
        assertEquals(4, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void usePolymorphicItems() {
        GildedRose rose = new GildedRose();
        BackStagePassItem item = new BackStagePassItem("Backstage passes to something else", 0, 20);
        rose.addItem(item);
        rose.updateQualityOfItem(item);
        List<ItemContract> items = rose.getItems();
        ItemContract lastItem = items.get(items.size() - 1);

        assertEquals(-1, lastItem.getSellIn());
        assertEquals(0, lastItem.getQuality());
    }

    private List<ItemContract> createItems() {
        List<ItemContract> itemList = new ArrayList<>();
        itemList.add(new StandardItem("+5 Dexterity Vest", 10, 20));
        itemList.add(new AgeImprovedItem("Aged Brie", 2, 0));
        itemList.add(new StandardItem("Elixir of the Mongoose", 5, 7));
        itemList.add(new NonDegradingItem("Sulfuras, Hand of Ragnaros", 0, 80));
        itemList.add(new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        itemList.add(new ConjuredItem("Conjured Mana Cake", 3, 6));
        return itemList;
    }

    public int previousUpdateQuantityCode(ItemContract item) {
        int newQuality = item.getQuality();
        if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            if (item.getQuality() > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                    newQuality--;
                }
            }
        } else {
            if (item.getQuality() < 50) {
                newQuality++;

                if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                    if (item.getSellIn() < 11) {
                        if (item.getQuality() < 50) {
                            item.qualityTick();
                        }
                    }

                    if (item.getSellIn() < 6) {
                        if (item.getQuality() < 50) {
                            newQuality++;
                        }
                    }
                }
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
        }

        if (item.getSellIn() < 0) {
            if (!"Aged Brie".equals(item.getName())) {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                    if (item.getQuality() > 0) {
                        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                            newQuality--;
                        }
                    }
                } else {
                    newQuality -= newQuality;
                }
            } else {
                if (item.getQuality() < 50) {
                    newQuality++;
                }
            }
        }
        return newQuality;
    }
}
