package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;
import com.codecool.wardrobe.clothing.Clothes.ClothesType;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class PantHanger implements Hanger<Clothes> {

    private final ArrayList<Clothes> lowerClothesOnHanger = new ArrayList<>();
    private final ArrayList<Clothes> upperClothesOnHanger = new ArrayList<>();

    @Override
    public Optional<Clothes> takeOff() {
        Clothes currentUpperCloth;
        Clothes currentLowerCloth;
        if(upperClothesOnHanger.size()>0){
            currentUpperCloth = upperClothesOnHanger.get(0);
            upperClothesOnHanger.remove(0);
            return Optional.ofNullable(currentUpperCloth);
        }
        else if(lowerClothesOnHanger.size()>0){
            currentLowerCloth = lowerClothesOnHanger.get(0);
            lowerClothesOnHanger.remove(0);
            return Optional.ofNullable(currentLowerCloth);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Clothes> takeOff(UUID id) {
        Clothes currentUpperCloth;
        Clothes currentLowerCloth;
        if(upperClothesOnHanger.size()>0){
            if(upperClothesOnHanger.get(0).getId()==id) {
                currentUpperCloth = upperClothesOnHanger.get(0);
                return Optional.ofNullable(currentUpperCloth);
            }
        }
        else if(lowerClothesOnHanger.size()>0){
            if(lowerClothesOnHanger.get(0).getId()==id) {
                currentLowerCloth = lowerClothesOnHanger.get(0);
                return Optional.ofNullable(currentLowerCloth);
            }
        }
        return Optional.empty();
    }

    @Override
    public void put(Clothes item) {
        if(item.getType() == ClothesType.SHIRT || item.getType() == ClothesType.BLOUSE){
            if(upperClothesOnHanger.size()==0){
                upperClothesOnHanger.add(item);
            }
            else {
                throw new IllegalStateException();
            }
        }
        else if(item.getType() == ClothesType.SKIRT || item.getType() == ClothesType.TROUSERS){
            if(lowerClothesOnHanger.size()==0){
                lowerClothesOnHanger.add(item);
            }
            else{
                throw new IllegalStateException();
            }
        }
    }

    @Override
    public boolean hasSlotFor(ClothesType type) {
        if (type == ClothesType.SHIRT || type == ClothesType.BLOUSE) {
            return upperClothesOnHanger.size() <= 0;
        }
        else if(type == ClothesType.TROUSERS || type == ClothesType.SKIRT){
            return lowerClothesOnHanger.size() <= 0;
        }
        return false;
    }
}
