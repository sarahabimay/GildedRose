package test;

import main.java.AgeImprovedItem;
import main.java.BackStagePassItem;
import main.java.FixedItem;
import main.java.StandardItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExtendedItemTest {
    @Test
    public void sellInDecremented() {
        StandardItem item = new StandardItem("+5 Dexterity Vest", 10, 20);
        assertEquals(9, item.sellInTick());
        assertEquals(19, item.qualityTick());
    }

    @Test
    public void sellInBecomesNegative() {
        StandardItem item = new StandardItem("+5 Dexterity Vest", 0, 20);
        assertEquals(-1, item.sellInTick());
        assertEquals(18, item.qualityTick());
    }

    @Test
    public void standardItemWithNonNegativeSellIn() {
        StandardItem item = new StandardItem("+5 Dexterity Vest", 5, 20);
        assertEquals(4, item.sellInTick());
        assertEquals(19, item.qualityTick());
    }

    @Test
    public void itemWithFixedQualityAfterSellInReduced() {
        FixedItem fixed = new FixedItem("Sulfuras, Hand of Ragnaros", 0, 80);
        assertEquals(-1, fixed.sellInTick());
        assertEquals(80, fixed.qualityTick());
    }

    @Test
    public void backStagePassQualityIncrementsBy1IfMoreThan10SellInDays() {
        BackStagePassItem bsp = new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        assertEquals(14, bsp.sellInTick());
        assertEquals(21, bsp.qualityTick());
    }

    @Test
    public void backStagePassQualityIncrementsBy2IfLessThan11SellInDays() {
        BackStagePassItem bsp = new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        assertEquals(10, bsp.sellInTick());
        assertEquals(22, bsp.qualityTick());
    }

    @Test
    public void backStagePassQualityIncrementsBy3IfLessThan6SellInDays() {
        BackStagePassItem bsp = new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 6, 20);
        assertEquals(5, bsp.sellInTick());
        assertEquals(23, bsp.qualityTick());
    }

    @Test
    public void backStagePassQualitySetToZeroIfExpired() {
        BackStagePassItem bsp = new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        assertEquals(-1, bsp.sellInTick());
        assertEquals(0, bsp.qualityTick());
    }

    @Test
    public void backStagePassQualityCappedAt50() {
        BackStagePassItem bsp = new BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 6, 50);
        assertEquals(5, bsp.sellInTick());
        assertEquals(50, bsp.qualityTick());
    }

    @Test
    public void agedBrieItemIncreasesInQualityAsSellInDateDecreases() {
        AgeImprovedItem aged = new AgeImprovedItem("Aged Brie", 2, 0);
        assertEquals(1, aged.sellInTick());
        assertEquals(1, aged.qualityTick());
    }

    @Test
    public void agedBrieItemIncreaseQualityBy2IfExpired() {
        AgeImprovedItem aged = new AgeImprovedItem("Aged Brie", 0, 0);
        assertEquals(-1, aged.sellInTick());
        assertEquals(2, aged.qualityTick());
    }

    @Test
    public void agedBrieItemCappedAt50() {
        AgeImprovedItem aged = new AgeImprovedItem("Aged Brie", 0, 50);
        assertEquals(-1, aged.sellInTick());
        assertEquals(50, aged.qualityTick());
    }
}
