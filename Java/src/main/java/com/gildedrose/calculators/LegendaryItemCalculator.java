package com.gildedrose.calculators;

import com.gildedrose.Item;
import com.gildedrose.ItemCalculator;

import java.util.List;

public class LegendaryItemCalculator implements ItemCalculator {

    private static final List<String> QUALIFIED_ITEMS = List.of("Sulfuras, Hand of Ragnaros");

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
        return item.quality;
    }

    @Override
    public int calculateSellIn() {
        return item.sellIn;
    }

}
