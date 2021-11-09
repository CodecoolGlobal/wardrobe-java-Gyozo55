package com.codecool.wardrobe;

import com.codecool.wardrobe.clothing.Clothes;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class Wardrobe {

    private int wardrobeHangerLimit;
    private final ArrayList<Hanger<? extends Clothes>> hangersInWardrobe = new ArrayList<>();

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
        for(Hanger hanger: hangersInWardrobe){
            if(hanger.hasSlotFor(clothesType)){
                return hanger;
            }
        }
        throw new NoSuchElementException("No empty hangers for your clothes");
    }

    public Clothes getClothes(UUID clothesId) {
        for (Hanger hanger: hangersInWardrobe){
            if(hanger.takeOff(clothesId).isPresent()){
                return (Clothes) hanger.takeOff(clothesId).get();
            }
        }
        throw new NoSuchElementException("Clothes not found.");
    }

    // The main method with this declaration is the entry point of Java applications.
    public static void main(String[] args) {
        // Create an instance of our class with the test data.
        System.out.println("Hello WardROBO");
    }
}
