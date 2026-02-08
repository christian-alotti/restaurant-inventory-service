package com.restaurant.system.domain.inventory.model;

import java.util.Objects;

public class RecipeItem {

    private final Long id;
    private final Ingredient ingredient;
    private final double requiredQuantity;

    public RecipeItem(Long id, Ingredient ingredient, double requiredQuantity) {
        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient must not be null");
        }
        if (requiredQuantity <= 0) {
            throw new IllegalArgumentException("Required quantity must be greater than zero");
        }

        this.id = id;
        this.ingredient = ingredient;
        this.requiredQuantity = requiredQuantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public double getRequiredQuantity() {
        return requiredQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeItem)) return false;
        RecipeItem that = (RecipeItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}