package com.trendyol.app.manager.cart;

import com.trendyol.app.entity.CartItem;
import com.trendyol.app.entity.Product;

import java.util.List;

public interface ICartManager {
    List<CartItem> addItem(List<CartItem> cartItems, Product product, int quantity);
    boolean existsProductInCartItemList(List<CartItem> cartItems, String title);
    boolean updateQuantityByProductTitle(List<CartItem> cartItems, String title, int quantity);
}
