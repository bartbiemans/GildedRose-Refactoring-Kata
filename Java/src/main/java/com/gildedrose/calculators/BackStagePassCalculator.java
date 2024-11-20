package com.gildedrose.calculators;

import com.gildedrose.Item;
import com.gildedrose.ItemCalculator;

import java.util.List;

public class BackStagePassCalculator implements ItemCalculator {

    private static final List<String> QUALIFIED_ITEMS = List.of("Backstage passes to a TAFKAL80ETC concert");
    private Item item;

    @Override
    public boolean applicableFor(final String name) {
        return QUALIFIED_ITEMS.contains(name);
    }

    @Override
    public ItemCalculator instantiate(final Item item) {
        this.item = item;
        return this;
    }

    @Override
    public int calculateQuality() {
        if (item.sellIn > 10) {
            return item.quality + 1;
        }
        if (item.sellIn > 5) {
            return item.quality <= 48 ? item.quality + 2 : 50;
        }
        if (item.sellIn > 0) {
            return item.quality <= 47 ? item.quality + 3 : 50;

        }
        return 0;
    }

    @Override
    public int calculateSellIn() {
        return item.sellIn - 1;
    }
}
