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
            if (item.name.equals(sulfuras)) {
                continue;
            }
            switch (item.name) {
                case AgedBrie -> updateAgedBrie(item);
                default -> {
                    if (!item.name.equals(backStagePass)) {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;

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

                    item.sellIn = item.sellIn - 1;

                    if (item.sellIn < 0) {
                        if (!item.name.equals(backStagePass)) {
                            if (item.quality > 0) {
                                item.quality = item.quality - 1;
                            }
                        } else {
                            item.quality = 0;
                        }
                    }
                }
            }
        }
    }

    private void updateAgedBrie(final Item agedBrie) {
        if (agedBrie.quality < 50) {
            agedBrie.quality++;
        }
        agedBrie.sellIn = agedBrie.sellIn - 1;
    }
}
