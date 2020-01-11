package com.app.entity;

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

    public boolean equals(Category category) {
        return getTitle().equals(category.getTitle());
    }

    public boolean equalsWithParents(Category category, Category searchCategory) {
        if (category.equals(searchCategory)) {
            return true;
        } else if (category.getParentCategory() != null) {
            return equalsWithParents(category.getParentCategory(), searchCategory);
        }

        return false;
    }
}
