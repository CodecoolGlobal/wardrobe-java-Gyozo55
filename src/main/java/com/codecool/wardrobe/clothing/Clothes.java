package com.codecool.wardrobe.clothing;

import java.util.UUID;

public class Clothes {
    private UUID id;
    private String brandName;

    protected ClothesType type;

    public Clothes(String brandName, ClothesType type) {
        setId();
        this.brandName = brandName;
        setType(type);
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setType(ClothesType type) {
        for(ClothesType ClothesEnum: ClothesType.values()){
            if (ClothesEnum == type) {
                this.type = type;
                break;
            }
        }
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

    public enum ClothesType {
        SHIRT,
        BLOUSE,
        TROUSERS,
        SKIRT
    }
}
