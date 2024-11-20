package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
            .filter(item -> !item.name.equals("Sulfuras, Hand of Ragnaros"))
            .forEach(item -> {
                item.quality = switch (item.name) {
                    case "Aged Brie" -> calculateQualityForAgedBrie(item);
                    case "Backstage passes to a TAFKAL80ETC concert" -> calculateQualityForBackStagePass(item);
                    case "Conjured Mana Cake" -> calculateQualityForConjuredItem(item);
                    default -> calculateQualityForDefaultItem(item);
                };
                item.sellIn = item.sellIn - 1;
            });
    }

    private int calculateQualityForConjuredItem(final Item item) {
        if (item.quality == 0) {
            return 0;
        }
        return item.quality >= 2 ? item.quality - 2 : item.quality - 1;
    }

    private int calculateQualityForDefaultItem(final Item item) {
        if (item.quality == 0) {
            return 0;
        }

        return item.sellIn <= 0 ? item.quality - 2 : item.quality - 1;
    }

    private int calculateQualityForAgedBrie(final Item agedBrie) {
        if (agedBrie.quality == 50) {
            return 50;
        }
        if (agedBrie.sellIn <= 0) {
            return agedBrie.quality <= 48 ? agedBrie.quality + 2 : 50;
        }
        return agedBrie.quality + 1;
    }

    private int calculateQualityForBackStagePass(final Item backStagePass) {
        if (backStagePass.sellIn > 10) {
            return backStagePass.quality + 1;
        }
        if (backStagePass.sellIn > 5) {
            return backStagePass.quality <= 48 ? backStagePass.quality + 2 : 50;
        }
        if (backStagePass.sellIn > 0) {
            return backStagePass.quality <= 47 ? backStagePass.quality + 3 : 50;

        }
        return 0;
    }
}
