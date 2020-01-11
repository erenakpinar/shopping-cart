package com.app.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Category category = new Category("Apple");

    @Test
    public void test_GetTitle() {
        Product product = new Product("iPhone 7 Plus", 2543.99, category);

        assertEquals("iPhone 7 Plus", product.getTitle());
    }

    @Test
    public void test_GetPrice() {
        Product product = new Product("iPhone 7 Plus", 2543.99, category);

        assertTrue(2543.99 == product.getPrice());
    }

    @Test
    public void test_GetCategory() {
        Product product = new Product("iPhone 7 Plus", 2543.99, category);

        assertEquals(category, product.getCategory());
    }
}