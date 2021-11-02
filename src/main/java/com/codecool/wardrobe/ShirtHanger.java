package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.UpperClothes;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class ShirtHanger implements Hanger<UpperClothes> {

    private final ArrayList<Clothes> upperClothesOnHanger = new ArrayList<>();

    @Override
    public Optional<UpperClothes> takeOff() {
        return null;
    }

    @Override
    public Optional<UpperClothes> takeOff(UUID id) {
        return null;
    }

    @Override
    public void put(UpperClothes item) {
        if(item.getType() == Clothes.ClothesType.SHIRT || item.getType() == Clothes.ClothesType.BLOUSE){
            if(upperClothesOnHanger.size()==0){
                upperClothesOnHanger.add(item);
            }
            else {
                throw new IllegalStateException();
            }
        }
        else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean hasSlotFor(Clothes.ClothesType type) {
        return false;
    }
}
