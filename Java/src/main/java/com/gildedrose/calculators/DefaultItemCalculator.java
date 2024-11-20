package com.gildedrose.calculators;

import com.gildedrose.Item;
import com.gildedrose.ItemCalculator;

public class DefaultItemCalculator implements ItemCalculator {

    private Item item;

    @Override
    public boolean applicableFor(final String name) {
        return true;
    }

    @Override
    public ItemCalculator instantiate(final Item item) {
        this.item = item;
        return this;
    }

    @Override
    public int calculateQuality() {
        if (item.quality == 0) {
            return 0;
        }

        return item.sellIn <= 0 ? item.quality - 2 : item.quality - 1;
    }

    @Override
    public int calculateSellIn() {
        return item.sellIn - 1;
    }
}
