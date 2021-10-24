package com.codecool.wardrobe.clothing;

public class LowerClothes extends Clothes {

    public LowerClothes(String brandName, ClothesType type) {
        super(brandName);
        super.setId();
        setType(type);
    }

    @Override
    public Object setType(ClothesType type) {
        if(type==ClothesType.TROUSERS || type==ClothesType.SKIRT) {
            super.setType(type);
        }
        else {
            throw new IllegalArgumentException("Not supported clothes type.");
        }
        return null;
    }
}
