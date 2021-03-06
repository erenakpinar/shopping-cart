package com.app.manager.cart;

import com.app.entity.CartItem;
import com.app.entity.Category;
import com.app.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {

    private List<CartItem> cartItems;
    private Category category = new Category("Electronic");
    private Category category2 = new Category("Apple");
    private Product product1 = new Product("Iphone", 1000, category);
    private Product product2 = new Product("Iphone 2", 2000, category2);
    private Product product3 = new Product("Iphone 3", 3000, category2);
    private CartManager cartManager = new CartManager();

    @BeforeEach
    void setUp() {
        cartItems = new ArrayList<>();
    }

    @Test
    void test_GetCartItemsByCategory_ShouldBe_CartItemsSizeOne_IfTwoProductsOfDifferentCategoriesAreAdded() {
        cartItems.add(new CartItem(product1, 1));
        cartItems.add(new CartItem(product2, 1));

        assertEquals(1, cartManager.getCartItemsByCategory(cartItems, category).size());
    }

    @Test
    void test_GetCartItemsByCategory_ShouldBe_CartItemsSizeTwo_IfThreeProductsOfDifferentCategoriesAreAdded() {
        cartItems.add(new CartItem(product1, 1));
        cartItems.add(new CartItem(product2, 1));
        cartItems.add(new CartItem(product3, 1));

        assertEquals(2, cartManager.getCartItemsByCategory(cartItems, category2).size());
    }

    @Test
    void test_GetCartItemsTotalAmount() {
        cartItems.add(new CartItem(product1, 6));
        cartItems.add(new CartItem(product2, 3));
        cartItems.add(new CartItem(product3, 2));

        assertEquals(18000, cartManager.getCartItemsTotalAmount(cartItems));
    }

    @Test
    void test_GetCartItemsTotalAmount_ShouldBe_Zero_IfNoProductsAdded() {
        assertEquals(0, cartManager.getCartItemsTotalAmount(cartItems));
    }

    @Test
    void test_GetItemCountInCartItemList_ShouldBe_Eleven_IFAddedElevenItem() {
        cartItems.add(new CartItem(product1, 6));
        cartItems.add(new CartItem(product2, 3));
        cartItems.add(new CartItem(product3, 2));

        assertEquals(11, cartManager.getItemCountInCartItemList(cartItems));
    }

    @Test
    void test_GetItemCountInCartItemList_ShouldBe_Zero_IFCartItemListEmpty() {
        assertEquals(0, cartManager.getItemCountInCartItemList(cartItems));
    }

    @Test
    void test_AddItem_ShouldBe_ListCountOne_IfNotExistsInList() {
        CartManager cartManager = Mockito.spy(this.cartManager);
        Mockito.doReturn(false).when(cartManager).existsProductInCartItemList(cartItems, product1.getTitle());
        cartManager.addItem(cartItems, product1, 1);

        assertEquals(1, cartItems.size());
    }

    @Test
    void test_AddItem_ShouldBe_ListCountOne_IfExistsInList() {
        CartManager cartManager = Mockito.spy(this.cartManager);
        cartItems.add(new CartItem(product1, 1));
        Mockito.doReturn(true).when(cartManager).existsProductInCartItemList(cartItems, product1.getTitle());
        cartManager.addItem(cartItems, product1, 1);

        assertEquals(1, cartItems.size());
    }

    @Test
    void test_ExistsProductInCartItemList_ShouldBe_True_IfExistsInList() {
        cartItems.add(new CartItem(product1, 1));

        assertTrue(cartManager.existsProductInCartItemList(cartItems, product1.getTitle()));
    }

    @Test
    void test_ExistsProductInCartItemList_ShouldBe_False_IfNotExistsInList() {
        cartItems.add(new CartItem(product1, 1));

        assertFalse(cartManager.existsProductInCartItemList(cartItems, "Test"));
    }

    @Test
    void test_UpdateQuantity_ShouldBe_True_IfExistsInList() {
        cartItems.add(new CartItem(product1, 1));

        assertTrue(cartManager.updateQuantityByProductTitle(cartItems, product1.getTitle(), 2));
    }

    @Test
    void test_UpdateQuantity_ShouldBe_Three() {
        cartItems.add(new CartItem(product1, 1));

        cartManager.updateQuantityByProductTitle(cartItems, product1.getTitle(), 2);
        assertEquals(3, cartItems.get(0).getQuantity());
    }

    @Test
    void test_UpdateQuantity_ShouldBe_False_IfNotExistsInList() {
        cartItems.add(new CartItem(product1, 1));

        assertFalse(cartManager.updateQuantityByProductTitle(cartItems, "Test", 2));
    }
}