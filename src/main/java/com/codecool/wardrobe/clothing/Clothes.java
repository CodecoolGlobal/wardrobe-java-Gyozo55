package com.codecool.wardrobe.clothing;

import java.util.UUID;

public class Clothes {
    private UUID id;
    private String brandName;

    protected ClothesType type;

    public Clothes(String brandName, ClothesType type) {
        setId();
        setBrandName(brandName);
        setType(type);
    }

    public UUID getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public ClothesType getType() {
        return this.type;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setType(ClothesType type) {
        for(ClothesType enumType: ClothesType.values())
            if (enumType == type) {
                this.type = type;
                break;
            }
    }

    public enum ClothesType {
        SHIRT,
        BLOUSE,
        TROUSERS,
        SKIRT
    }
}
