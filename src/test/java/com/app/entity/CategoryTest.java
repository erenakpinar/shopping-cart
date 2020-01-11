package com.app.entity;

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
    }

    @Test
    void test_GetParentCategory_ShouldBe_Null_IfNotSet() {
        Category electronicsCategory = new Category("Electronics");

        assertNull(electronicsCategory.getParentCategory());
    }

    @Test
    void test_Equals() {
        Category appleCategory = new Category("Apple");
        Category samsungCategory = new Category("Samsung");

        assertTrue(appleCategory.equals(appleCategory));
        assertFalse(appleCategory.equals(samsungCategory));
    }

    @Test
    void test_EqualsWithParents_ShouldBe_True_IfEquals() {
        Category appleCategory = new Category("Apple");

        assertTrue(appleCategory.equalsWithParents(appleCategory, appleCategory));
    }

    @Test
    void test_EqualsWithParents_ShouldBe_True_IfParentEquals() {
        Category electronicCategory = new Category("Electronic");
        Category appleCategory = new Category("Apple", electronicCategory);
        Category electronicCategory2 = new Category("Electronic");

        assertTrue(appleCategory.equalsWithParents(appleCategory, electronicCategory2));
    }

    @Test
    void test_EqualsWithParents_ShouldBe_False_IfNotEquals() {
        Category appleCategory = new Category("Apple");
        Category electronicCategory = new Category("Electronic");

        assertFalse(appleCategory.equalsWithParents(appleCategory, electronicCategory));
    }
}