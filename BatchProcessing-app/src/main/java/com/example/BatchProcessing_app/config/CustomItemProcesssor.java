package com.example.BatchProcessing_app.config;

import com.example.BatchProcessing_app.entity.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcesssor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product item) {

        // Remove % sign safely
        String discountStr = item.getDiscount().replace("%", "").trim();

        double discountPercent = Double.parseDouble(discountStr);
        double originalPrice = Double.parseDouble(item.getPrice());

        double discountAmount = (discountPercent / 100.0) * originalPrice;
        double finalPrice = originalPrice - discountAmount;

        item.setDiscountedPrice(String.valueOf(finalPrice));
        return item;
    }
}
