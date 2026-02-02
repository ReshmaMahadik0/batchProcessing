package com.example.BatchProcessing_app.config;

import com.example.BatchProcessing_app.entity.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class CustomItemProcesssor  implements ItemProcessor<Product, Product> {


    @Override
    public Product process(Product item) throws Exception {
        int discountPer = Integer.parseInt(item.getDiscount());
        double originalPrice = Double.parseDouble(item.getPrice());
        double discount = (discountPer/100) * originalPrice;
        double finalPrice = originalPrice - discount;
        item.setDiscountedPrice(String.valueOf(finalPrice));
        return item;
    }
}
