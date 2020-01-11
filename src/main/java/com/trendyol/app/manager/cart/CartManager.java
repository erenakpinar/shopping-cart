package com.trendyol.app.manager.cart;

import com.trendyol.app.entity.CartItem;
import com.trendyol.app.entity.Product;

import java.util.List;
import java.util.function.Predicate;

public class CartManager implements ICartManager {

    @Override
    public List<CartItem> addItem(List<CartItem> cartItems, Product product, int quantity) {
        if (existsProductInCartItemList(cartItems, product.getTitle())) {
            updateQuantityByProductTitle(cartItems, product.getTitle(), quantity);
        } else {
            CartItem cartItem = new CartItem(product, quantity);
            cartItems.add(cartItem);
        }

        return cartItems;
    }

    @Override
    public boolean existsProductInCartItemList(List<CartItem> cartItems, String title) {
        Predicate<CartItem> byProductTitle = item -> item.getProduct().getTitle().equals(title);

        return cartItems.stream()
                .anyMatch(byProductTitle);
    }

    @Override
    public boolean updateQuantityByProductTitle(List<CartItem> cartItems, String title, int quantity) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getTitle().equals(title)) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return true;
            }
        }

        return false;
    }
}
