package com.example.BatchProcessing_app.config;

import com.example.BatchProcessing_app.entity.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.math.BigDecimal;

public class CustomItemProcesssor  implements ItemProcessor<Product, Product> {


    @Override
    public Product process(Product item) {

        String discountStr = item.getDiscount().replace("%", "").trim();
        BigDecimal discountPercent = new BigDecimal(discountStr);

        BigDecimal hundred = new BigDecimal("100");

        BigDecimal discountAmount =
                item.getPrice()
                        .multiply(discountPercent)
                        .divide(hundred);

        BigDecimal finalPrice =
                item.getPrice().subtract(discountAmount);

        item.setDiscountedPrice(finalPrice);
        return item;
    }
}
