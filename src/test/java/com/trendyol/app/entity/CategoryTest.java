package com.trendyol.app.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    @Test
    void test_GetTitle() {
        Category appleCategory = new Category("Apple");

        assertEquals("Apple", appleCategory.getTitle());
    }

    @Test
    void test_GetParentCategory() {
        Category electronicsCategory = new Category("Electronics");
        Category appleCategory = new Category("Apple", electronicsCategory);

        assertEquals(electronicsCategory, appleCategory.getParentCategory());
        assertEquals("Electronics", appleCategory.getParentCategory().getTitle());
        assertNotEquals(appleCategory, appleCategory.getParentCategory());
    }

    @Test
    void test_GetParentCategory_Should_Null_IfNotSet() {
        Category electronicsCategory = new Category("Electronics");

        assertNull(electronicsCategory.getParentCategory());
    }

    @Test
    void test_Equals() {
        Category appleCategory = new Category("Apple");
        Category samsungCategory = new Category("Samsung");

        assertTrue(appleCategory.equals(appleCategory.getTitle()));
        assertFalse(appleCategory.equals(samsungCategory.getTitle()));
    }
}