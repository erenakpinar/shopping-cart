package com.app.manager.cart;

import com.app.entity.CartItem;
import com.app.entity.Category;
import com.app.entity.Product;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CartManager implements ICartManager {
    @Override
    public List<CartItem> getCartItemsByCategory(List<CartItem> cartItems, Category campaignCategory) {
        return cartItems
                .stream()
                .filter(i -> i.getProduct().getCategory().equalsWithParents(i.getProduct().getCategory(), campaignCategory))
                .collect(Collectors.toList());
    }

    @Override
    public double getCartItemsTotalAmount(List<CartItem> cartItems) {
        return cartItems
                .stream()
                .mapToDouble(i -> i.getQuantity() * i.getProduct().getPrice())
                .sum();
    }

    @Override
    public int getItemCountInCartItemList(List<CartItem> cartItems) {
        return cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

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
