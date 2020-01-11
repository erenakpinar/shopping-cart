package com.trendyol.app.discount.applier;

import com.trendyol.app.discount.calculator.IDiscountCalculator;
import com.trendyol.app.discount.entity.Campaign;
import com.trendyol.app.entity.Cart;
import com.trendyol.app.entity.CartItem;
import com.trendyol.app.manager.cart.ICartManager;

import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class CampaignDiscountApplier implements IDiscountApplier {

    private ICartManager cartManager;
    private IDiscountCalculator discountCalculator;

    public CampaignDiscountApplier(ICartManager cartManager, IDiscountCalculator discountCalculator) {
        this.cartManager = cartManager;
        this.discountCalculator = discountCalculator;
    }

    @Override
    public double apply(Cart cart) {
        if (cart.getCampaigns().size() == 0) {
            return 0;
        }

        HashMap<Double, Campaign> campaigns = new HashMap<>();
        for (Campaign campaign : cart.getCampaigns()) {
            List<CartItem> cartItems = cartManager.getCartItemsByCategory(cart.getItems(), campaign.getCategory());

            int itemCount = cartManager.getItemCountInCartItemList(cartItems);
            double categoryTotalAmount = cartManager.getCartItemsTotalAmount(cartItems);

            if (itemCount >= campaign.getItemCount()) {
                double campaignTotalDiscount = discountCalculator.calculate(
                        categoryTotalAmount,
                        campaign.getDiscount(),
                        campaign.getDiscountType()
                );
                campaigns.put(campaignTotalDiscount, campaign);
            }
        }

        SortedSet<Double> keys = new TreeSet<>(campaigns.keySet());
        return keys.last();
    }
}
