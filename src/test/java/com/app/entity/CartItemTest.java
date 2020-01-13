package com.app.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartItemTest {
    private Category appleCategory = new Category("Apple");
    private Product iPhoneProduct = new Product("iPhone", 5001.23, appleCategory);
    private CartItem cartItem;

    @BeforeEach
    void setUp() {
        cartItem = new CartItem(iPhoneProduct, 10);
    }

    @Test
    public void test_GetProduct_Should_ReturnGivenProduct() {
        assertEquals(iPhoneProduct, cartItem.getProduct());
    }

    @Test
    public void test_GetQuantity_Should_ReturnGivenQuantity() {
        assertEquals(10, cartItem.getQuantity());
    }

    @Test
    public void test_SetQuantity_Should_ReturnEditedQuantity() {
        cartItem.setQuantity(5);

        assertEquals(5, cartItem.getQuantity());
    }
}