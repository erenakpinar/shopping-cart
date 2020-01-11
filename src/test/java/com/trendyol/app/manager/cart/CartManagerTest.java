package com.trendyol.app.manager.cart;

import com.trendyol.app.entity.CartItem;
import com.trendyol.app.entity.Category;
import com.trendyol.app.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {

    private List<CartItem> cartItems;
    private Category category = new Category("Apple");
    private Product product1 = new Product("Iphone", 1000, category);
    private CartManager cartManager = new CartManager();

    @BeforeEach
    void setUp() {
        cartItems = new ArrayList<>();
    }

    @Test
    void test_addItem_Should_ListCountOne_IfNotExistsInList() {
        CartManager cartManager = Mockito.spy(this.cartManager);
        Mockito.doReturn(false).when(cartManager).existsProductInCartItemList(cartItems, product1.getTitle());
        cartManager.addItem(cartItems, product1, 1);

        assertEquals(1, cartItems.size());
    }

    @Test
    void test_addItem_Should_ListCountOne_IfExistsInList() {
        CartManager cartManager = Mockito.spy(this.cartManager);
        cartItems.add(new CartItem(product1, 1));
        Mockito.doReturn(true).when(cartManager).existsProductInCartItemList(cartItems, product1.getTitle());
        cartManager.addItem(cartItems, product1, 1);

        assertEquals(1, cartItems.size());
    }

    @Test
    void test_ExistsProductInCartItemList_Should_True_IfExistsInList() {
        cartItems.add(new CartItem(product1, 1));

        assertTrue(cartManager.existsProductInCartItemList(cartItems, product1.getTitle()));
    }

    @Test
    void test_ExistsProductInCartItemList_Should_False_IfNotExistsInList() {
        cartItems.add(new CartItem(product1, 1));

        assertFalse(cartManager.existsProductInCartItemList(cartItems, "Test"));
    }

    @Test
    void test_UpdateQuantity_Should_True_IfExistsInList() {
        cartItems.add(new CartItem(product1, 1));

        assertTrue(cartManager.updateQuantityByProductTitle(cartItems, product1.getTitle(), 2));
    }

    @Test
    void test_UpdateQuantity_Should_Three() {
        cartItems.add(new CartItem(product1, 1));

        cartManager.updateQuantityByProductTitle(cartItems, product1.getTitle(), 2);
        assertEquals(3, cartItems.get(0).getQuantity());
    }

    @Test
    void test_UpdateQuantity_Should_False_IfNotExistsInList() {
        cartItems.add(new CartItem(product1, 1));

        assertFalse(cartManager.updateQuantityByProductTitle(cartItems, "Test", 2));
    }
}