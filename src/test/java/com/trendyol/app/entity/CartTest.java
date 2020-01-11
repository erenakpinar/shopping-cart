package com.trendyol.app.entity;

import com.trendyol.app.manager.cart.CartManager;
import com.trendyol.app.manager.cart.ICartManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private ICartManager cartManager = Mockito.spy(new CartManager());
    private List<CartItem> cartItems = new ArrayList<>();
    private Category category = new Category("Apple");
    private Product product = new Product("iPhone 7 Plus", 2543.99, category);
    private Product product2 = new Product("iPhone 7", 2000, category);
    private Cart cart;

    @BeforeEach
    void setUp() {

    }

    @Test
    void test_AddItem_ShouldBe_CartItemsSizeOne_IfAddedOneProduct() {
        cart = new Cart(cartManager);
        Mockito.doReturn(cartItems).when(cartManager).addItem(cart.getCartItems(), product, 1);

        cartItems.add(new CartItem(product, 1));
        cart.addItem(product, 1);

        assertEquals(1, cart.getCartItems().size());
    }

    @Test
    void test_AddItem_ShouldBe_CartItemsSizeTwo_IfAddedTwoProduct() {
        cart = new Cart(cartManager);
        Mockito.doReturn(cartItems).when(cartManager).addItem(cart.getCartItems(), product, 1);

        cartItems.add(new CartItem(product, 1));
        cartItems.add(new CartItem(product2, 1));
        cart.addItem(product, 1);
        cart.addItem(product2, 1);

        assertEquals(2, cart.getCartItems().size());
    }

    @Test
    void test_Print() {
        cart = Mockito.spy(new Cart(cartManager));
        cartItems.add(new CartItem(product, 1));
        cartItems.add(new CartItem(product2, 1));
        Mockito.doReturn(cartItems).when(cart).getCartItems();

        cart.print();
    }
}