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

        for (Item item : items) {
            if (!item.name.equals(AgedBrie)
                && !item.name.equals(backStagePass)) {
                if (item.quality > 0) {
                    if (!item.name.equals(sulfuras)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(backStagePass)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(sulfuras)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AgedBrie)) {
                    if (!item.name.equals(backStagePass)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(sulfuras)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
