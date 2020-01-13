package com.app.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {

    private Category category = new Category("Apple");

    @Test
    public void test_GetTitle_Should_ReturnGivenProductTitle() {
        Product product = new Product("iPhone 7 Plus", 2543.99, category);

        assertEquals("iPhone 7 Plus", product.getTitle());
    }

    @Test
    public void test_GetPrice_Should_ReturnGivenProductPrice() {
        Product product = new Product("iPhone 7 Plus", 2543.99, category);

        assertTrue(2543.99 == product.getPrice());
    }

    @Test
    public void test_GetCategory_Should_ReturnGivenProductCategory() {
        Product product = new Product("iPhone 7 Plus", 2543.99, category);

        assertEquals(category, product.getCategory());
    }
}