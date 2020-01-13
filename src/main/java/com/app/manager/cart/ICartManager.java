package com.app.manager.cart;

import com.app.entity.CartItem;
import com.app.entity.Category;
import com.app.entity.Product;

import java.util.List;

public interface ICartManager {
    List<CartItem> addItem(List<CartItem> cartItems, Product product, int quantity);

    boolean existsProductInCartItemList(List<CartItem> cartItems, String title);

    boolean updateQuantityByProductTitle(List<CartItem> cartItems, String title, int quantity);

    double getCartItemsTotalAmount(List<CartItem> cartItems);

    int getItemCountInCartItemList(List<CartItem> cartItems);

    List<CartItem> getCartItemsByCategory(List<CartItem> cartItems, Category campaignCategory);
}
