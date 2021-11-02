package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;

import java.util.UUID;

public class Wardrobe {

    private int wardrobeHangerLimit;

    public Wardrobe(int limit) {
        setWardrobeHangerLimit(limit);
    }

    public void setWardrobeHangerLimit(int wardrobeHangerLimit) {
        if(wardrobeHangerLimit<=120){
            this.wardrobeHangerLimit = wardrobeHangerLimit;
        }
        else {
            throw new IllegalArgumentException("Maximum limit is 120.");
        }
    }


    public int getLimit() {
        return wardrobeHangerLimit;
    }

    public int count() {
        return 0;
    }

    public void put(Hanger<? extends Clothes> hanger) {
    }

    public Hanger<? extends Clothes> getHanger(Clothes.ClothesType clothesType) {
        return null;
    }

    public Clothes getClothes(UUID clothesId) {
        return null;
    }

    // The main method with this declaration is the entry point of Java applications.
    public static void main(String[] args) {
        // Create an instance of our class with the test data.
        System.out.println("Hello WardROBO");
    }
}
