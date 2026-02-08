package com.restaurant.system.domain.inventory.service;

import com.restaurant.system.domain.inventory.model.Batch;
import com.restaurant.system.domain.inventory.model.RecipeItem;
import com.restaurant.system.domain.menu.model.MenuItem;

import java.time.LocalDate;
import java.util.List;

public class AvailabilityService {

    public boolean isMenuItemAvailable(
            MenuItem menuItem,
            List<Batch> batches,
            LocalDate today
    ) {
        for (RecipeItem recipeItem : menuItem.getRecipe()) {

            double availableQuantity = availableQuantityFor(
                    recipeItem,
                    batches,
                    today
            );

            if (availableQuantity < recipeItem.getRequiredQuantity()) {
                return false;
            }
        }

        return true;
    }

    private double availableQuantityFor(
            RecipeItem recipeItem,
            List<Batch> batches,
            LocalDate today
    ) {
        return batches.stream()
                .filter(batch ->
                        batch.isUsableFor(
                                recipeItem.getIngredient(),
                                today
                        )
                )
                .mapToDouble(Batch::getQuantity)
                .sum();
    }
}
