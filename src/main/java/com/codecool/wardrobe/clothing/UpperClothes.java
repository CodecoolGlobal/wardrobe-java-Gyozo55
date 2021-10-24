package com.codecool.wardrobe.clothing;

public class UpperClothes extends Clothes {

    public UpperClothes(String brandName, ClothesType type) {
        super(brandName);
        super.setId();
        setType(type);
    }

    @Override
    public Object setType(ClothesType type) {
        if(type==ClothesType.SHIRT || type==ClothesType.BLOUSE) {
            super.setType(type);
        }
        else {
            throw new IllegalArgumentException("Not supported clothes type.");
        }
        return null;
    }
}
