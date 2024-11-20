package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        final String AgedBrie = "Aged Brie";
        final String backStagePass = "Backstage passes to a TAFKAL80ETC concert";
        final String sulfuras = "Sulfuras, Hand of Ragnaros";
        final String conjured = "Conjured Mana Cake";

        Arrays.stream(items)
            .filter(item -> !item.name.equals(sulfuras))
            .forEach(item -> {
                item.quality = switch (item.name) {
                    case AgedBrie -> calculateQualityForAgedBrie(item);
                    case backStagePass -> calculateQualityForBackStagePass(item);
                    case conjured -> calculateQualityForConjuredItem(item);
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
        return agedBrie.quality < 50 ? agedBrie.quality + 1 : agedBrie.quality;
    }

    private int calculateQualityForBackStagePass(final Item backStagePass) {
        if (backStagePass.sellIn > 10) {
            return backStagePass.quality + 1;
        }
        if (backStagePass.sellIn > 5) {
            return backStagePass.quality + 2;
        }
        if (backStagePass.sellIn > 0) {
            return backStagePass.quality + 3;
        } else {
            return backStagePass.quality = 0;
        }
    }
}
