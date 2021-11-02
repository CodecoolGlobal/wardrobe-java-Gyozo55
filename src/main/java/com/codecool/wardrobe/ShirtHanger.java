package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.UpperClothes;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class ShirtHanger implements Hanger<UpperClothes> {

    private final ArrayList<UpperClothes> upperClothesOnHanger = new ArrayList<>();

    @Override
    public Optional<UpperClothes> takeOff() {
        UpperClothes currentUpperCloth;

        if(upperClothesOnHanger.size()>0){
            currentUpperCloth = upperClothesOnHanger.get(0);
            upperClothesOnHanger.remove(0);
            return Optional.ofNullable(currentUpperCloth);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UpperClothes> takeOff(UUID id) {
        UpperClothes currentUpperCloth;

        if(upperClothesOnHanger.size()>0){
            if(upperClothesOnHanger.get(0).getId()==id) {
                currentUpperCloth = upperClothesOnHanger.get(0);
                upperClothesOnHanger.remove(0);
                return Optional.ofNullable(currentUpperCloth);
            }
        }
        return Optional.empty();
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
