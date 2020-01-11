package com.trendyol.app.entity;

public class Category {

    private String title;
    private Category parentCategory;

    public Category(String title) {
        this.title = title;
    }

    public Category(String title, Category parentCategory) {
        this.title = title;
        this.parentCategory = parentCategory;
    }

    public String getTitle() {
        return title;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public boolean equals(String title) {
        return getTitle().equals(title);
    }
}
