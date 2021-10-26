package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.Clothes.ClothesType;

import java.util.Optional;
import java.util.UUID;

public class PantHanger implements Hanger<Clothes> {

    private final Optional<Clothes> lowerClothesOnHanger = Optional.empty();
    private final Optional<Clothes> upperClothesOnHanger = Optional.empty();

    @Override
    public Optional<Clothes> takeOff() {
        if(lowerClothesOnHanger.isPresent() || upperClothesOnHanger.isPresent()){
            return upperClothesOnHanger;
        }
        else {
            return lowerClothesOnHanger;
        }
    }

    @Override
    public Optional<Clothes> takeOff(UUID id) {
        return null;
    }

    @Override
    public void put(Clothes item) {

    }

    @Override
    public boolean hasSlotFor(ClothesType type) {
        return false;
    }
}
