package com.gildedrose;

public interface ItemCalculator {

    boolean applicableFor(Item item);

    ItemCalculator instantiate(Item item);

    int calculateQuality();

    int calculateSellIn();

}
