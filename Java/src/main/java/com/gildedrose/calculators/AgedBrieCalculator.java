package com.gildedrose.calculators;

import com.gildedrose.Item;
import com.gildedrose.ItemCalculator;

import java.util.List;

public class AgedBrieCalculator implements ItemCalculator {

    private static final List<String> QUALIFIED_ITEMS = List.of("Aged Brie");
    private Item item;

    @Override
    public boolean applicableFor(final Item item) {
        return QUALIFIED_ITEMS.contains(item.name);
    }

    @Override
    public ItemCalculator instantiate(final Item item) {
        this.item = item;
        return this;
    }

    @Override
    public int calculateQuality() {
        if (item.quality == 50) {
            return 50;
        }
        if (item.sellIn <= 0) {
            return item.quality <= 48 ? item.quality + 2 : 50;
        }
        return item.quality + 1;
    }

    @Override
    public int calculateSellIn() {
        return item.sellIn -1;
    }
}
