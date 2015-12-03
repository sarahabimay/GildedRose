package test;

import main.java.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class GildedRoseTest {

    @Test
    public void testTheTruth() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = rose.createItems();

        String name = items.get(0).getName();
        int sellIn = items.get(0).getSellIn();
        int quality = items.get(0).getQuality();
        rose.updateQuality();
        items = rose.getItems();
        int sellInAfterUpdate = items.get(0).getSellIn();
        int qualityAfterUpdate = items.get(0).getQuality();

        int expectedQuality = quality;
        int expectedSellIn = sellIn;
        if ((!"Aged Brie".equals(name)) && !"Backstage passes to a TAFKAL80ETC concert".equals(name)) {
            if (quality > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(name)) {
                    expectedQuality--;
                }
            }
        }
        if (!"Sulfuras, Hand of Ragnaros".equals(name)) {
            expectedSellIn--;
            assertEquals(sellInAfterUpdate, expectedSellIn);
        }
        System.out.println(String.format("%s: Quality b4: %s, SellIn b4: %s, Quality after: %s, SellIn after: %s, " +
                        "Expected Q: %s, Expected S: %s",
                name, quality, sellIn, qualityAfterUpdate, sellInAfterUpdate, expectedQuality, expectedSellIn));
        assertEquals(qualityAfterUpdate, expectedQuality);
    }

    @Test
    public void testItem2() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = rose.createItems();

        String name = items.get(1).getName();
        int sellIn = items.get(1).getSellIn();
        int quality = items.get(1).getQuality();
        rose.updateQuality();
        items = rose.getItems();
        int sellInAfterUpdate = items.get(1).getSellIn();
        int qualityAfterUpdate = items.get(1).getQuality();

        int expectedQuality = quality;
        int expectedSellIn = sellIn;
        if (quality < 50) {
            expectedQuality++;
        }
        if (!"Sulfuras, Hand of Ragnaros".equals(name)) {
            expectedSellIn--;
            assertEquals(sellInAfterUpdate, expectedSellIn);
        }

        System.out.println(String.format("%s: Quality b4: %s, SellIn b4: %s, Quality after: %s, SellIn after: %s, " +
                        "Expected Q: %s, Expected S: %s",
                name, quality, sellIn, qualityAfterUpdate, sellInAfterUpdate, expectedQuality, expectedSellIn));
        assertEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    public void testItem3() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = rose.createItems();

        String name = items.get(2).getName();
        int sellIn = items.get(2).getSellIn();
        int quality = items.get(2).getQuality();
        rose.updateQuality();
        items = rose.getItems();
        int sellInAfterUpdate = items.get(2).getSellIn();
        int qualityAfterUpdate = items.get(2).getQuality();

        int expectedQuality = quality;
        int expectedSellIn = sellIn;
        if ((!"Aged Brie".equals(name)) && !"Backstage passes to a TAFKAL80ETC concert".equals(name)) {
            if (quality > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(name)) {
                    expectedQuality--;
                }
            }
        }
        if (!"Sulfuras, Hand of Ragnaros".equals(name)) {
            expectedSellIn--;
            assertEquals(sellInAfterUpdate, expectedSellIn);
        }

        assertEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    public void testItem4() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = rose.createItems();

        String name = items.get(3).getName();
        int sellIn = items.get(3).getSellIn();
        int quality = items.get(3).getQuality();
        rose.updateQuality();
        items = rose.getItems();
        int sellInAfterUpdate = items.get(3).getSellIn();
        int qualityAfterUpdate = items.get(3).getQuality();

        int expectedQuality = quality;
        int expectedSellIn = sellIn-1;

        assertEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    public void testItem5() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = rose.createItems();

        String name = items.get(4).getName();
        int sellIn = items.get(4).getSellIn();
        int quality = items.get(4).getQuality();
        rose.updateQuality();
        items = rose.getItems();
        int sellInAfterUpdate = items.get(4).getSellIn();
        int qualityAfterUpdate = items.get(4).getQuality();

        int expectedQuality = quality;
        int expectedSellIn = sellIn;

        if (quality < 50) {
            expectedQuality++;
        }
        if (!"Sulfuras, Hand of Ragnaros".equals(name)) {
            expectedSellIn--;
            assertEquals(sellInAfterUpdate, expectedSellIn);
        }


        assertEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    @Ignore
    public void testItem6() {
        GildedRose rose = new GildedRose();
        List<ItemContract> items = rose.createItems();

        String name = items.get(5).getName();
        int sellIn = items.get(5).getSellIn();
        int quality = items.get(5).getQuality();
        rose.updateQuality();
        items = rose.getItems();
        int sellInAfterUpdate = items.get(5).getSellIn();
        int qualityAfterUpdate = items.get(5).getQuality();

        int expectedQuality = quality;
        int expectedSellIn = sellIn;
        if ((!"Aged Brie".equals(name)) && !"Backstage passes to a TAFKAL80ETC concert".equals(name)) {
            if (quality > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(name)) {
                    expectedQuality--;
                }
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(name)) {
            expectedSellIn--;
            assertEquals(sellInAfterUpdate, expectedSellIn);
        }

        assertEquals(qualityAfterUpdate, expectedQuality);
        assertEquals(sellInAfterUpdate, expectedSellIn);
    }

    @Test
    public void testItem7() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        assertEquals(23, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void testItem8() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new FixedItem("Sulfuras, Hand of Ragnaros", 0, 80);
        assertEquals(80, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void testItem9() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new StandardItem("Elixir of the Mongoose", 0, 5);
        assertEquals(3, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void testItem10() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        assertEquals(0, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void testItem11() {
        GildedRose rose = new GildedRose();
        ItemContract backstage = new AgeImprovedItem("Aged Brie", 0, 20);
        assertEquals(22, rose.updateQualityOfItem(backstage).getQuality());
    }

    @Test
    public void usePolymorphicItems() {
        GildedRose rose = new GildedRose();
        BackStagePassItem item = new BackStagePassItem("Backstage passes to something else", 0, 20);
        rose.addItem(item);
        rose.updateQualityOfItem(item);
        List<ItemContract> items = rose.getItems();

        assertEquals(-1, items.get(items.size() - 1).getSellIn());
        assertEquals(0, items.get(items.size()-1).getQuality());
    }
}
