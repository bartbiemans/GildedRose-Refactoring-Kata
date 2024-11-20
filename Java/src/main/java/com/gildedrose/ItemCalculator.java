package com.gildedrose;

public interface ItemCalculator {

    boolean applicableFor(String name);

    ItemCalculator instantiate(Item item);

    int calculateQuality();

    int calculateSellIn();

}
