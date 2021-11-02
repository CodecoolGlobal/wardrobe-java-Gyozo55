package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;

import java.util.ArrayList;
import java.util.UUID;

public class Wardrobe {

    private int wardrobeHangerLimit;
    private final ArrayList<Hanger> hangersInWardrobe = new ArrayList<>();

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
        return hangersInWardrobe.size();
    }

    public void put(Hanger<? extends Clothes> hanger) {
        if(getLimit()>count()){
            hangersInWardrobe.add(hanger);
        }
        else {
            throw new IllegalStateException("The wardrobe currently is full.");
        }
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
