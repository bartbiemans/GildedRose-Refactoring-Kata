package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        final String AgedBrie = "Aged Brie";
        final String backStagePass = "Backstage passes to a TAFKAL80ETC concert";
        final String sulfuras = "Sulfuras, Hand of Ragnaros";

        for (final Item item : items) {
            if (item.name.equals(sulfuras)) {
                continue;
            }

            item.quality = switch (item.name) {
                case AgedBrie -> calculateQualityForAgedBrie(item);
                case backStagePass -> calculateQualityForBackStagePass(item);
                default -> calculateQualityForDefaultItem(item);
            };
            item.sellIn = item.sellIn - 1;
        }
    }

    private int calculateQualityForDefaultItem(final Item item) {
        if (item.quality == 0) {
            return 0;
        }

        if (item.sellIn <= 0) {
            if (item.quality > 0) {
                return item.quality - 2;
            }
        }
        return item.quality - 1;
    }

    private int calculateQualityForAgedBrie(final Item agedBrie) {
        return agedBrie.quality < 50 ? agedBrie.quality + 1 : agedBrie.quality;
    }

    private int calculateQualityForBackStagePass(final Item backStagePass) {
        if (backStagePass.sellIn > 10) {
            return backStagePass.quality + 1;
        } else if (backStagePass.sellIn > 5) {
            return backStagePass.quality + 2;
        } else if (backStagePass.sellIn > 0) {
            return backStagePass.quality + 3;
        } else {
            return backStagePass.quality = 0;
        }
    }
}
