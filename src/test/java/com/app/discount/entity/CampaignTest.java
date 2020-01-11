package com.app.discount.entity;

import com.app.discount.type.DiscountType;
import com.app.entity.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampaignTest {
    Category category = new Category("Apple");

    @Test
    void test_GetCategory_ShouldBe_Equals_GivenSameCategory() {
        Campaign campaign = new Campaign(category, 10, 2, DiscountType.RATE);

        assertEquals(category, campaign.getCategory());
    }

    @Test
    void test_GetCategory_ShouldBe_NotNull() {
        Campaign campaign = new Campaign(category, 10, 2, DiscountType.RATE);

        assertNotNull(campaign.getCategory());
    }

    @Test
    void test_GetItemCount_Should_Two_IfGivenTwo() {
        Campaign campaign = new Campaign(category, 10, 2, DiscountType.RATE);

        assertEquals(2, campaign.getItemCount());
    }
}