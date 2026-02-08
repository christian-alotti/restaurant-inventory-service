package com.restaurant.system.domain.inventory.model;

import java.util.Objects;

public class Ingredient {

    private final Long id;
    private final String name;
    private final Unit unit;

    public Ingredient(Long id, String name, Unit unit) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ingredient name must not be blank");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit must not be null");
        }

        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}