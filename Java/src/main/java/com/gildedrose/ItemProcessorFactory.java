package com.gildedrose;

import com.gildedrose.calculators.AgedBrieCalculator;
import com.gildedrose.calculators.BackStagePassCalculator;
import com.gildedrose.calculators.ConjuredItemCalculator;
import com.gildedrose.calculators.DefaultItemCalculator;
import com.gildedrose.calculators.LegendaryItemCalculator;

import java.util.List;

public final class ItemProcessorFactory {

    private static final ItemCalculator DEFAULT_QUALITY_CALCULATOR = new DefaultItemCalculator();
    private static final List<ItemCalculator> CALCULATORS = List.of(new AgedBrieCalculator(), new BackStagePassCalculator(), new ConjuredItemCalculator(), new LegendaryItemCalculator());

    private ItemProcessorFactory() {
    }

    public static ItemCalculator getQualityCalculatorForItem(final Item item) {
        return CALCULATORS.stream()
            .filter(calculator -> calculator.applicableFor(item.name))
            .findFirst()
            .orElse(DEFAULT_QUALITY_CALCULATOR)
            .instantiate(item);
    }

}
