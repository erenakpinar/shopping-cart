package com.trendyol.app.entity;

import com.trendyol.app.delivery.cost.DeliveryCostCalculator;
import com.trendyol.app.delivery.cost.IDeliveryCostCalculator;
import com.trendyol.app.discount.applier.IDiscountApplier;
import com.trendyol.app.discount.entity.Campaign;
import com.trendyol.app.discount.entity.Coupon;
import com.trendyol.app.manager.cart.ICartManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Cart {
    public static final double DELIVERY_FIXED_COST = 2.99;

    private ICartManager cartManager;
    private IDiscountApplier campaignDiscountApplier;
    private IDiscountApplier couponDiscountApplier;
    private IDeliveryCostCalculator deliveryCostCalculator;

    public Cart(
            ICartManager cartManager,
            IDiscountApplier campaignDiscountApplier,
            IDiscountApplier couponDiscountApplier,
            IDeliveryCostCalculator deliveryCostCalculator
    ) {

        this.cartManager = cartManager;
        this.campaignDiscountApplier = campaignDiscountApplier;
        this.couponDiscountApplier = couponDiscountApplier;
        this.deliveryCostCalculator = deliveryCostCalculator;
    }

    private List<CartItem> items = new ArrayList<CartItem>();
    private double totalAmount = 0;
    private double totalAmountAfterDiscounts = 0;

    private List<Campaign> campaigns = new ArrayList<Campaign>();
    private double campaignDiscount;

    private Coupon coupon;
    private double couponDiscount;

    public List<CartItem> getItems() {
        return items;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    private double getCouponDiscount() {
        return couponDiscount;
    }

    private double getCampaignDiscount() {
        return campaignDiscount;
    }

    public double getTotalAmountAfterDiscounts() {
        return totalAmountAfterDiscounts;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    private void setTotalAmountAfterDiscounts(double amount) {
        totalAmountAfterDiscounts = totalAmountAfterDiscounts > 0 ? amount : 0;
    }

    public void addItem(Product product, int quantity) {
        items = cartManager.addItem(items, product, quantity);
        totalAmount = totalAmountAfterDiscounts = cartManager.getCartItemsTotalAmount(items);
    }

    public void applyDiscounts(Campaign... campaignList) {
        campaigns.addAll(Arrays.asList(campaignList));
        campaignDiscount = campaignDiscountApplier.apply(this);
        setTotalAmountAfterDiscounts(totalAmount - campaignDiscount);
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
        couponDiscount = couponDiscountApplier.apply(this);
        setTotalAmountAfterDiscounts(totalAmountAfterDiscounts - couponDiscount);
    }

    public double getDeliveryCost() {
        return deliveryCostCalculator.calculateFor(this);
    }

    public void print() {
        HashMap<Category, List<CartItem>> cartItems = new HashMap<>();
        getItems().forEach((item) -> {
            Category category = item.getProduct().getCategory();
            if (!cartItems.containsKey(category)) {
                cartItems.put(category, new ArrayList<>());
            }

            cartItems.get(category).add(item);
        });

        cartItems.forEach((category, cartItemList) -> {
            System.out.println("------------" + category.getTitle() + "------------");

            cartItemList.forEach((item) -> {
                Product product = item.getProduct();
                String productTitle = product.getTitle();
                System.out.println("------" + productTitle + "------");

                System.out.println("Product Title: " + productTitle);
                System.out.println("Product Price: " + product.getPrice());
                System.out.println("Product Quantity: " + item.getQuantity());
                System.out.println("Product Category: " + category.getTitle());
                if (category.getParentCategory() != null) {
                    System.out.println("Product Category Parent Category: " + category.getParentCategory().getTitle());
                }
                System.out.println();
            });
        });

        System.out.println("                Total Amount: " + getTotalAmount());
        System.out.println("    Campaign Discount Amount: -" + getCampaignDiscount());
        System.out.println("      Coupon Discount Amount: -" + getCouponDiscount());
        System.out.println("Total Amount After Discounts: " + getTotalAmountAfterDiscounts());
        System.out.println("              Delivery Costs: " + getDeliveryCost());
    }
}
