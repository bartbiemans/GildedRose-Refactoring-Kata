package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void givenItem_WhenDayHasPassed_ThenSellInHasDegraded() {
        final int initialSellIn = 1;
        final Item[] items = new Item[]{new Item("non existing item", initialSellIn, 10)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void givenItem_WhenDayHasPassed_ThenQualityHasDegraded() {
        final int initialQuality = 10;
        final Item[] items = new Item[]{new Item("non existing item", 1, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].quality);
    }

    @Test
    void givenItem_WhenSellDateHasPassed_ThenQualityDegradesTwiceAsMuch() {
        final int initialQuality = 10;
        final Item[] items = new Item[]{new Item("non existing item", 1, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].quality);

        app.updateQuality();

        assertEquals(7, app.items[0].quality);

    }

    @Test
    void givenItem_WhenQualityIs0AndDayHasPassed_ThenQualityDoesNotDegrade() {
        final int initialQuality = 0;
        final Item[] items = new Item[]{new Item("non existing item", 1, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);

    }

    @Test
    void givenItemWithNameAgedBrie_WhenDayHasPassed_ThenQualityGoesUp() {
        final int initialQuality = 10;
        final Item[] items = new Item[]{new Item("Aged Brie", 0, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality > 10);
    }

    @Test
    void givenItemWithNameSulfurasHandOfRagnaros_WhenDayHasPassed_ThenQualityDoesNotDegrade() {
        final int initialQuality = 10;
        final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].quality);

    }

    @Test
    void givenItemWithNameBackStagePass_WhenDayHasPassedAndSellInIsHigherThan10_ThenQualityIncreases() {
        final int initialSellIn = 20;
        final int initialQuality = 10;
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items[0].quality);

    }

    @Test
    void givenItemWithNameBackStagePass_WhenDayHasPassedAndSellInIs10_ThenQualityIncreasesBy2() {
        final int initialSellIn = 10;
        final int initialQuality = 10;
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(12, app.items[0].quality);

    }

    @Test
    void givenItemWithNameBackStagePass_WhenDayHasPassedAndSellInIs5_ThenQualityIncreasesBy3() {
        final int initialSellIn = 5;
        final int initialQuality = 10;
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);

    }

    @Test
    void givenItemWithNameBackStagePassAndSellIn0_WhenDayHasPassed_ThenQualityIs0() {
        final int initialSellIn = 0;
        final int initialQuality = 10;
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);

    }

    @Test
    void givenItemWithNameBackStagePassAndSellIn1AndQuality50_WhenDayHasPassed_ThenQualityIsNotIncreased() {
        final int initialSellIn = 1;
        final int initialQuality = 50;
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);

    }

    @Test
    void givenItemWithNameConjured_WhenDayHasPassed_ThenQualityIsDecreasedBy2() {
        final int initialSellIn = 10;
        final int initialQuality = 10;
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", initialSellIn, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);

    }

    @Test
    void givenItemWithNameConjuredAndQuality0_WhenDayHasPassed_ThenQualityIsNotDecreased() {
        final int initialSellIn = 10;
        final int initialQuality = 0;
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", initialSellIn, initialQuality)};
        final GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);

    }
}
