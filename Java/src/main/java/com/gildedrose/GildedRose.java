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
                case backStagePass -> updateBackStagePass(item);
                default -> updateDefaultItem(item);
            }
        }
    }

    private void updateDefaultItem(final Item item) {
        if(item.quality <= 0 ) {
            item.sellIn = item.sellIn - 1;
            return;
        }

        item.quality = item.quality - 1;
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void updateAgedBrie(final Item agedBrie) {
        if (agedBrie.quality < 50) {
            agedBrie.quality++;
        }
        agedBrie.sellIn = agedBrie.sellIn - 1;
    }

    private void updateBackStagePass(final Item backStagePass) {
        if (backStagePass.sellIn > 10) {
            backStagePass.quality++;
        } else if (backStagePass.sellIn > 5) {
            backStagePass.quality += 2;
        } else if (backStagePass.sellIn > 0) {
            backStagePass.quality += 3;
        } else {
            backStagePass.quality = 0;
        }
        backStagePass.sellIn--;
    }
}
