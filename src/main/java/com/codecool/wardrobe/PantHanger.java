package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.Clothes.ClothesType;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class PantHanger implements Hanger<Clothes> {

    private final ArrayList<Clothes> lowerClothesOnHanger = new ArrayList<>();
    private final ArrayList<Clothes> upperClothesOnHanger = new ArrayList<>();

    @Override
    public Optional<Clothes> takeOff() {

        if(upperClothesOnHanger.size()>0 && lowerClothesOnHanger.size()==0){
            return Optional.ofNullable(upperClothesOnHanger.get(0));
        }
        else if(lowerClothesOnHanger.size()>0){
            return Optional.ofNullable(lowerClothesOnHanger.get(0));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Clothes> takeOff(UUID id) {
        return null;
    }

    @Override
    public void put(Clothes item) {
        if(item.getType() == ClothesType.SHIRT || item.getType() == ClothesType.BLOUSE){
            upperClothesOnHanger.add(item);
        }
        else {
            lowerClothesOnHanger.add(item);
        }
    }

    @Override
    public boolean hasSlotFor(ClothesType type) {
        return false;
    }
}
