package com.restaurant.system.domain.inventory.model;

import java.time.LocalDate;
import java.util.Objects;

public class Batch {

    private final Long id;
    private final Ingredient ingredient;
    private final double quantity;
    private final LocalDate purchaseDate;
    private final LocalDate expiryDate;

    public Batch(
            Long id,
            Ingredient ingredient,
            double quantity,
            LocalDate purchaseDate,
            LocalDate expiryDate
    ) {
        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient must not be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (purchaseDate == null || expiryDate == null) {
            throw new IllegalArgumentException("Dates must not be null");
        }
        if (!expiryDate.isAfter(purchaseDate)) {
            throw new IllegalArgumentException("Expiry date must be after purchase date");
        }

        this.id = id;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired(LocalDate today) {
        return expiryDate.isBefore(today);
    }

    public boolean isUsableFor(Ingredient ingredient, LocalDate today) {
    	return this.ingredient.equals(ingredient) && !isExpired(today);
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Batch)) return false;
        Batch batch = (Batch) o;
        return Objects.equals(id, batch.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}