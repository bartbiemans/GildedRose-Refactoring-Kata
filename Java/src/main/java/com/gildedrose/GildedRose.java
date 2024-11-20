package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
            .forEach(item -> {
                final ItemCalculator itemCalculator = ItemProcessorFactory.getQualityCalculatorForItem(item);
                item.quality = itemCalculator.calculateQuality();
                item.sellIn = itemCalculator.calculateSellIn();
            });
    }
}
