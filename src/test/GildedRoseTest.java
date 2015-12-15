package test;

import main.java.GildedRose;
import main.java.Item;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    @Test
    public void qualityIsNeverNegative() {
        GildedRose gildedRose = new GildedRose();
        gildedRose.addItem(new Item("Elixir of the Mongoose", 1, 0));
        assertEquals(0, gildedRose.getItems().get(0).getQuality());
    }

    @Test
    public void ageImprovedItemIncreaseByOneWhenSellInGT0() {
        GildedRose rose = new GildedRose();
        Item item = new Item("Aged Brie", 1, 20);
        rose.addItem(item);
        rose.updateQuality();
        assertEquals(21, rose.getItems().get(0).getQuality());
    }
    @Test
    public void ageImprovedItemIncreaseByTwo() {
        GildedRose rose = new GildedRose();
        Item item = new Item("Aged Brie", 0, 20);
        rose.addItem(item);
        rose.updateQuality();
        assertEquals(22, rose.getItems().get(0).getQuality());
    }

    @Test
    public void qualityNeverExceeds50() {
        GildedRose rose = new GildedRose();
        Item item = new Item("Aged Brie", 1, 50);
        rose.addItem(item);
        rose.updateQuality();
        assertEquals(50, rose.getItems().get(0).getQuality());
    }

    @Test
    public void nonDegradingItem() {
        GildedRose rose = new GildedRose();
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
        rose.addItem(item);
        rose.updateQuality();
        assertEquals(80, rose.getItems().get(0).getQuality());
        assertEquals(1, rose.getItems().get(0).getSellIn());
    }

    @Test
    public void backStagePassItemImprovesInQualityBy1() {
        GildedRose rose = new GildedRose();
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        rose.addItem(backstage);
        rose.updateQuality();
        assertEquals(21, rose.getItems().get(0).getQuality());
    }

    @Test
    public void backStagePassItemIncreaseBy2() {
        GildedRose rose = new GildedRose();
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20);
        rose.addItem(backstage);
        rose.updateQuality();
        assertEquals(22, rose.getItems().get(0).getQuality());
    }

    @Test
    public void backStagePassItemIncreaseBy3() {
        GildedRose rose = new GildedRose();
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        rose.addItem(backstage);
        rose.updateQuality();
        assertEquals(23, rose.getItems().get(0).getQuality());
    }

    @Test
    public void backStagePassItemExpired() {
        GildedRose rose = new GildedRose();
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        rose.addItem(backstage);
        rose.updateQuality();
        assertEquals(0, rose.getItems().get(0).getQuality());
    }

    @Test
    public void standardItem() {
        GildedRose rose = new GildedRose();
        Item item = new Item("Elixir of the Mongoose", 0, 5);
        rose.addItem(item);
        rose.updateQuality();
        assertEquals(3, rose.getItems().get(0).getQuality());
    }

    @Test
    @Ignore
    public void conjuredItem() {
        GildedRose rose = new GildedRose();
        Item conjured = new Item("Conjured Mana Cake", 3, 6);
        rose.addItem(conjured);
        rose.updateQuality();
        assertEquals(4, rose.getItems().get(0).getQuality());
    }
}
